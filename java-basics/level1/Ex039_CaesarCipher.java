// 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
//  예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

// 제한 조건
// 공백은 아무리 밀어도 공백입니다.
// s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
// s의 길이는 8000이하입니다.
// n은 1 이상, 25이하인 자연수입니다.

public class Ex039_CaesarCipher {
    public static void main(String[] args) {
        System.out.println(solution("AB", 1));     // 예상 출력: "BC"
        System.out.println(solution("z", 1));      // 예상 출력: "a"
        System.out.println(solution("a B z", 4));  // 예상 출력: "e F d"
    }

    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 생성 # Create StringBuilder to store result

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // 현재 문자 가져오기 # Get current character

            if (ch == ' ') {
                sb.append(' '); // 공백은 그대로 추가 # Keep spaces unchanged
            } else if (Character.isUpperCase(ch)) {
                // 대문자일 경우 'A'를 기준으로 계산해서 밀기 # Shift uppercase letters from 'A'
                char shifted = (char) ((ch - 'A' + n) % 26 + 'A');
                sb.append(shifted);
            } else {
                // 소문자일 경우 'a'를 기준으로 계산해서 밀기 # Shift lowercase letters from 'a'
                char shifted = (char) ((ch - 'a' + n) % 26 + 'a');
                sb.append(shifted);
            }
        }

        return sb.toString(); // 최종 결과 문자열 반환 # Return the final encrypted string
    }
}