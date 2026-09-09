// 미로 탈출
// 1 x 1 크기의 칸들로 이루어진 직사각형 격자 형태의 미로에서 탈출하려고 합니다. 
// 각 칸은 통로 또는 벽으로 구성되어 있으며, 벽으로 된 칸은 지나갈 수 없고 통로로 된 칸으로만 이동할 수 있습니다. 
// 통로들 중 한 칸에는 미로를 빠져나가는 문이 있는데, 
// 이 문은 레버를 당겨서만 열 수 있습니다. 레버 또한 통로들 중 한 칸에 있습니다. 
// 따라서, 출발 지점에서 먼저 레버가 있는 칸으로 이동하여 레버를 당긴 후 미로를 빠져나가는 문이 있는 칸으로 이동하면 됩니다.
// 이때 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있습니다. 
// 미로에서 한 칸을 이동하는데 1초가 걸린다고 할 때, 최대한 빠르게 미로를 빠져나가는데 걸리는 시간을 구하려 합니다.
// 미로를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 미로를 탈출하는데 필요한 최소 시간을 return 하는 solution 함수를 완성해주세요. 만약, 탈출할 수 없다면 -1을 return 해주세요.

// 제한사항
// 5 ≤ maps의 길이 ≤ 100
// 5 ≤ maps[i]의 길이 ≤ 100
// maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
// S : 시작 지점
// E : 출구
// L : 레버
// O : 통로
// X : 벽
// 시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
// 출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.

// 입출력 예
//                   maps	                     result
// ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	  16
// ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	  -1

// 입출력 예 설명
// 입출력 예 #1
// 주어진 문자열은 다음과 같은 미로이며 다음과 같이 이동하면 가장 빠른 시간에 탈출할 수 있습니다.
// 4번 이동하여 레버를 당기고 출구까지 이동하면 총 16초의 시간이 걸립니다. 따라서 16을 반환합니다.
// 입출력 예 #2
// 주어진 문자열은 다음과 같은 미로입니다. 시작 지점에서 이동할 수 있는 공간이 없어서 탈출할 수 없습니다. 따라서 -1을 반환합니다.

// Maze Escape
// You are trying to escape from a rectangular maze consisting of 1 x 1 cells.
// Each cell is either a passage or a wall, and walls cannot be passed through.
// There is a door in one of the passage cells that allows you to escape the maze only after pulling a lever.
// The lever is also located in one of the passage cells.
// Therefore, you must first move from the starting point to the cell containing the lever and pull it,
// then move to the cell containing the exit door.
// You can pass through the exit cell even before pulling the lever.
// Moving one cell takes 1 second.
// Given the maze as a string array maps, complete the solution function to return the minimum time required to escape the maze.
// If it is impossible to escape, return -1.

// Constraints
// 5 ≤ maps.length ≤ 100
// 5 ≤ maps[i].length ≤ 100
// Each maps[i] consists only of the following five characters:
// S : Starting point
// E : Exit
// L : Lever
// O : Passage
// X : Wall
// The starting point, exit, and lever are always located at different cells, and each appears exactly once.
// You can pass through the exit cell even before pulling the lever,
// and all passages, the exit, the lever, and the starting point can be visited multiple times.

// Examples
//                   maps	                     result
// ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	  16
// ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	  -1

// Example Explanations
// Example #1
// The given string represents the following maze.
// The following route allows you to escape in the shortest possible time.
// It takes 4 moves to reach the lever, then moving to the exit takes a total of 16 seconds.
// Therefore, the answer is 16.
// Example #2
// The given string represents the following maze.
// There is no accessible space from the starting point, so it is impossible to escape.
// Therefore, the answer is -1.

import java.util.LinkedList;
import java.util.Queue;

