
import java.util.Scanner;

/* 1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
   세 숫자가 모두 다르다면 a + b + c 점을 얻습니다. 
   세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a^2 + b^2 + c^2)점을 얻습니다. 
   세 숫자가 모두 같다면 (a + b + c) × (a^2 + b^2 + c^2) × (a^3 + b^3 + c^3)점을 얻습니다.
   세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
   제한사항) a, b, c는 1이상 6이하의 정수입니다. */

public class Ex022_diceGame {
    public static void main(String[] args) {
        System.out.println(solution(2, 6, 1));
        System.out.println(solution2());
    }

    public static int solution(int a, int b, int c) {
        int sum1 = a + b + c;
        int sum2 = (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        int sum3 = (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
        if ((a == b) && (a == c) && (b == c)) {
            System.out.print("result: ");
            return sum3;
        } else if ((a != b) && (a != c) && (b != c)) {
            System.out.print("result: ");
            return sum1;
        } else {
            System.out.print("result: ");
            return sum2;
        }
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("a: ");
        int a =  sc.nextInt();
        System.out.print("b: ");
        int b = sc.nextInt();
        System.out.print("c: ");
        int c = sc.nextInt();

        int sum1 = a + b + c;
        int sum2 = (int)(Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2));
        int sum3 = (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
        if ((a == b) && (a == c) && (b == c)) {
            System.out.print("result: ");
            return sum3;
        } else if ((a != b) && (a != c) && (b != c)) {
            System.out.print("result: ");
            return sum1;
        } else {
            System.out.print("result: ");
            return sum2;
        }
    }
}