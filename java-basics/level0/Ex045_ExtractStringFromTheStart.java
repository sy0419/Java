// 문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// my_string은 숫자와 알파벳으로 이루어져 있습니다.
// 1 ≤ my_string의 길이 ≤ 1,000
// 1 ≤ n ≤ my_string의 길이

public class Ex045_ExtractStringFromTheStart {
    public static void main(String[] args) {
        System.out.println(solution1("ProgrammerS123", 11));
        System.out.println(solution1("He110W0r1d", 5));
        System.out.println(solution2("ProgrammerS123", 11));
        System.out.println(solution2("He110W0r1d", 5));
    }

    public static String solution1(String myString, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            sb.append(myString.charAt(i));
        }
        return sb.toString();
    }

    public static String solution2(String myString, int n) {
        return myString.substring(0, n);
    }
}