public class Ex063_MazeEscape {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {
            "SOOOL",
            "XXXXO",
            "OOOOO",
            "OXXXX",
            "OOOOE"
        }));

        System.out.println(solution(new String[] {
            "LOOXS",
            "OOOOX",
            "OOOOO",
            "OOOOO",
            "EOOOO"
        }));
    }

    public static int solution(String[] maps) {
        // 시작점의 좌표를 저장한다. # Store the coordinates of the starting point.
        int[] start = new int[2];

        // 레버의 좌표를 저장한다. # Store the coordinates of the lever.
        int[] lever = new int[2];

        // 미로를 탐색하며 시작점과 레버의 위치를 찾는다.
        // # Find the positions of the start and lever while scanning the maze.
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }

                if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        // 시작점에서 레버까지의 최단 거리를 구한다.
        // # Find the shortest distance from the start to the lever.
        int startToLever = bfs(maps, start, 'L');

        // 레버에서 출구까지의 최단 거리를 구한다.
        // # Find the shortest distance from the lever to the exit.
        int leverToEnd = bfs(maps, lever, 'E');

        // 둘 중 하나라도 도달할 수 없으면 -1을 반환한다.
        // # Return -1 if either destination cannot be reached.
        if (startToLever == -1 || leverToEnd == -1) {
            return -1;
        }

        // 두 구간의 최단 거리를 더해 전체 이동 시간을 반환한다.
        // # Add the shortest distances of both sections and return the total time.
        return startToLever + leverToEnd;
    }

    public static int bfs(String[] maps, int[] start, char target) {
        // BFS 탐색을 위한 큐를 생성한다. # Create a queue for BFS traversal.
        Queue<int[]> queue = new LinkedList<>();

        // 방문 여부를 저장하는 배열을 생성한다.
        // # Create an array to store whether each cell has been visited.
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        // 시작 위치와 이동 거리를 큐에 저장한다.
        // # Store the starting position and distance in the queue.
        queue.offer(new int[] {start[0], start[1], 0});

        // 시작 위치를 방문 처리한다. # Mark the starting position as visited.
        visited[start[0]][start[1]] = true;

        // 큐가 빌 때까지 BFS를 수행한다. # Perform BFS until the queue is empty.
        while (!queue.isEmpty()) {
            // 현재 위치를 큐에서 꺼낸다. # Remove the current position from the queue.
            int[] current = queue.poll();

            // 현재 행을 저장한다. # Store the current row.
            int row = current[0];

            // 현재 열을 저장한다. # Store the current column.
            int col = current[1];

            // 현재 위치까지의 이동 거리를 저장한다.
            // # Store the distance to the current position.
            int distance = current[2];

            // 현재 위치가 목표 지점이면 이동 거리를 반환한다.
            // # Return the distance if the current position is the target.
            if (maps[row].charAt(col) == target) {
                return distance;
            }

            // 상하좌우 이동을 위한 행의 변화량을 저장한다.
            // # Store row changes for moving up, down, left, and right.
            int[] dr = {-1, 1, 0, 0};

            // 상하좌우 이동을 위한 열의 변화량을 저장한다.
            // # Store column changes for moving up, down, left, and right.
            int[] dc = {0, 0, -1, 1};

            // 네 방향으로 이동할 수 있는지 확인한다.
            // # Check whether movement is possible in four directions.
            for (int i = 0; i < 4; i++) {
                // 다음 위치의 행과 열을 계산한다.
                // # Calculate the row and column of the next position.
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];

                // 다음 위치가 미로 안에 있고 벽이 아니며 방문하지 않았다면 이동한다.
                // # Move if the next position is inside the maze, not a wall, and unvisited.
                if (nextRow >= 0 && nextRow < maps.length
                        && nextCol >= 0 && nextCol < maps[0].length()
                        && maps[nextRow].charAt(nextCol) != 'X'
                        && !visited[nextRow][nextCol]) {

                    // 다음 위치와 증가한 이동 거리를 큐에 저장한다.
                    // # Store the next position and increased distance in the queue.
                    queue.offer(new int[] {nextRow, nextCol, distance + 1});

                    // 다음 위치를 방문 처리한다. # Mark the next position as visited.
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        // 목표 지점에 도달할 수 없으면 -1을 반환한다.
        // # Return -1 if the target cannot be reached.
        return -1;
    }
}