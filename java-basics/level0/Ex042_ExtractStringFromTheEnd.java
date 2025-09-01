// 문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string의 뒤의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// my_string은 숫자와 알파벳으로 이루어져 있습니다.
// 1 ≤ my_string의 길이 ≤ 1,000
// 1 ≤ n ≤ my_string의 길이

public class Ex042_ExtractStringFromTheEnd {
    public static void main(String[] args) {
        System.out.println(solution("ProgrammerS123", 11)); // Expected output: grammerS123
    }

    public static String solution(String myString, int n) {
        // myString.length() - n: 뒤에서 n글자를 시작할 인덱스 계산
        // Calculate the start index to extract the last n characters.
        return myString.substring(myString.length() - n); 
        // substring(startIndex): startIndex부터 끝까지 부분 문자열 반환
        // Return substring from startIndex to the end of the string.
    }
}