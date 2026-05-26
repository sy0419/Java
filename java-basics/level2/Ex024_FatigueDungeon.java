// 피로도

// XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 
// 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다. 
// "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, 
// "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 
// 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 
// 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.

// 이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 
// 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 
// 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// k는 1 이상 5,000 이하인 자연수입니다.
// dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
// dungeons의 가로(열) 길이는 2 입니다.
// dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.
// "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.
// "최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
// 서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

// 입출력 예
// k	          dungeons	         result
// 80	[[80,20],[50,40],[30,10]]	   3

// 입출력 예 설명
// 현재 피로도는 80입니다.
// 만약, 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험한다면
// 현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다.
// 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
// 남은 피로도는 60이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다. 
// 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 20입니다.
// 남은 피로도는 20이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30입니다. 
// 따라서 세 번째 던전은 탐험할 수 없습니다.
// 만약, 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험한다면
// 현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다.
// 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
// 남은 피로도는 60이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30이므로, 세 번째 던전을 탐험할 수 있습니다. 
// 세 번째 던전의 "소모 피로도"는 10이므로, 던전을 탐험한 후 남은 피로도는 50입니다.
// 남은 피로도는 50이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다. 
// 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 10입니다.
// 따라서 이 경우 세 던전을 모두 탐험할 수 있으며, 유저가 탐험할 수 있는 최대 던전 수는 3입니다.

// Fatigue

// XX game has a fatigue system (represented as an integer greater than or equal to 0),
// and players can explore dungeons using fatigue.
// Each dungeon has a "minimum required fatigue" to enter and a "fatigue consumption" after exploration.
// The "minimum required fatigue" means the minimum fatigue required to start exploring the dungeon,
// and "fatigue consumption" means the amount of fatigue consumed after exploration.

// For example, if a dungeon requires a minimum fatigue of 80 and consumes 20 fatigue,
// the player must have at least 80 fatigue to enter,
// and after exploring, 20 fatigue will be consumed.

// A player wants to explore as many dungeons as possible in one day.
// Given the current fatigue k and a 2D array dungeons containing
// [minimum required fatigue, fatigue consumption] for each dungeon,
// complete the solution function to return the maximum number of dungeons the player can explore.

// Constraints
// 1 ≤ k ≤ 5,000
// 1 ≤ number of dungeons ≤ 8
// Each dungeon contains exactly 2 integers.
// Each dungeon is represented as [minimum required fatigue, fatigue consumption].
// Minimum required fatigue is always greater than or equal to consumed fatigue.
// 1 ≤ fatigue values ≤ 1,000

// Example Input / Output
// k	          dungeons	                     result
// 80	[[80,20],[50,40],[30,10]]	           3

// Example Explanation
// The player's current fatigue is 80.

// If the player explores in order:
// First → Second → Third
// Remaining fatigue becomes:
// 80 → 60 → 20
// The third dungeon cannot be entered.
// Therefore, only 2 dungeons are explored.

// If the player explores in order:
// First → Third → Second
// Remaining fatigue becomes:
// 80 → 60 → 50 → 10
// All 3 dungeons can be explored.
// Therefore, the maximum number of dungeons explored is 3.

public class Ex024_FatigueDungeon {

    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }

    static boolean[] visited; // 방문 여부 저장 # Store visited dungeon status
    static int answer; // 최대 탐험 수 저장 # Store maximum explored dungeon count

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length]; // 던전 방문 배열 초기화 # Initialize visited array
        answer = 0; // 최대 탐험 수 초기화 # Initialize max dungeon count

        dfs(k, 0, dungeons); // DFS 탐색 시작 # Start DFS traversal

        return answer;
    }

    public static void dfs(int k, int count, int[][] dungeons) {

        // 현재 탐험 개수와 최대값 비교 # Compare current count with max count
        answer = Math.max(answer, count);

        // 모든 던전 탐색 # Explore all dungeons
        for (int i = 0; i < dungeons.length; i++) {

            // 현재 피로도로 입장 가능하고 방문하지 않은 경우 # If dungeon is accessible and not visited
            if (k >= dungeons[i][0] && !visited[i]) {

                visited[i] = true; // 방문 처리 # Mark as visited

                // 다음 던전 탐색 # Explore next dungeon
                dfs(k - dungeons[i][1], count + 1, dungeons);

                visited[i] = false; // 방문 복구 (백트래킹) # Restore visited state (backtracking)
            }
        }
    }
}