/* 길이가 같은 두 문자열 str1과 str2가 주어집니다.
두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
제한사항) 1 ≤ str1의 길이 = str2의 길이 ≤ 10 , str1과 str2는 알파벳 소문자로 이루어진 문자열입니다. */

public class Ex011_mixStrings {
    public static void main(String[] args) {
        System.out.println(solution("aaaaa", "bbbbb"));
    }

    public static String solution(String str1, String str2) {
        String result = "";
        for (int i = 0; i < str1.length(); i++) {
            result += str1.charAt(i);
            result += str2.charAt(i);
        }
        return result;        
    }
}

/* result += str1.charAt(i);
 * Appends the i-th character of str1 to result. str1의 i번째 문자를 result에 붙여준다.
 * Example: If str1 = "aaaaa", the first character 'a' will be added. 예: str1 = "aaaaa"일 때, 처음엔 'a'가 붙는다.
 */

 /* result += str2.charAt(i);
 * Appends the i-th character of str2 to result. str2의 i번째 문자를 result에 붙여준다.
 * Example: If str2 = "bbbbb", the first character 'a' will be added. 예: str2 = "bbbbb"일 때, 처음엔 'b'가 붙는다.
 */