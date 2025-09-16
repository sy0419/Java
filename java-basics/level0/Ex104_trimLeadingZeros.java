// 정수로 이루어진 문자열 n_str이 주어질 때, n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 2 ≤ n_str ≤ 10
// n_str이 "0"으로만 이루어진 경우는 없습니다.

public class Ex104_trimLeadingZeros {
    public static void main(String[] args) {
        System.out.println(solution1("0010"));    // 출력: 10 # Output: 10
        System.out.println(solution1("854020"));  // 출력: 854020 # Output: 854020
        System.out.println(solution2("0010"));    // 출력: 10 # Output: 10
        System.out.println(solution2("854020"));  // 출력: 854020 # Output: 854020
    }

    public static String solution1(String nStr) {
        // 정규식으로 문자열 앞에 연속된 0 제거 # Remove leading zeros from the string using regex
        return nStr.replaceFirst("^0+", "");  
    }

    public static String solution2(String nStr) {
        // 문자열을 정수형으로 변환 후 다시 문자열로 변환하여 선행 0 제거 # Convert to integer and back to string to remove leading zeros
        return "" + Integer.valueOf(nStr);  
    }
}