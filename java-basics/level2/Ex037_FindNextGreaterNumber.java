// 뒤에 있는 큰 수 찾기

// 정수로 이루어진 배열 numbers가 있습니다. 
// 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
// 정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

// 제한사항
// 4 ≤ numbers의 길이 ≤ 1,000,000
// 1 ≤ numbers[i] ≤ 1,000,000

// 입출력 예
//     numbers	               result
//   [2, 3, 3, 5]	        [3, 5, 5, -1]
// [9, 1, 5, 3, 6, 2]	 [-1, 5, 6, 6, -1, -1]

// 입출력 예 설명
// 입출력 예 #1
// 2의 뒷 큰수는 3입니다. 첫 번째 3의 뒷 큰수는 5입니다. 두 번째 3 또한 마찬가지입니다. 
// 5는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [3, 5, 5, -1]이 됩니다.
// 입출력 예 #2
// 9는 뒷 큰수가 없으므로 -1입니다. 1의 뒷 큰수는 5이며, 5와 3의 뒷 큰수는 6입니다. 6과 2는 뒷 큰수가 없으므로 -1입니다. 
// 위 수들을 차례대로 배열에 담으면 [-1, 5, 6, 6, -1, -1]이 됩니다.

// Find the Next Greater Number

// There is an integer array called numbers.
// For each element in the array, the next greater number is defined as the closest number to its right that is greater than itself.

// Complete the solution function so that it returns an array containing the next greater number for each element in order.
// If there is no next greater number, store -1 instead.

// Constraints
// - 4 ≤ numbers.length ≤ 1,000,000
// - 1 ≤ numbers[i] ≤ 1,000,000

// Examples
// numbers                result
// [2, 3, 3, 5]           [3, 5, 5, -1]
// [9, 1, 5, 3, 6, 2]     [-1, 5, 6, 6, -1, -1]

// Example #1
// - The next greater number of 2 is 3.
// - The next greater number of the first 3 is 5.
// - The next greater number of the second 3 is also 5.
// - Since 5 has no next greater number, its result is -1.
// - Therefore, the answer is [3, 5, 5, -1].

// Example #2
// - 9 has no next greater number, so its result is -1.
// - The next greater number of 1 is 5.
// - The next greater numbers of 5 and 3 are both 6.
// - Since 6 and 2 have no next greater numbers, their results are -1.
// - Therefore, the answer is [-1, 5, 6, 6, -1, -1].

import java.util.Arrays;
import java.util.Stack;

public class Ex037_FindNextGreaterNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2})));
    }

    public static int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1); // 결과 배열을 -1로 초기화 # Initialize the result array with -1

        Stack<Integer> stack = new Stack<>(); // 뒷 큰수를 찾지 못한 인덱스를 저장하는 스택 # Stack that stores indices whose next greater number has not been found

        for (int i = 0; i < numbers.length; i++) {
            // 스택의 맨 위 원소보다 현재 값이 크면 뒷 큰수를 찾은 것 # If the current value is greater than the top value in the stack, the next greater number is found
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop(); // 뒷 큰수를 찾은 인덱스 꺼내기 # Pop the index whose next greater number is found
                result[idx] = numbers[i]; // 해당 인덱스의 뒷 큰수 저장 # Store the next greater number for that index
            }

            stack.push(i); // 현재 인덱스는 아직 뒷 큰수를 모르므로 스택에 저장 # Store the current index because its next greater number is not known yet
        }

        return result;
    }
}