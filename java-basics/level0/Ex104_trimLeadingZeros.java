// 정수로 이루어진 문자열 n_str이 주어질 때, n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ n_str ≤ 10
// n_str이 "0"으로만 이루어진 경우는 없습니다.

public class Ex104_trimLeadingZeros {
    public static void main(String[] args) {
        System.out.println(solution("0010"));    // 출력: 10 # Output: 10
        System.out.println(solution("854020"));  // 출력: 854020 # Output: 854020
    }

    public static String solution(String nStr) {
        return nStr.replaceFirst("^0+", "");  // 문자열 앞의 연속된 0 제거 # Remove leading zeros from the string using regex
    }
}