// 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
// 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

// 제한 조건
// n과 m은 각각 1000 이하인 자연수입니다.

import java.util.Scanner;

public class Ex029_printRectangle {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 가로 길이 입력 받음 # Read width
        int m = sc.nextInt(); // 세로 길이 입력 받음 # Read height

        for (int i = 0; i < m; i++) { // m줄 반복 # Loop for height
            System.out.println("*".repeat(n)); // 각 줄에 n개의 * 출력 # Print n stars
        }
    }
}