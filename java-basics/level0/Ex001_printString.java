/*문자열 str이 주어질 때, str을 출력하는 코드를 작성해 보세요.
제한사항) 1 ≤ str의 길이 ≤ 1,000,000 , str에는 공백이 없으며, 첫째 줄에 한 줄로만 주어집니다.
*/

import java.util.Scanner;

public class Ex001_printString {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String a = sc.next();
            System.out.println(a);
        }
    }
}