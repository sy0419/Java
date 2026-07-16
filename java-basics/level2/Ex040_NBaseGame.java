// N진수 게임

// 튜브가 활동하는 코딩 동아리에서는 전통적으로 해오는 게임이 있다.
// 이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.
// 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
// 10 이상의 숫자부터는 한 자리씩 끊어서 말한다.
// 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
// 이렇게 게임를 진행할 경우,
// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, …
// 순으로 숫자를 말하면 된다.
// 한편 코딩 동아리 일원들은 컴퓨터를 다루는 사람답게 이진수로 이 게임을 진행하기도 하는데, 이 경우에는
// 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, … 순으로 숫자를 말하면 된다.
// 이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해 이진법에서 십육진법까지 모든 진법으로
// 게임을 진행해보기로 했다. 숫자 게임이 익숙하지 않은 튜브는 게임에 져서 벌칙을 받는 굴욕을 피하기 위해,
// 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 튜브의 프로그램을 구현하라.

// 입력 형식
// 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.
// 2 ≦ n ≦ 16
// 0 ＜ t ≦ 1000
// 2 ≦ m ≦ 100
// 1 ≦ p ≦ m

// 출력 형식
// 튜브가 말해야 하는 숫자 t개를 공백 없이 차례대로 나타낸 문자열.
// 단, 10~15는 각각 대문자 A~F로 출력한다.

// 입출력 예제
// n    t    m    p    result
// 2    4    2    1    "0111"
// 16   16   2    1    "02468ACE11111111"
// 16   16   2    2    "13579BDF01234567"

// N-Base Game
// Tube's coding club traditionally plays the following number game.
// Several players sit in a circle and take turns saying numbers according to the rules below.
// Starting from 0, players say numbers in order.
// The first player says 0, the second player says 1, ..., and the tenth player says 9.
// Starting from 10, each digit is spoken separately.
// For example, the eleventh player says the first digit of 10 ("1"),
// and the twelfth player says the second digit ("0").
// Therefore, the spoken sequence becomes:
// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, ...
// Sometimes the game is played in binary instead of decimal.
// In binary, the spoken sequence becomes:
// 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, ...
// To increase the difficulty, the club decided to play the game using every base from 2 to 16.
// Tube wants to avoid losing the game,
// so he plans to create a program that prints in advance
// the digits he has to say.

// Input
// n : base
// t : number of digits Tube must say
// m : number of players
// p : Tube's turn
// 2 ≤ n ≤ 16
// 0 < t ≤ 1000
// 2 ≤ m ≤ 100
// 1 ≤ p ≤ m

// Output
// Return a string containing the t digits Tube should say.
// Digits from 10 to 15 should be represented as uppercase A~F.

// Example
// n    t    m    p    result
// 2    4    2    1    "0111"
// 16   16   2    1    "02468ACE11111111"
// 16   16   2    2    "13579BDF01234567"

public class Ex040_NBaseGame {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {

        // 전체 게임에서 말하는 숫자를 저장한다. # Store all digits spoken during the game.
        StringBuilder numbers = new StringBuilder();

        // 튜브가 말해야 하는 숫자를 저장한다.
        // Store only the digits that Tube should say.
        StringBuilder result = new StringBuilder();

        // 현재 N진수로 변환할 숫자 # Current number to convert into base N.
        int num = 0;

        // 튜브의 첫 번째 차례 인덱스 # Starting index of Tube's first turn.
        int index = p - 1;

        // 튜브가 필요한 문자 수를 모두 얻을 때까지 전체 문자열을 생성한다.
        // Generate enough digits until Tube can obtain all required characters.
        while (numbers.length() < (p - 1) + (t - 1) * m + 1) {
            numbers.append(Integer.toString(num, n).toUpperCase());
            num++;
        }

        // 튜브의 차례에 해당하는 문자만 추출한다. # Extract only the characters spoken by Tube.
        for (int i = 0; i < t; i++) {

            // 현재 차례의 문자를 결과에 추가한다. # Append the current character to the result.
            result.append(numbers.charAt(index));

            // 다음 튜브의 차례로 이동한다. # Move to Tube's next turn.
            index += m;
        }

        return result.toString();
    }
}