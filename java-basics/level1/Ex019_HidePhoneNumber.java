// 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다. 
// 전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

// 제한 조건
// phone_number는 길이 4 이상, 20이하인 문자열입니다.

public class Ex019_HidePhoneNumber {
    public static void main(String[] args) {
        System.out.println(solution("01033334444"));  // *******4444 출력 # prints *******4444
        System.out.println(solution("027778888"));    // *****8888 출력 # prints *****8888
    }

    public static String solution(String phoneNumber) {
        StringBuilder sb = new StringBuilder();  // 결과를 조합할 StringBuilder 생성 # Create StringBuilder to build the result
        int n = phoneNumber.length();             // 전화번호 길이 구하기 # Get length of the phone number
        String last4 = phoneNumber.substring(n-4, n); // 뒤 4자리 추출 # Extract last 4 characters
        int hidingN = n - 4;                       // 가려야 할 자리 수 계산 # Calculate how many characters to hide
        
        for (int i = 0; i < hidingN; i++) {
            sb.append("*");                        // 앞 부분을 '*'로 대체 # Replace the front part with '*'
        }
        sb.append(last4);                         // 마지막 4자리 원본 번호 붙이기 # Append the last 4 digits

        return sb.toString();                     // 최종 문자열 반환 # Return the final string
    }
}