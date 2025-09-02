
import java.util.Scanner;

/* 두 정수 a, b와 boolean 변수 flag가 매개변수로 주어질 때, flag가 true면 a + b를 false면 a - b를 return 하는 solution 함수를 작성해 주세요.
   제한사항) -1,000 ≤ a, b ≤ 1,000 */

public class Ex020_dependsOnFlags {
    public static void main(String[] args) {
        System.out.println(solution(-4, 7, true));
        System.out.println(solution2());
    }

    public static int solution(int a, int b, boolean flag) {
        if (flag) {
            return a + b;
        } else {
            return a - b;
        }
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("a: ");
        int a = sc.nextInt();
        System.out.print("b: ");
        int b = sc.nextInt();
        System.out.print("flag: ");
        boolean flag = sc.nextBoolean();
        return flag ? a + b : a - b;
    }
}

/* if (flag)
 * Checks if flag is true.
 * flag가 true인지 확인한다.
 */

 /* return flag ? a + b : a - b;
  * This is a ternary operator. If flag is true, it calculates a + b if false, it calculates a - b and returns the result.
  * 삼항 연산자이다. flag가 true면 a + b, false면 a - b를 계산해 결과를 반환한다.
  */