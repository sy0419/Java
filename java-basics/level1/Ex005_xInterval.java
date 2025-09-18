import java.util.Arrays;

// 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

// 제한 조건
// x는 -10000000 이상, 10000000 이하인 정수입니다.
// n은 1000 이하인 자연수입니다.

public class Ex005_xInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));    // [2, 4, 6, 8, 10]
        System.out.println(Arrays.toString(solution(4, 3)));    // [4, 8, 12]
        System.out.println(Arrays.toString(solution(-4, 2)));   // [-4, -8]
    }

    public static long[] solution(int x, int n) {
        long[] result = new long[n];  // 결과를 저장할 long 배열 생성 # Create result array of size n

        for (int i = 0; i < n; i++) {
            result[i] = (long) x * (i + 1);  // x에 (i+1)을 곱해 각 요소 저장 # Store x * (i+1) in each index
        }

        return result;  // 결과 배열 반환 # Return the result array
    }
}