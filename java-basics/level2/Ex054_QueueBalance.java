// 두 큐 합 같게 만들기
// 길이가 같은 두 개의 큐가 주어집니다.
// 하나의 큐를 골라 원소를 추출(pop)하고,
// 추출된 원소를 다른 큐에 집어넣는(insert) 작업을 통해
// 각 큐의 원소 합이 같도록 만들려고 합니다.
// 이때 필요한 작업의 최소 횟수를 구하고자 합니다.
// 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.
// 큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다.
// 이 문제에서는 큐를 배열로 표현하며,
// 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다.
// 즉, pop을 하면 배열의 첫 번째 원소가 추출되며,
// insert를 하면 배열의 끝에 원소가 추가됩니다.
// 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우,
// -1을 return 합니다.

// 제한사항
// 1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
// 1 ≤ queue1의 원소, queue2의 원소 ≤ 10^9
// 합 계산 과정에서 오버플로우가 발생할 수 있으므로 long 타입을 고려해야 합니다.

// 입출력 예
//   queue1                 queue2                   result
// [3, 2, 7, 2]          [4, 6, 5, 1]                  2
// [1, 2, 1, 2]          [1, 10, 1, 2]                 7
//   [1, 1]                 [1, 5]                    -1


// Making Two Queue Sums Equal
// Two queues of the same length are given.
// By popping an element from one queue and inserting it into the other queue,
// make the sums of the two queues equal using the minimum number of operations.
// One pop and one insert together count as one operation.

// A queue follows the first-in, first-out structure.
// In this problem, each queue is represented as an array.
// The element closer to the front of the array is considered to have been inserted earlier.
// Therefore, pop removes the first element of the array,
// and insert adds an element to the end of the array.

// If it is impossible to make the sums of the two queues equal,
// return -1.

// Constraints
// 1 ≤ queue1.length = queue2.length ≤ 300,000
// 1 ≤ queue1[i], queue2[i] ≤ 10^9
// Consider using long because the sum may cause arithmetic overflow.

// Examples
//   queue1                 queue2                   result
// [3, 2, 7, 2]          [4, 6, 5, 1]                  2
// [1, 2, 1, 2]          [1, 10, 1, 2]                 7
//   [1, 1]                 [1, 5]                    -1

public class Ex054_QueueBalance {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 2, 7, 2}, new int[] {4, 6, 5, 1}));
        System.out.println(solution(new int[] {1, 2, 1, 2}, new int[] {1, 10, 1, 2}));
        System.out.println(solution(new int[] {1, 1}, new int[] {1, 5}));
    }

    public static int solution(int[] queue1, int[] queue2) {
        long total = 0;

        // 두 큐의 전체 합을 구한다. # Calculate the total sum of both queues.
        for (int i = 0; i < queue1.length; i++) {
            total += queue1[i];
            total += queue2[i];
        }

        // 전체 합이 홀수이면 두 큐의 합을 같게 만들 수 없다. # Return -1 if the total sum is odd.
        if (total % 2 != 0) {
            return -1;
        }

        // 각 큐가 가져야 할 목표 합을 구한다. # Calculate the target sum for each queue.
        long target = total / 2;

        // queue1의 현재 합을 구한다. # Calculate the current sum of queue1.
        long sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i];
        }

        // 두 큐를 하나의 배열로 연결한다. # Combine the two queues into one array.
        long[] queue = new long[queue1.length * 2];

        for (int i = 0; i < queue1.length; i++) {
            queue[i] = queue1[i];
            queue[i + queue1.length] = queue2[i];
        }

        int leftIndex = 0;
        int rightIndex = queue1.length;
        int result = 0;

        // 현재 합과 목표 합을 비교하며 두 포인터를 이동한다. # Move two pointers while comparing the current sum with the target.
        while (leftIndex < queue.length && rightIndex < queue.length) {

            // 현재 합이 목표보다 작으면 오른쪽 원소를 추가한다. # Add the element on the right if the current sum is smaller than the target.
            if (sum < target) {
                sum += queue[rightIndex];
                rightIndex++;
                result++;

            // 현재 합이 목표보다 크면 왼쪽 원소를 제거한다. # Remove the element on the left if the current sum is larger than the target.
            } else if (sum > target) {
                sum -= queue[leftIndex];
                leftIndex++;
                result++;

            // 목표 합과 같아지면 작업 횟수를 반환한다. # Return the number of operations when the target is reached.
            } else {
                return result;
            }
        }

        // 목표 합을 만들 수 없으면 -1을 반환한다. # Return -1 if the target cannot be reached.
        return -1;
    }
}