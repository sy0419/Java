/* 문자열 str이 주어집니다.
   문자열을 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.
   제한사항) 1 ≤ str의 길이 ≤ 10 */

import java.util.Scanner;

public class Ex008_splitStringAsALetters {
    public static void main(String[] args) {
        String str = "Hello";
        solution(str); 
        solution2();
    }

    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int strlen = str.length();
        for (int i = 0; i < strlen; i++) {
           char letter =  str.charAt(i);
           System.out.println(letter);
        }
    }
}
