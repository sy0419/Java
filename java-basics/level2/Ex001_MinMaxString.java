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
    }

    public static String solution(String s) {
        String[] parts = s.split(" ");

        // 초기값 설정 (첫 번째 값 기준) / Initialize with first element
        int min = Integer.parseInt(parts[0]);
        int max = Integer.parseInt(parts[0]);

        // 전체 순회하면서 최소/최대 갱신 / Traverse all elements to update min/max
        for (String part : parts) {
            int num = Integer.parseInt(part);

            // 최소값 갱신 / Update minimum value
            if (num < min) {
                min = num;
            }

            // 최대값 갱신 / Update maximum value
            if (num > max) {
                max = num;
            }
        }

        // 결과 문자열 반환 / Return formatted result string
        return min + " " + max;
    }
}