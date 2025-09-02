/* 음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 9로 나눈 나머지와 같은 것이 알려져 있습니다.
   이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.
   제한사항
   1 ≤ number의 길이 ≤ 100,000
   number의 원소는 숫자로만 이루어져 있습니다.
   number는 정수 0이 아니라면 숫자 '0'으로 시작하지 않습니다. */

import java.util.Scanner;

public class Ex038_remainder {
    public static void main(String[] args) {
        System.out.println(solution("123"));
        System.out.println(solution("78720646226947352489"));
        System.out.println(solution2());
    }

    public static int solution(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            int digit = ch - '0';
            sum += digit;
        }
        return sum % 9;
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("String number: ");
        String number = sc.next();
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            int digit = ch - '0';
            sum += digit;
        }
        return sum % 9;
    }
}

/* for (int i = 0; i < number.length(); i++) 
 * Repeats as many times as the length of the string `number`.
 * For example, if number is "123", the loop runs 3 times (i = 0, 1, 2).
 * number 문자열의 길이만큼 반복한다. 예: "123"이면 3번 반복 (i = 0, 1, 2)
 */

/* char ch = number.charAt(i);
 * Gets the character at index `i`.
 * For example, if i = 0, then ch = '1'; if i = 1, then ch = '2'.
 * i번째 글자를 꺼낸다. 예: i=0이면 '1', i=1이면 '2'.
 */

/* int digit = ch - '0';
 * Converts a character like '3' into the actual number 3.
 * Since '0' has an ASCII value of 48, this works using ASCII code subtraction.
 * 문자 '3' 같은 걸 실제 숫자 3으로 바꾸는 코드이다.
 * '0'은 문자 48이기 때문에, 아스키 코드 연산으로 가능히디.
 */

/* sum += digit;
 * Keeps adding the converted digit to the total sum. For example, '1' → 1, '2' → 2, so sum becomes 3.
 * 변환한 숫자를 계속 누적해서 더한다. 예: '1' → 1, '2' → 2 → sum = 3
 */