// 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

// 재한사항
// s는 길이가 1 이상, 100이하인 스트링입니다.

public class Ex020_MiddleChar {
    public static void main(String[] args) {
        System.out.println(solution("abcde"));  // "c" 출력 # prints "c"
        System.out.println(solution("qwer"));   // "we" 출력 # prints "we"
    }

    public static String solution(String s) {
        int length = s.length();                           // 문자열 길이 계산 # Get string length
        if (length % 2 == 1) {                              // 홀수 길이인 경우 # If length is odd
            return s.substring(length / 2, length / 2 + 1); // 가운데 글자 한 개 반환 # Return one middle character
        } else {                                            // 짝수 길이인 경우 # If length is even
            return s.substring(length / 2 - 1, length / 2 + 1); // 가운데 글자 두 개 반환 # Return two middle characters
        }
    }
}