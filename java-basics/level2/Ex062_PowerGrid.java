// 전력망을 둘로 나누기
// n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
// 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
// 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
// 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
// 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
// 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// n은 2 이상 100 이하인 자연수입니다.
// wires는 길이가 n-1인 정수형 2차원 배열입니다.
// wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며,
// 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
// 1 ≤ v1 < v2 ≤ n 입니다.
// 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.

// 입출력 예
// n    wires                                                        result
// 9    [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]              3
// 4    [[1,2],[2,3],[3,4]]                                            0
// 7    [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]                          1

// 입출력 예 설명
// 입출력 예 #1
// 4번과 7번을 연결하는 전선을 끊으면 두 전력망은 각 6개와 3개의 송전탑을 가지며, 이보다 더 비슷한 개수로 전력망을 나눌 수 없습니다.
// 또 다른 방법으로는 3번과 4번을 연결하는 전선을 끊어도 최선의 정답을 도출할 수 있습니다.
// 입출력 예 #2
// 2번과 3번을 연결하는 전선을 끊으면 두 전력망이 모두 2개의 송전탑을 가지게 되며, 이 방법이 최선입니다.
// 입출력 예 #3
// 3번과 7번을 연결하는 전선을 끊으면 두 전력망이 각각 4개와 3개의 송전탑을 가지게 되며, 이 방법이 최선입니다.

// Power Grid
// n power towers are connected through wires in the form of a tree.
// You want to disconnect one of the wires to divide the current power grid network into two networks.
// Your goal is to make the number of power towers in the two networks as similar as possible.
// Given the number of power towers n and the wire information wires,
// complete the solution function to return the absolute difference between the numbers of power towers
// in the two networks after disconnecting one wire.

// Constraints
// n is a natural number between 2 and 100.
// wires is a 2D integer array with a length of n - 1.
// Each element of wires consists of two natural numbers [v1, v2],
// representing a wire connecting power tower v1 and power tower v2.
// 1 ≤ v1 < v2 ≤ n.
// The input network is guaranteed to form a single tree.

// Examples
// n    wires                                                        result
// 9    [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]              3
// 4    [[1,2],[2,3],[3,4]]                                            0
// 7    [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]                          1

// Example Explanations
// Example #1
// If you disconnect the wire connecting power towers 4 and 7,
// the two power grids will have 6 and 3 power towers respectively.
// It is not possible to divide the power grid into two networks with a smaller difference.
// Another way to obtain the optimal answer is to disconnect the wire connecting power towers 3 and 4.
// Example #2
// If you disconnect the wire connecting power towers 2 and 3,
// both power grids will have 2 power towers.
// This is the best possible way to divide the power grid.
// Example #3
// If you disconnect the wire connecting power towers 3 and 7,
// the two power grids will have 4 and 3 power towers respectively.
// This is the best possible way to divide the power grid.

import java.util.ArrayList;
import java.util.List;

public class Ex062_PowerGrid {
    public static void main(String[] args) {
        System.out.println(solution(9, new int[][] {
            {1, 3}, {2, 3}, {3, 4}, {4, 5},
            {4, 6}, {4, 7}, {7, 8}, {7, 9}
        }));

        System.out.println(solution(4, new int[][] {
            {1, 2}, {2, 3}, {3, 4}
        }));

        System.out.println(solution(7, new int[][] {
            {1, 2}, {2, 7}, {3, 7}, {3, 4},
            {4, 5}, {6, 7}
        }));
    }

    public static int solution(int n, int[][] wires) {
        // 인접 리스트를 생성한다. # Create an adjacency list.
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            // 각 송전탑의 인접 리스트를 초기화한다. # Initialize the adjacency list for each tower.
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 양방향으로 전선을 연결한다. # Connect the wire in both directions.
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 가장 작은 차이를 저장한다. # Store the minimum difference.
        int result = Integer.MAX_VALUE;

        for (int[] wire : wires) {

            // 매번 새로운 방문 배열을 생성한다. # Create a new visited array for each cut.
            boolean[] visited = new boolean[n + 1];

            int cutA = wire[0];
            int cutB = wire[1];

            // 한쪽 전력망의 송전탑 개수를 구한다. # Count the towers in one network.
            int count = dfs(cutA, graph, visited, cutA, cutB);

            // 다른 전력망의 송전탑 개수를 구한다. # Calculate the number of towers in the other network.
            int other = n - count;

            // 두 전력망의 송전탑 개수 차이를 계산한다. # Calculate the difference between the two networks.
            int difference = Math.abs(count - other);

            // 가장 작은 차이로 갱신한다. # Update the minimum difference.
            result = Math.min(result, difference);
        }

        return result;
    }

    public static int dfs(int current, List<Integer>[] graph,
                          boolean[] visited, int cutA, int cutB) {

        // 현재 송전탑을 방문 처리한다. # Mark the current tower as visited.
        visited[current] = true;

        // 현재 송전탑을 포함해 개수를 1로 시작한다. # Start the count at 1 for the current tower.
        int count = 1;

        for (int next : graph[current]) {

            // 방문하지 않았고 끊어진 전선을 통과하지 않는 경우 탐색한다.
            // Explore if the tower has not been visited and the cut wire is not crossed.
            if (!visited[next]
                    && !(current == cutA && next == cutB)
                    && !(current == cutB && next == cutA)) {

                // 연결된 송전탑의 개수를 재귀적으로 더한다.
                // Recursively add the number of connected towers.
                count += dfs(next, graph, visited, cutA, cutB);
            }
        }

        return count;
    }
}