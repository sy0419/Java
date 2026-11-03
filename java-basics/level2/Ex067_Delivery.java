// 배달
// N개의 마을로 이루어진 나라가 있습니다.
// 이 나라의 각 마을에는 1부터 N까지의 번호가 각각 하나씩 부여되어 있습니다.
// 각 마을은 양방향으로 통행할 수 있는 도로로 연결되어 있는데, 서로 다른 마을 간에 이동할 때는 이 도로를 지나야 합니다.
// 도로를 지날 때 걸리는 시간은 도로별로 다릅니다. 현재 1번 마을에 있는 음식점에서 각 마을로 음식 배달을 하려고 합니다.
// 각 마을로부터 음식 주문을 받으려고 하는데, N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 합니다.

// 다음은 N = 5, K = 3인 경우의 예시입니다.
// 위 그림에서 1번 마을에 있는 음식점은 [1, 2, 4, 5] 번 마을까지는 3 이하의 시간에 배달할 수 있습니다.
// 그러나 3번 마을까지는 3시간 이내로 배달할 수 있는 경로가 없으므로 3번 마을에서는 주문을 받지 않습니다.
// 따라서 1번 마을에 있는 음식점이 배달 주문을 받을 수 있는 마을은 4개가 됩니다.

// 마을의 개수 N, 각 마을을 연결하는 도로의 정보 road, 음식 배달이 가능한 시간 K가 매개변수로 주어질 때,
// 음식 주문을 받을 수 있는 마을의 개수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// - 마을의 개수 N은 1 이상 50 이하의 자연수입니다.
// - road의 길이(도로 정보의 개수)는 1 이상 2,000 이하입니다.
// - road의 각 원소는 마을을 연결하고 있는 각 도로의 정보를 나타냅니다.
// - road는 길이가 3인 배열이며, 순서대로 (a, b, c)를 나타냅니다.
//   - a, b(1 ≤ a, b ≤ N, a != b)는 도로가 연결하는 두 마을의 번호이며,
//     c(1 ≤ c ≤ 10,000, c는 자연수)는 도로를 지나는데 걸리는 시간입니다.
//   - 두 마을 a, b를 연결하는 도로는 여러 개가 있을 수 있습니다.
//   - 한 도로의 정보가 여러 번 중복해서 주어지지 않습니다.
// - K는 음식 배달이 가능한 시간을 나타내며, 1 이상 500,000 이하입니다.
// - 임의의 두 마을간에 항상 이동 가능한 경로가 존재합니다.
// - 1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return 하면 됩니다.

// 입출력 예
//     N                              road                              K   result
//     5       [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]        3     4
//     6   [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]    4     4

// 입출력 예 설명
// 입출력 예 #1
// 문제의 예시와 같습니다.
// 입출력 예 #2
// 주어진 마을과 도로의 모양은 아래 그림과 같습니다.
// 1번 마을에서 배달에 4시간 이하가 걸리는 마을은 [1, 2, 3, 5] 4개이므로
// 4를 return 합니다.

// Delivery
// There is a country consisting of N villages.
// Each village is assigned a unique number from 1 to N.
// The villages are connected by two-way roads, and traveling between different villages requires using these roads.
// The time required to travel along each road varies.
// A restaurant in village 1 wants to deliver food to the other villages.
// It will accept orders only from villages that can be reached within K hours from village 1.

// In the example where N = 5 and K = 3,
// the restaurant in village 1 can deliver to villages [1, 2, 4, 5] within 3 hours.
// However, there is no route to village 3 that takes 3 hours or less.
// Therefore, village 3 cannot place an order, and the restaurant can accept orders from 4 villages.

// Given the number of villages N, the road information road, and the maximum delivery time K,
// complete the solution function to return the number of villages
// that can receive deliveries within K hours from village 1.

// Constraints
// - N, the number of villages, is an integer from 1 to 50.
// - road contains between 1 and 2,000 road records.
// - Each element of road represents information about a road connecting two villages.
// - Each road record is an array of length 3, representing (a, b, c).
//   - a and b (1 <= a, b <= N, a != b) are the two connected villages.
//   - c (1 <= c <= 10,000) is the time required to travel along the road.
//   - Multiple roads may connect the same pair of villages.
//   - No identical road record is provided more than once.
// - K, the maximum delivery time, is an integer from 1 to 500,000.
// - There is always a route between any two villages.
// - Return the number of villages that can be reached from village 1
//   within K hours.
//
// Examples
//     N                              road                              K   result
//     5       [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]        3     4
//     6   [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]    4     4

