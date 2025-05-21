
import java.util.Scanner;

/* 정수 number와 n, m이 주어집니다. number가 n의 배수이면서 m의 배수이면 1을 아니라면 0을 return하도록 solution 함수를 완성해주세요.
   제한사항) 10 ≤ number ≤ 100 , 2 ≤ n, m < 10 */

public class Ex017_commonMultiple {
    public static void main(String[] args) {
        System.out.println(solution(60, 2, 3));
        System.out.println(solution(55, 10, 5));
        System.out.println(solution2());
    }

    public static int solution(int number, int n, int m) {
        if (number % n == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int solution2() {
        Scanner sc = new Scanner((System.in));
        int number = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (number % n == 0 && number % m == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
