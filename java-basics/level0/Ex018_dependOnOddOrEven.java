
import java.util.Scanner;

/* 양의 정수 n이 매개변수로 주어질 때, n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고 n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요. 
   제한사항) 1 ≤ n ≤ 100 */

public class Ex018_dependOnOddOrEven {
    public static void main(String[] args) {
        System.out.println(solution(7));
        System.out.println(solution(10));
        System.out.println(solution2());
    }

    public static int solution(int n) {
        int sum = 0;
        if (n % 2 == 1) {
            for (int i = 1; i < n+1; i += 2) {
                sum += i;
            } 
        } else {
            for (int i = 0; i < n+1; i += 2) {
                sum += i * i;
            }
        }
        return sum;
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        if (n % 2 == 1) {
            for (int i = 1; i < n+1; i += 2) {
                sum += i;
            } 
        } else {
            for (int i = 0; i < n+1; i += 2) {
                sum += i * i;
            }
        }
        return sum;
    }
}
