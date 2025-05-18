
import java.util.Scanner;

/* 두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
   str1과 str2을 이어서 출력하는 코드를 작성해 보세요. */

public class Ex007_printStringConsecutively {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(str1 + str2);

        System.out.println(Solution("Hello", "World"));
    }

    public static String Solution(String str1, String str2) {
        return str1 + str2;
    }
}
