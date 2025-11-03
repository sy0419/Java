// 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
// 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
// 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
// nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

public class Ex056_primeSumCount {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4})); // 테스트 케이스 1 출력 # Test case 1 output
        System.out.println(solution(new int[] {1, 2, 7, 6, 4})); // 테스트 케이스 2 출력 # Test case 2 output
    }

    public static int solution(int[] nums) {
        int result = 0; // 소수의 개수를 저장할 변수 # Variable to store count of prime sums
        for (int i = 0; i < nums.length - 2; i++) { // 첫 번째 수 선택 # Select first number
            for (int j = i + 1; j < nums.length - 1; j++) { // 두 번째 수 선택 # Select second number
                for (int k = j + 1; k < nums.length; k++) { // 세 번째 수 선택 # Select third number
                    int sum = nums[i] + nums[j] + nums[k]; // 선택한 3수의 합 계산 # Calculate sum of three numbers
                    if (sum > 1) { // 1보다 큰 경우만 소수 판별 # Only check if sum is greater than 1
                        boolean isPrime = true; // 소수 여부 플래그 # Flag for prime check
                        int sqrt = (int) Math.sqrt(sum); // 반복 전에 제곱근 계산 # Calculate square root once
                        for (int x = 2; x <= sqrt; x++) {
                            if (sum % x == 0) { // 나누어 떨어지면 소수가 아님 # Not prime if divisible
                                isPrime = false;
                                break; // 더 이상 확인 필요 없음 # No need to check further
                            }
                        }
                        if (isPrime) {
                            result++; // 소수면 카운트 증가 # Increment count if prime
                        }
                    }
                }
            }
        }
        return result; // 최종 결과 반환 # Return final count
    }
}