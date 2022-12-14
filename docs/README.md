숫자 야구 게임 설계
================

# 📚 기능 목록

1. 랜덤으로 1부터 9까지 서로 다른 수 3자리를 생성한다.  [✔]
   * `import camp.nextstep.edu.missionutils.Randoms;`의 `Randoms.pickNumberInRange(1, 9)`를 사용하여 랜덤으로 숫자를 입력받는다. [✔]
   * 숫자는 리스트에 넣는다. [✔]
   * 서로 다른 숫자를 뽑기 위해서 하나씩 숫자를 뽑아 리스트에 있는지 확인하고 없다면 넣는 작업 [✔]
<br><br>
2. 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력 받는다. [✔]
<br><br>
3. 입력한 값과 비교를 시작한다.
   * 같은 수가 같은 자리에 있으면 스트라이크이란 힌트를 출력한다. [✔]
   * 다른 자리에 있으면 볼이란 힌트를 출력한다. [✔]
   * 같은 수가 전혀 없으면 낫싱이란 힌트를 출력한다. [✔]
   >  예) 상대방(컴퓨터)의 수가 425일 때
   >    - 123을 제시한 경우 : 1스트라이크
   >    - 456을 제시한 경우 : 1볼 1스트라이크
   >    - 789를 제시한 경우 : 낫싱
   >    - 425를 제시한 경우 : 3스트라이크
<br><br>
4. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 아래 말과 함께 게임이 종료된다. [✔]
```
“3개의 숫자를 모두 맞히셨습니다! 게임 종료”
```
5. 게임을 종료한 후 아래의 선택지를 주어 게임을 다시 시작하거나 완전히 종료할 수 있다. [✔]
```
“게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.”
```
6. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. [✔]

# 📝 Test 목록

1. 랜덤 숫자를 생성하는 리스트에 3자리가 생성되는가? [✔]
2. 랜덤 숫자를 생성하는 리스트에 있는 3자리의 숫자가 1부터 9까지의 숫자 중에 서로 다른 수가 들어가 있는가? [✔]
3. player의 입력값과 컴퓨터의 랜덤값을 비교해 보았을 때 `"1볼 1스트라이크"`가 나와야 하는 상황에 맞게 잘 출력 되는가? [✔]
4. player의 입력값과 컴퓨터의 랜덤값을 비교해 보았을 때 모두 다른 값이므로 `"낫싱"`이 잘 출력되는가? [✔]
5. player의 입력값과 컴퓨터의 랜덤값을 비교해 보았을 때 정답일 때 상황에 맞게 잘 출력 되는가? [✔]
6. 정답일 경우 종료가 된 후 재시작할 것인지 완전 종료할 것인지 묻고 완전 종료 선택이 가능한가? [✔]
7. 아무 숫자도 입력하지 않았을 때 `"IllegalArgumentException"`을 반환하는가?  [✔]
8. 게임을 종료한 후 `“게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.”`를 물어 게임을 다시 시작하거나 완전히 종료할 수 있는가? [✔]
9. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되는가? [✔]