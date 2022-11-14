package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Game {

    public static final String playerAnswer = "숫자를 입력해주세요 : ";
    public static final String strikeUnit = "스트라이크";
    public static final String ballUnit = "볼 ";
    public static final String nothingUnit = "낫싱";
    public static final String winCondition = "3스트라이크";
    public static final String optionRestartOrEnd = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String restart = "1";
    public static final String playerWinMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String gameEnd = "게임을 종료합니다.";


    public static List<Integer> makeRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void oneGameSet(List<Integer> computer) {
        boolean flag = true;
        while (flag) {
            List<String> player = inputPlayerAnswer();
            String hint = checkAnswer(computer, player);
            System.out.println(hint);
            if (hint.contains(winCondition)) {
                System.out.println(playerWinMessage);
                flag = false;
            }
        }
    }

    private static List<String> inputPlayerAnswer() {
        System.out.print(playerAnswer);
        String myAnswer = Console.readLine();

        String[] splitAnswer = myAnswer.split("");
        ArrayList<String> answerValue = new ArrayList<>(Arrays.asList(splitAnswer));

        if (!(answerValue.size() == 3)) {
            throw new IllegalArgumentException();
        } else {
            System.out.println(myAnswer);
        }

        return answerValue;
    }

    public static String checkAnswer(List<Integer> computer, List<String> player) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computer.get(i), Integer.valueOf(player.get(i)))) {
                strike++;
            }
            if (!Objects.equals(computer.get(i), Integer.valueOf(player.get(i)))
                    && computer.contains(Integer.valueOf(player.get(i)))) {
                ball++;
            }
        }
        int nothing = (3 - strike - ball);
        return giveHint(strike, ball, nothing);
    }

    private static String giveHint(int strike, int ball, int nothing) {
        if (nothing != 3) {
            if (ball == 0) {
                return (strike + strikeUnit);
            } else if (strike == 0) {
                return (ball + ballUnit);
            } else {
                return (ball + ballUnit + strike + strikeUnit);
            }
        } else {
            return (nothingUnit);
        }
    }

    public static void restartOrEndTheGame() {
        boolean flag = true;
        while (flag) {
            System.out.println(optionRestartOrEnd);
            String restartOrEnd = Console.readLine();
            System.out.println(restartOrEnd);
            if (Objects.equals(restartOrEnd, restart)) {
                List<Integer> computerturn = makeRandomNumbers();
                oneGameSet(computerturn);
            } else {
                flag = false;
                System.out.println(gameEnd);
            }
        }
    }

}
