
import java.util.Scanner;

/* 문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.
   두 수가 n과 m이라면
   ">", "=" : n >= m
   "<", "=" : n <= m 
   ">", "!" : n > m
   "<", "!" : n < m
   두 문자열 ineq와 eq가 주어집니다. ineq는 "<"와 ">"중 하나고, eq는 "="와 "!"중 하나입니다. 그리고 두 정수 n과 m이 주어질 때, n과 m이 ineq와 eq의 조건에 맞으면 1을 아니면 0을 return하도록 solution 함수를 완성해주세요. */

public class Ex019_comparison {
    public static void main(String[] args) {
        System.out.println(solution("<", "=", 20, 50));
        System.out.println(solution2());
    }

    public static int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals(">") && eq.equals("=")) {
            if (n >= m) {
                return 1;
            } else {
                return 0;
            }
        } else if (ineq.equals("<") && eq.equals("=")) {
            if (n <= m) {
                return 1;
            } else {
                return 0;
            }
        } else if (ineq.equals(">") && eq.equals("!")) {
            if (n > m) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (n < m) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static int solution2() {
        Scanner sc = new Scanner(System.in);
        String ineq = sc.next();
        String eq = sc.next();
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (ineq.equals(">") && eq.equals("=")) {
            if (n >= m) {
                return 1;
            } else {
                return 0;
            }
        } else if (ineq.equals("<") && eq.equals("=")) {
            if (n <= m) {
                return 1;
            } else {
                return 0;
            }
        } else if (ineq.equals(">") && eq.equals("!")) {
            if (n > m) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (n < m) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
