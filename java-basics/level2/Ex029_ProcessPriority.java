// 프로세스
//
// 운영체제의 역할 중 하나는 컴퓨터 시스템의 자원을 효율적으로 관리하는 것입니다. 
// 이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.
// 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
// 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
// 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
// 예를 들어 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 
// 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
// 현재 실행 대기 큐(Queue)에 있는 프로세스의 중요도가 순서대로 담긴 배열 priorities와, 
// 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 location이 매개변수로 주어질 때, 
// 해당 프로세스가 몇 번째로 실행되는지 return 하도록 solution 함수를 작성해주세요.
//
// 제한사항
// priorities의 길이는 1 이상 100 이하입니다.
// priorities의 원소는 1 이상 9 이하의 정수입니다.
// priorities의 원소는 우선순위를 나타내며 숫자가 클 수록 우선순위가 높습니다.
// location은 0 이상 (대기 큐에 있는 프로세스 수 - 1) 이하의 값을 가집니다.
// priorities의 가장 앞에 있으면 0, 두 번째에 있으면 1 … 과 같이 표현합니다.
//
// 입출력 예
//    priorities	    location	return
//    [2, 1, 3, 2]	        2	      1
// [1, 1, 9, 1, 1, 1]	    0	      5
//
// 입출력 예 설명
// 예제 #1
// 문제에 나온 예와 같습니다.
// 예제 #2
// 6개의 프로세스 [A, B, C, D, E, F]가 대기 큐에 있고 중요도가 [1, 1, 9, 1, 1, 1] 이므로 
// [C, D, E, F, A, B] 순으로 실행됩니다. 따라서 A는 5번째로 실행됩니다.

// Process
//
// One of the roles of an operating system is to efficiently manage computer system resources.
// In this problem, determine the execution order of a specific process according to the following rules.
// 1. Take one process from the waiting queue.
// 2. If there is another process with a higher priority in the queue, put the current process back.
// 3. Otherwise, execute the current process.
//   3.1 Once executed, the process is removed and does not return to the queue.
// For example, if processes [A, B, C, D] have priorities [2, 1, 3, 2],
// the execution order becomes [C, D, A, B].
// Given the priorities array and a location indicating the target process,
// return the execution order of that process.
//
// Constraints
// priorities length: 1 ~ 100
// priority value: 1 ~ 9
// Higher number means higher priority.
// location: 0 ~ priorities.length - 1
//
// Example
// priorities          location    return
// [2, 1, 3, 2]           2          1
// [1, 1, 9, 1, 1, 1]     0          5

import java.util.LinkedList;
import java.util.Queue;

public class Ex029_ProcessPriority {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
    }

    public static int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        // 우선순위와 원래 위치를 큐에 저장 # Store priority and original index in queue
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }

        // 큐가 빌 때까지 반복 # Repeat until queue becomes empty
        while (!queue.isEmpty()) {
            // 현재 프로세스 꺼내기 # Poll current process
            int[] current = queue.poll();

            // 현재 우선순위 # Current priority
            int priority = current[0];

            // 현재 프로세스의 원래 위치 # Original index of current process
            int index = current[1];

            // 더 높은 우선순위 존재 여부 # Check if higher priority exists
            boolean hasHigher = false;

            // 큐 안에 더 높은 우선순위 탐색 # Search for higher priority process
            for (int[] process : queue) {

                // 더 높은 우선순위 발견 # Higher priority found
                if (process[0] > priority) {
                    hasHigher = true;

                    // 현재 프로세스를 큐 뒤로 이동 # Move current process to back
                    queue.offer(current);
                    break;
                }
            }

            // 실행 가능한 경우 # If executable
            if (!hasHigher) {
                // 실행 순서 증가 # Increase execution count
                count++;

                // 찾는 프로세스라면 실행 순서 반환 # Return execution order if target
                if (index == location) {
                    return count;
                }
            }
        }

        return 0;
    }
}