// Example Explanations
// Example 1
// This is the same as the example illustrated in the problem description.
// Example 2
// The given villages and roads are illustrated in the problem figure.
// The villages that can be reached from village 1 within 4 hours
// are [1, 2, 3, 5].
// Since there are 4 such villages, return 4.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex067_Delivery {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2},
                                                        {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},
                                    3));

        System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2},
                                                        {3, 4, 3}, {3, 5, 2}, {3, 5, 3},
                                                        {5, 6, 1}},
                                    4));
    }

    // 배달 주문을 받을 수 있는 마을의 개수를 반환하는 메서드
    // Return the number of villages that can receive deliveries
    public static int solution(int N, int[][] road, int K) {

        // 각 마을에 연결된 마을과 도로 이동 시간을 저장하는 인접 리스트
        // Create an adjacency list to store neighboring villages and road travel times
        ArrayList<int[]>[] graph = new ArrayList[N + 1];

        // 1번 마을에서 각 마을까지의 최단 이동 시간을 저장
        // Store the shortest travel time from village 1 to each village
        int[] distance = new int[N + 1];

        // 모든 마을의 거리를 무한대로 초기화
        // Initialize all distances to infinity
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 출발 마을인 1번 마을까지의 거리는 0
        // Set the distance to the starting village to 0
        distance[1] = 0;

        // 각 마을의 인접 리스트 초기화
        // Initialize an adjacency list for each village
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로 정보를 인접 리스트에 양방향으로 저장
        // Add each road to the adjacency list in both directions
        for (int[] road1 : road) {
            int startTown = road1[0];
            int endTown = road1[1];
            int time = road1[2];

            graph[startTown].add(new int[]{endTown, time});
            graph[endTown].add(new int[]{startTown, time});
        }

        // 이동 시간이 짧은 마을부터 탐색하기 위한 우선순위 큐
        // Create a priority queue to process villages with shorter travel times first
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        // 출발 마을과 이동 시간 0을 큐에 추가
        // Add the starting village and its travel time of 0 to the queue
        pq.add(new int[]{1, 0});

        // 우선순위 큐가 빌 때까지 최단 거리 탐색
        // Find shortest distances until the priority queue is empty
        while (!pq.isEmpty()) {

            // 현재 이동 시간이 가장 짧은 마을을 꺼냄
            // Retrieve the village with the shortest travel time
            int[] current = pq.poll();
            int currentTown = current[0];
            int time = current[1];

            // 이미 더 짧은 거리가 확인된 경우 현재 탐색을 건너뜀
            // Skip this entry if a shorter distance has already been found
            if (time > distance[currentTown]) {
                continue;
            }

            // 현재 마을과 연결된 다음 마을들을 확인
            // Check all neighboring villages connected to the current village
            for (int[] next : graph[currentTown]) {
                int nextTown = next[0];
                int roadTime = next[1];

                // 다음 마을까지 이동하는 새로운 총 소요 시간 계산
                // Calculate the new total travel time to the next village
                int newTime = time + roadTime;

                // 기존 최단 거리보다 짧은 경로를 발견한 경우
                // Update the distance if a shorter route is found
                if (newTime < distance[nextTown]) {
                    distance[nextTown] = newTime;

                    // 갱신된 마을과 이동 시간을 우선순위 큐에 추가
                    // Add the updated village and travel time to the priority queue
                    pq.add(new int[]{nextTown, newTime});
                }
            }
        }

        // 배달 가능한 마을의 개수
        // Count the villages that can receive deliveries
        int result = 0;

        // 1번 마을부터 N번 마을까지 확인
        // Check all villages from 1 to N
        for (int i = 1; i <= N; i++) {

            // 최단 이동 시간이 K 이하인 마을의 개수를 증가
            // Count villages whose shortest travel time is within K
            if (distance[i] <= K) {
                result += 1;
            }
        }

        return result;
    }
}