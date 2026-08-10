// 숫자 변환하기
// 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
// x에 n을 더합니다
// x에 2를 곱합니다.
// x에 3을 곱합니다.
// 자연수 x, y, n이 매개변수로 주어질 때,
// x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
// 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.

// 제한사항
// 1 ≤ x ≤ y ≤ 1,000,000
// 1 ≤ n < y

// 입출력 예
// x    y    n    result
// 10   40   5      2
// 10   40   30     1
// 2    5    4     -1

// 입출력 예 설명
// 입출력 예 #1
// x에 2를 2번 곱하면 40이 되고 이때가 최소 횟수입니다.
// 입출력 예 #2
// x에 n인 30을 1번 더하면 40이 되고 이때가 최소 횟수입니다.
// 입출력 예 #3
// x를 y로 변환할 수 없기 때문에 -1을 return합니다.

// Number Transformation
// You want to transform a natural number x into y.
// The following operations can be used.
// Add n to x.
// Multiply x by 2.
// Multiply x by 3.
// Given natural numbers x, y, and n,
// return the minimum number of operations required to transform x into y.
// If x cannot be transformed into y, return -1.

// Constraints
// 1 ≤ x ≤ y ≤ 1,000,000
// 1 ≤ n < y

// Examples
// x    y    n    result
// 10   40   5      2
// 10   40   30     1
// 2    5    4     -1

// Example Explanation
// Example #1
// Multiplying x by 2 twice transforms 10 into 40,
// which is the minimum number of operations.
// Example #2
// Adding n = 30 to x once transforms 10 into 40,
// which is the minimum number of operations.
// Example #3
// x cannot be transformed into y, so the answer is -1.

import java.util.LinkedList;
import java.util.Queue;

public class Ex045_NumberTransformation {
    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }

    public static int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        // 현재 값과 연산 횟수를 저장할 Queue를 생성한다.
        // Create a Queue to store the current value and the number of operations.

        boolean[] visited = new boolean[y + 1];
        // 같은 값을 여러 번 탐색하지 않도록 방문 여부를 저장한다.
        // Store whether each value has been visited to avoid exploring the same value multiple times.

        queue.offer(new int[]{x, 0});
        // 시작 값 x와 초기 연산 횟수 0을 Queue에 추가한다.
        // Add the starting value x and the initial operation count of 0 to the Queue.

        visited[x] = true;
        // 시작 값 x를 방문한 것으로 표시한다.
        // Mark the starting value x as visited.

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // Queue에서 현재 상태를 꺼낸다.
            // Remove the current state from the Queue.

            int value = current[0];
            int count = current[1];
            // 현재 값과 현재까지의 연산 횟수를 가져온다.
            // Get the current value and the number of operations performed so far.

            if (value == y) {
                return count;
            }
            // 현재 값이 y라면 BFS 특성상 최소 연산 횟수이므로 반환한다.
            // If the current value is y, return the count because BFS guarantees the minimum number of operations.

            if (value < y) {
                int next1 = value + n;
                int next2 = value * 2;
                int next3 = value * 3;
                // 현재 값에서 수행할 수 있는 세 가지 다음 값을 계산한다.
                // Calculate the three possible next values from the current value.

                if (next1 <= y && !visited[next1]) {
                    queue.offer(new int[]{next1, count + 1});
                    visited[next1] = true;
                }
                // n을 더한 값이 y 이하이고 아직 방문하지 않았다면 Queue에 추가한다.
                // Add the value to the Queue if it is no greater than y and has not been visited.

                if (next2 <= y && !visited[next2]) {
                    queue.offer(new int[]{next2, count + 1});
                    visited[next2] = true;
                }
                // 2를 곱한 값이 y 이하이고 아직 방문하지 않았다면 Queue에 추가한다.
                // Add the value to the Queue if it is no greater than y and has not been visited.

                if (next3 <= y && !visited[next3]) {
                    queue.offer(new int[]{next3, count + 1});
                    visited[next3] = true;
                }
                // 3을 곱한 값이 y 이하이고 아직 방문하지 않았다면 Queue에 추가한다.
                // Add the value to the Queue if it is no greater than y and has not been visited.
            }
        }

        return -1;
        // 모든 경우를 탐색했지만 y에 도달하지 못하면 -1을 반환한다.
        // Return -1 if y cannot be reached after exploring all possible cases.
    }
}