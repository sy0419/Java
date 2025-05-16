/* 정수 a와 b가 주어집니다. 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.
   제한사항) -100,000 ≤ a, b ≤ 100,000
 */

import java.util.Scanner;

public class Ex002_printAandB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("a = " + a + "\nb = " + b);
    }
}

/* Scanner sc = new Scanner(System.in);
 * This creates a Scanner object named sc. Scanner 객체 sc를 생성합니다.
 * System.in represents the standard input (keyboard input). System.in은 키보드 입력을 뜻해요.
 * sc can be used to read input from the user. 이 줄이 있어야 사용자가 입력한 값을 읽을 수 있어요. 
 */

/* int a = sc.nextInt(); / int b = sc.nextInt(); 
 * These two lines read two integers from the user. 사용자가 입력한 정수 두 개를 차례로 읽어서 `a`, `b`에 저장합니다.
 * nextInt() reads the next number typed into the console and converts it to an int. `nextInt()`는 **입력된 값을 정수(int)로 읽어줍니다**.
 * The values are stored in variables a and b.
*/

/* System.out.println("a = " + a + "\nb = " + b);
 * This prints the values of a and b to the console. 이 코드는 변수 a와 b의 값을 콘솔에 출력합니다.
 * "a = " and "b = " are string literals. 
 * "a = "와 "b = "는 문자열 리터럴입니다. → 고정된 텍스트로 그대로 출력되는 문자열을 의미해요.
 * + a and + b concatenate the values of a and b into the string. 
 * + a 와 + b는 각각 변수 a와 b의 값을 문자열에 이어 붙이는 역할을 합니다.
   → 숫자 a와 b가 문자열로 변환되어 출력 문자열에 포함돼요.
 * \n adds a line break, so b is printed on the next line. \n은 줄바꿈 문자입니다. → b의 값이 다음 줄에 출력되도록 해줍니다.
 */