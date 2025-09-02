// 문자열 my_string과 정수 n이 매개변수로 주어질 때, 
// my_string의 앞의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// my_string은 숫자와 알파벳으로 이루어져 있습니다.
// 1 ≤ my_string의 길이 ≤ 1,000
// 1 ≤ n ≤ my_string의 길이

public class Ex045_ExtractStringFromTheStart {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        // Print test cases
        System.out.println(solution1("ProgrammerS123", 11));  // Output: ProgrammerS
        System.out.println(solution1("He110W0r1d", 5));        // Output: He110
        System.out.println(solution2("ProgrammerS123", 11));  // Output: ProgrammerS
        System.out.println(solution2("He110W0r1d", 5));        // Output: He110
    }

    // 방법 1: StringBuilder를 사용하여 앞의 n글자를 하나씩 추가
    // Method 1: Use StringBuilder to build the substring character by character
    public static String solution1(String myString, int n) {
        StringBuilder sb = new StringBuilder();  // 문자열을 효율적으로 이어붙이기 위한 StringBuilder 생성
        for (int i = 0; i < n ; i++) {
            sb.append(myString.charAt(i));      // 인덱스 i의 문자 추가 / Append character at index i
        }
        return sb.toString();                   // 완성된 문자열 반환 / Return the completed string
    }

    // 방법 2: substring 함수로 바로 앞 n글자를 잘라내기
    // Method 2: Use substring to directly get the first n characters
    public static String solution2(String myString, int n) {
        return myString.substring(0, n);        // 인덱스 0부터 n-1까지 자름 / Slice from index 0 to n-1
    }
}