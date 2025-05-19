/* 문자열 my_string과 정수 k가 주어질 때, my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.
   제한사항) 1 ≤ my_string의 길이 ≤ 100 , my_string은 영소문자로만 이루어져 있습니다. , 1 ≤ k ≤ 100  */

public class Ex013_repeatStrings {
    public static void main(String[] args) {
        System.out.println((solution("string", 3)));
        System.out.println("------------------");
        System.out.println((solution2("string", 3)));
    }

    public static String solution(String str, int k) {
        String result = "";
        for (int i = 0; i < k; i++) {
            result += str;
        }
        return result;
    }

    public static String solution2(String str, int k) {
        return str.repeat(k);
    }
}

/* repeat()
 * A Java method that returns a new string made by repeating the original string several times.
 * **문자열(String)**을 여러 번 반복해서 붙인 새로운 문자열을 만들어주는 자바의 기능
 */