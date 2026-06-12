// 타겟 넘버
//
// n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
// 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
// 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서
// 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
//
// 제한사항
// 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
// 각 숫자는 1 이상 50 이하인 자연수입니다.
// 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
//
// Input Example
// numbers              target      return
// [1, 1, 1, 1, 1]         3           5
// [4, 1, 2, 1]            4           2
//
// Explanation #1
// Same as the example above.
//
// Explanation #2
// +4+1-2+1 = 4
// +4-1+2-1 = 4
// Therefore, return 2 because there are two possible ways.

public class Ex032_TargetNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        int index = 0; // 시작 인덱스 # Starting index
        int sum = 0; // 현재 합 초기값 # Initial sum value

        return dfs(numbers, target, index, sum);
    }

    public static int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 사용했는지 확인 # Check if all numbers have been used
        if (index == numbers.length) {
            // 타겟 넘버를 만들었으면 성공 # Success if target number is reached
            if (sum == target) {
                return 1;
            }
            // 타겟 넘버 실패 # Failed to reach target number
            return 0;
        }
        // 현재 숫자를 더하는 경우 + 빼는 경우 탐색 # Explore adding and subtracting current number
        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}