/* 문자열 str이 주어집니다.
   문자열을 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
   제한사항) 1 ≤ str의 길이 ≤ 10 */

import java.util.Scanner;

public class Ex008_splitStringAsALetters {
    public static void main(String[] args) {
        String str = "Hello";
        solution(str); 
        solution2();
    }

    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int strlen = str.length();
        for (int i = 0; i < strlen; i++) {
           char letter =  str.charAt(i);
           System.out.println(letter);
        }
    }
}

/* String str = "Hello";
 * Stores the string "Hello" in the variable `str`. This prepares a fixed string to be printed below.
 * 문자열 "Hello"를 변수 str에 저장한다. 즉, 고정된 문자열을 준비해놓고 아래에서 출력할 준비를 하는 것.
 */

/* solution(str); 
 * Calls the `solution` method with the "Hello" string. This starts the process of printing "Hello" vertically.
 * 위에서 만든 "Hello" 문자열을 solution 메서드에 전달해서 실행한다. 즉, 이 줄에서 Hello를 세로로 출력하는 작업이 시작된다.
 */

/* solution2();
 * Calls the `solution2()` method. This method takes input from the user and prints each character vertically.
 * solution2() 메서드를 호출한다. 이 메서드는 사용자 입력을 받아서 글자를 하나씩 세로로 출력할 것이다.
 */

/* for (int i = 0; i < str.length(); i++)
 * A for-loop that starts with i = 0, continues while i is less than the string's length, and increments i by 1 each time.
 * It allows us to access every character in the string.
 * for 반복문 - i는 0부터 시작하고, i가 str의 길이보다 작을 때까지, i++로 하나씩 증가하면서 반복한다.
 * 즉, 문자열의 모든 글자에 접근하기 위한 반복문이다.
 */

/* System.out.println(str.charAt(i));
 * It allows us to access every character in the string. 문자열 str에서 i번째 문자를 꺼내서 출력한다.
 * `charAt(i)` returns the character at the given position. charAt(i)는 문자열에서 해당 인덱스의 문자를 반환한다.
 * Example: "Hello".charAt(1) → 'e' 예: "Hello".charAt(1) → 'e'
 */

/* Scanner sc = new Scanner(System.in);
 * Creates a Scanner object to receive user input. 사용자로부터 입력을 받기 위한 Scanner 객체 생성.
 * System.in → The input will come from the keyboard. 키보드 입력을 의미한다.
 */

/* String str = sc.nextLine();
 * Stores a full line of user input into the variable `str`. 사용자가 입력한 한 줄 문자열을 str 변수에 저장한다.
 */

/* int strlen = str.length();
 * Calculates the length of the input string and stores it in `strlen`. 문자열의 길이를 구해서 strlen에 저장한다.
 * This value is used in the for-loop to control how many times it runs. 이걸 for 반복문에서 사용하려고 따로 변수로 저장한 것이다.
 */