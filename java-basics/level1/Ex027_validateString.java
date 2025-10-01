// 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
// 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

// 제한 사항
// s는 길이 1 이상, 길이 8 이하인 문자열입니다.
// s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.

public class Ex027_validateString {
    public static void main(String[] args) {
        System.out.println(solution("a234")); // false
        System.out.println(solution("1234")); // true
    }

    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false; // 길이가 4 또는 6이 아니면 false # Return false if length is not 4 or 6
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false; // 숫자가 아닌 문자가 하나라도 있으면 false # Return false if any char is not a digit
        }

        return true; // 모든 조건을 만족하면 true 반환 # Return true if all checks passed
    }
}