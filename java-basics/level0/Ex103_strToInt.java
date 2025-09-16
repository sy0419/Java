// 숫자로만 이루어진 문자열 n_str이 주어질 때, n_str을 정수로 변환하여 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n_str ≤ 5
// n_str은 0부터 9까지의 정수 문자로만 이루어져 있습니다.

public class Ex103_strToInt {
    public static void main(String[] args) {
        System.out.println(solution("10"));    // 테스트 케이스 1 출력 # Output for test case 1
        System.out.println(solution("8542"));  // 테스트 케이스 2 출력 # Output for test case 2
    }

    public static int solution(String nStr) {
        int num = Integer.parseInt(nStr);  // 문자열을 정수로 변환 # Convert string to integer using parseInt
        return num;                        // 변환한 정수를 반환 # Return the converted integer
    }
}