/* 두 정수 a, b가 주어질 때 다음과 같은 형태의 계산식을 출력하는 코드를 작성해 보세요. a + b = c
 * 제한사항) 1 ≤ a, b ≤ 100
 */

import java.util.Scanner;

public class Ex006_addition {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}