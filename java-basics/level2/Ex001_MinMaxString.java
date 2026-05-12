// 최댓값과 최솟값

// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
// s에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
// 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

// 제한 조건
// s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

// 입출력 예
//       s	        return
//   "1 2 3 4"	     "1 4"
// "-1 -2 -3 -4"	"-4 -1"
//    "-1 -1"	    "-1 -1"

public class Ex001_MinMaxString {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("-1 -1"));

        System.out.println(solution2("1 2 3 4"));
        System.out.println(solution2("-1 -2 -3 -4"));
        System.out.println(solution2("-1 -1"));
    }

    public static String solution(String s) {
        // 문자열을 공백 기준으로 분리 # Split string by spaces
        String[] parts = s.split(" ");

        // 첫 번째 값을 기준으로 최소/최대 초기화 # Initialize min/max with first element
        int min = Integer.parseInt(parts[0]);
        int max = Integer.parseInt(parts[0]);

        // 모든 값을 순회하면서 직접 비교 # Traverse all values and compare manually
        for (String part : parts) {
            int num = Integer.parseInt(part);

            // 현재 값이 더 작으면 최소값 갱신 # Update min if current value is smaller
            if (num < min) {
                min = num;
            }

            // 현재 값이 더 크면 최대값 갱신 # Update max if current value is larger
            if (num > max) {
                max = num;
            }
        }

        // 결과 문자열 반환 # Return result as formatted string
        return min + " " + max;
    }

    public static String solution2(String s) {
        // 문자열을 공백 기준으로 분리 # Split string by spaces
        String[] parts = s.split(" ");

        // 첫 번째 값을 기준으로 최소/최대 초기화 # Initialize min/max with first element
        int min = Integer.parseInt(parts[0]);
        int max = Integer.parseInt(parts[0]);

        // Math 클래스를 이용한 간결한 방식 # Cleaner approach using Math class
        for (String part : parts) {
            int num = Integer.parseInt(part);

            // Math.min / Math.max로 한 줄 처리 # One-line update using Math.min/max
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // 결과 문자열 반환 # Return formatted result string
        return min + " " + max;
    }
}