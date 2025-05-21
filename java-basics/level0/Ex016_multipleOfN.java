
import java.util.Scanner;

/* 정수 num과 n이 매개 변수로 주어질 때, num이 n의 배수이면 1을 return n의 배수가 아니라면 0을 return하도록 solution 함수를 완성해주세요.
   제한사항) 2 ≤ num ≤ 100 , 2 ≤ n ≤ 9 */

public class Ex016_multipleOfN {
    public static void main(String[] args) {
        System.out.println(solution(98, 2));
        System.out.println(solution(34, 3));
        System.out.println(solution2());
    }

    public static int solution(int num, int n) {
        if (num % n == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = sc.nextInt();
        if (num % n == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
