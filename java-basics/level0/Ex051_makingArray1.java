import java.util.Arrays;

// 정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ n ≤ 1,000,000
// 1 ≤ k ≤ min(1,000, n)

public class Ex051_makingArray1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 3))); // [3, 6, 9]
        System.out.println(Arrays.toString(solution(15, 5))); // [5, 10, 15]
    }

    public static int[] solution(int n, int k) {
        int size = n / k; // 배열 크기 설정: k의 배수 개수 = n을 k로 나눈 몫
                           // Set array size: number of multiples of k between 1 and n

        int[] result = new int[size]; // 결과 저장용 배열 생성
                                      // Create array to store results

        int idx = 0; // 배열 인덱스 초기화
                     // Initialize index for result array

        for (int i = 1; i <= n; i++) { // 1부터 n까지 반복
                                       // Loop from 1 to n
            if (i % k == 0) {           // i가 k의 배수인지 확인
                                       // Check if i is a multiple of k
                result[idx] = i;        // 배열에 k의 배수 저장
                                       // Store multiple in array
                idx++;                  // 다음 인덱스로 이동
                                       // Move to next index
            }
        }
        return result; // 결과 배열 반환
                       // Return the result array
    }
}