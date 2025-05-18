
import java.util.Scanner;

/* 자연수 n이 입력으로 주어졌을 때 만약 n이 짝수이면 "n is even"을, 홀수이면 "n is odd"를 출력하는 코드를 작성해 보세요.
   제한사항) 1 ≤ n ≤ 1,000 */

public class Ex009_oddEven {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 1) {
            System.out.println("n is odd.");
        } else {
            System.out.println("n is even.");
        }
    }
}
