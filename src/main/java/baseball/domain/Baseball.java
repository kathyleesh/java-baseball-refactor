package baseball.domain;

import java.util.List;

public class Baseball {
    public static final String gameStartMessage = "숫자 야구 게임을 시작합니다.";

    public Baseball() {
        System.out.println(gameStartMessage);

        List<Integer> computer = Game.makeRandomNumbers();
        Game.oneGameSet(computer);

        Game.restartOrEndTheGame();
    }
}
