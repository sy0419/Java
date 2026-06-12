// ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 3
// 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.

// 지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 
// 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
// 위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 
// 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
// 아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
// 첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
// 두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
// 위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로, 
// 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.

// 만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 
// 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
// 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 
// 최솟값을 return 하도록 solution 함수를 완성해주세요. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

// 제한사항
// maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
// n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
// maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
// 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.

// English Translation
// ROR is a game played between two teams, and the team that destroys the opponent's base first wins.
// Therefore, it is advantageous for each team to reach the opponent's base as quickly as possible.

// You are now a member of one team and will play the game.
// The following example shows a 5 x 5 map where your character starts at (row: 1, col: 1)
// and the enemy base is at (row: 5, col: 5).
// Black areas are walls that cannot be passed, while white areas are walkable paths.
// Your character can move one tile at a time in four directions: east, west, south, and north.
// The character cannot move outside the map.

// The first route reaches the enemy base in 11 tiles.
// The second route reaches the enemy base in 15 tiles.
// Since there is no faster route than the first one, it is considered the shortest path.

// If the enemy team surrounds its base with walls, reaching the enemy base may become impossible.
// Given the game map `maps`, return the minimum number of tiles needed to reach the enemy base.
// If it is impossible to reach, return -1.

// Constraints
// `maps` is a 2D array of size n x m representing the game map.
// n and m are natural numbers between 1 and 100.
// n and m may or may not be the same, but both will not be 1 simultaneously.
// `maps` contains only 0s and 1s.
// 0 represents a wall, and 1 represents a walkable path.
// The character starts at the top-left corner (1,1),
// and the enemy base is at the bottom-right corner (n,m).

// Example Input / Output
// maps	                                answer
// [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	  11
// [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	  -1

import java.util.LinkedList;
import java.util.Queue;

public class Ex031_ShortestPath {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        }));

        System.out.println(solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        }));
    }

    public static int solution(int[][] maps) {
        int row = maps.length; // 행 크기 저장 # Store row size
        int column = maps[0].length; // 열 크기 저장 # Store column size

        int[] dx = {-1, 1, 0, 0}; // 상하 이동 # Up and down movement
        int[] dy = {0, 0, -1, 1}; // 좌우 이동 # Left and right movement

        Queue<int[]> queue = new LinkedList<>(); // BFS 탐색용 큐 생성 # Create queue for BFS
        queue.offer(new int[]{0, 0}); // 시작 좌표 추가 # Add starting position

        boolean[][] visited = new boolean[row][column]; // 방문 체크 배열 # Visited array
        visited[0][0] = true; // 시작 위치 방문 처리 # Mark start position as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 좌표 꺼내기 # Get current position

            int x = current[0]; // 현재 x 좌표 # Current x coordinate
            int y = current[1]; // 현재 y 좌표 # Current y coordinate

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 다음 x 좌표 # Next x coordinate
                int ny = y + dy[i]; // 다음 y 좌표 # Next y coordinate

                if (nx < 0 || ny < 0 || nx >= row || ny >= column) {
                    continue; // 맵 범위 밖이면 건너뛰기 # Skip if out of bounds
                }

                if (maps[nx][ny] == 0) {
                    continue; // 벽이면 이동 불가 # Skip if wall
                }

                if (visited[nx][ny]) {
                    continue; // 이미 방문한 곳이면 건너뛰기 # Skip if already visited
                }

                visited[nx][ny] = true; // 방문 처리 # Mark as visited
                maps[nx][ny] = maps[x][y] + 1; // 거리 누적 # Update distance
                queue.offer(new int[]{nx, ny}); // 다음 탐색 좌표 추가 # Add next position
            }
        }

        if (!visited[row - 1][column - 1]) {
            return -1; // 도착 불가능 # Cannot reach destination
        }

        return maps[row - 1][column - 1]; // 최단 거리 반환 # Return shortest distance
    }
}