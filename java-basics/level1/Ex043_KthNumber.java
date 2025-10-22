// 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
// 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

// array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
// 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
// 2에서 나온 배열의 3번째 숫자는 5입니다.
// 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
// commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// array의 길이는 1 이상 100 이하입니다.
// array의 각 원소는 1 이상 100 이하입니다.
// commands의 길이는 1 이상 50 이하입니다.
// commands의 각 원소는 길이가 3입니다.

import java.util.Arrays;

public class Ex043_KthNumber {
    public static void main(String[] args) {
        // 테스트 케이스 실행 # Run test cases
        System.out.println(Arrays.toString(solution(
            new int[] {1, 5, 2, 6, 3, 7, 4}, 
            new int[][] { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} }
        )));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length]; // 결과를 저장할 배열 # Array to store final result

        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0] - 1; // 시작 인덱스 조정 (1-based → 0-based) # Adjust start index
            int j = commands[t][1];     // 끝 인덱스는 그대로 사용 (Arrays.copyOfRange에서 끝은 미포함) # End index (exclusive)
            int k = commands[t][2] - 1; // k번째 값도 0-based로 변환 # Adjust k to 0-based

            int[] sliced = Arrays.copyOfRange(array, i, j); // 배열 자르기 # Slice subarray
            Arrays.sort(sliced);                            // 정렬하기 # Sort the subarray
            int number = sliced[k];                         // k번째 값 추출 # Get the k-th element

            result[t] = number; // 결과 배열에 저장 # Store in result array
        }

        return result; // 결과 반환 # Return final result
    }
}