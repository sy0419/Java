/* 문자열 myString과 이차원 정수 배열 queries가 매개변수로 주어집니다. queries의 원소는 [s, e] 형태로, 
   myString의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다. 
   myString에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.
   제한사항
   myString은 영소문자로만 이루어져 있습니다.
   1 ≤ myString의 길이 ≤ 1,000
   queries의 원소는 [s, e]의 형태로 0 ≤ s ≤ e < myString의 길이를 만족합니다.
   1 ≤ queries의 길이 ≤ 1,000 */

public class Ex039_reverseString {
    public static void main(String[] args) {
        System.out.println(solution("rermgorpsam", new int[][] {{2, 3}, {0, 7}, {5, 9}, {6, 10}}));
    }

    public static String solution(String myString, int[][] queries) {
        StringBuilder sb = new StringBuilder(myString);
        for (int[] querie : queries) {
            int s = querie[0];
            int e = querie[1];
            String part = sb.toString().substring(s, e + 1);
            StringBuilder reversed = new StringBuilder(part).reverse();
            for (int i = 0; i < reversed.length(); i++) {
                sb.setCharAt(s + i, reversed.charAt(i));
            }
        }
        return sb.toString();
    }
}
