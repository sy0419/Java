// 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

// 제한 사항
// 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
// 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

public class Ex036_StrangeString {
    public static void main(String[] args) {
        System.out.println(solution("try hello world")); // TrY HeLlO WoRlD 출력 예상 # Expected: TrY HeLlO WoRlD
    }

    public static String solution(String s) {
        String result = ""; // 결과 문자열을 저장할 변수 # Variable to store the final result
        int wordIndex = 0; // 단어 내 인덱스를 추적할 변수 # Tracks character index within the current word

        for (int i = 0; i < s.length(); i++) { // 문자열을 한 글자씩 순회 # Iterate each character in the string
            char ch = s.charAt(i); // 현재 글자 가져오기 # Get current character

            if (ch == ' ') { // 공백인 경우 처리 # If current character is a space
                result += " "; // 결과에 공백 추가 # Append space to result
                wordIndex = 0; // 단어 인덱스 초기화 # Reset word index for the next word
            } else {
                if (wordIndex % 2 == 0) { // 짝수 인덱스면 대문자 # Even index: convert to uppercase
                    result += Character.toUpperCase(ch);
                } else { // 홀수 인덱스면 소문자 # Odd index: convert to lowercase
                    result += Character.toLowerCase(ch);
                }
                wordIndex++; // 단어 내 인덱스 증가 # Move to next character in word
            }
        }

        return result; // 최종 결과 반환 # Return the final result
    }
}