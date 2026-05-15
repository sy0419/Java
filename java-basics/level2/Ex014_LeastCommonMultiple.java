// 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 
// 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, 
// n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
// n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

// 제한 사항
// arr은 길이 1이상, 15이하인 배열입니다.
// arr의 원소는 100 이하인 자연수입니다.

// 입출력 예
//    arr       result
// [2,6,8,14]	 168
//  [1,2,3]	      6

public class Ex014_LeastCommonMultiple {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 6, 8, 14}));
        System.out.println(solution(new int[] {1, 2, 3}));
    }

    public static int solution(int[] arr) {

        // 첫 번째 값을 초기 최소공배수로 설정 # Set first value as initial LCM
        int result = arr[0];

        // 배열의 모든 수와 최소공배수 누적 계산 # Calculate cumulative LCM for all numbers
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }

        // 최종 최소공배수 반환 # Return final LCM
        return result;
    }

    public static int gcd(int a, int b) {

        // 유클리드 호제법으로 최대공약수 계산 # Calculate GCD using Euclidean algorithm
        while (b != 0) {

            // 나머지 저장 # Store remainder
            int temp = a % b;

            // 작은 값을 a로 변경 # Replace a with smaller value
            a = b;

            // 나머지를 b로 변경 # Replace b with remainder
            b = temp;
        }

        // 최대공약수 반환 # Return GCD
        return a;
    }

    public static int lcm(int a, int b) {

        // 최소공배수 공식 적용 # Apply LCM formula
        int lcm = a * b / gcd(a, b);

        // 최소공배수 반환 # Return LCM
        return lcm;
    }
}