
// 격자 모양의 게임판 위에서 로봇을 움직이는 보드게임이 있습니다.
// 로봇은 현재 위치에서 상, 하, 좌, 우 중 한 방향으로 이동할 수 있습니다.
// 한 번 이동하면 장애물이나 게임판의 가장자리에 부딪힐 때까지 미끄러져 움직입니다.
// 이동 도중에는 멈출 수 없으며, 이동이 끝난 위치가 새로운 시작 위치가 됩니다.
// 게임판에는 다음과 같은 요소가 있습니다.
// "." : 빈 공간
// "R" : 로봇의 처음 위치
// "D" : 장애물
// "G" : 목표 지점
// 로봇이 시작 위치 R에서 출발하여 목표 위치 G에 정확하게 멈추기 위해
// 필요한 최소 이동 횟수를 구하려고 합니다.
// 목표 위치에 도달할 수 없다면 -1을 return 합니다.

// 예를 들어 다음과 같은 게임판이 주어졌을 때,
// ...D..R
// .D.G...
// ....D.D
// D....D.
// ..D....
// 로봇은 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 이동하면
// 총 7번 만에 목표 지점에 도달할 수 있습니다.
// 게임판의 상태를 나타내는 문자열 배열 board가 주어집니다.
// 로봇이 목표 위치에 도달하는 데 필요한 최소 이동 횟수를
// return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// - 3 <= board.length <= 100
// - 3 <= board의 각 원소의 길이 <= 100
// - board의 모든 문자열 길이는 동일합니다.
// - 문자열은 ".", "D", "R", "G"로만 구성됩니다.
// - "R"과 "G"는 각각 한 번씩 등장합니다.

// 입출력 예
//                        board                                    result
// ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]           7
//            [".D.R", "....", ".G..", "...D"]                       -1

// 입출력 예 설명
// 예제 1
// 문제 설명의 예시와 같습니다. 최소 7번 이동하면 목표 지점에 도달할 수 있습니다.
// 예제 2
// 로봇이 어떤 방향으로 움직이더라도 목표 지점 G에 정확하게 멈출 수 없습니다.
// 따라서 -1을 return 합니다.

// Ricochet Robot
// There is a board game in which a robot moves on a grid-shaped game board.
// The robot can move in one of four directions: up, down, left, or right.
// Once it starts moving in a direction, it keeps sliding until it hits
// an obstacle or the edge of the game board.
// The robot cannot stop in the middle of its movement.
// The game board contains the following elements:
// "." : Empty space
// "R" : The robot's starting position
// "D" : An obstacle
// "G" : The goal position
// Starting from R, find the minimum number of moves required
// for the robot to stop exactly at the goal position G.
// If the robot cannot reach the goal, return -1.
// The board is given as an array of strings called board.
// Complete the solution function to return the minimum number of moves.
//
// Constraints
// - 3 <= board.length <= 100
// - 3 <= board[i].length <= 100
// - All strings in board have the same length.
// - Each character is one of ".", "D", "R", or "G".
// - "R" and "G" each appear exactly once.

// Examples
//                        board                                    result
// ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]           7
//            [".D.R", "....", ".G..", "...D"]                       -1

// Example Explanation
// Example 1
// The robot can reach the goal in 7 moves, as shown in the problem description.
// Example 2
// The robot cannot stop exactly at the goal position,
// regardless of which direction it moves.
// Therefore, return -1.

import java.util.LinkedList;
import java.util.Queue;

public class Ex069_RicochetRobot {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
        System.out.println(solution(new String[]{".D.R", "....", ".G..", "...D"}));
    }

    public static int solution(String[] board) {
        // 시작 위치와 목표 위치를 저장할 변수 # Variables to store the starting and goal positions
        int startRow = -1;
        int startCol = -1;
        int goalRow = -1;
        int goalCol = -1;

        // 상, 하, 좌, 우 방향을 나타내는 배열 # Arrays representing the up, down, left, and right directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 게임판을 탐색하여 시작 위치 R과 목표 위치 G 찾기 # Find the starting position R and the goal position G by searching the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length(); col++) {
                if (board[row].charAt(col) == 'R') {
                    startRow = row;
                    startCol = col;
                }

                if (board[row].charAt(col) == 'G') {
                    goalRow = row;
                    goalCol = col;
                }
            }
        }

        // 방문한 위치를 기록하는 2차원 배열 # 2D array to record visited positions
        boolean[][] visited = new boolean[board.length][board[0].length()];

        // BFS 탐색에 사용할 Queue 생성 # Create a queue for BFS traversal
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치를 Queue에 추가하고 방문 처리 # Add the starting position to the queue and mark it as visited
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        // 시작 위치부터 목표 지점까지의 이동 횟수 # Number of moves from the starting position to the goal
        int moves = 0;

        // Queue가 빌 때까지 BFS 탐색 # Perform BFS until the queue becomes empty
        while (!queue.isEmpty()) {
            // 현재 이동 횟수에서 탐색할 위치의 개수 # Number of positions to explore at the current move count
            int size = queue.size();

            // 현재 단계에 해당하는 모든 위치 탐색 # Explore all positions at the current level
            for (int i = 0; i < size; i++) {
                // Queue에서 현재 위치를 꺼내기 # Retrieve the current position from the queue
                int[] current = queue.poll();

                // 현재 위치의 행과 열 저장 # Store the current row and column
                int row = current[0];
                int col = current[1];

                // 상, 하, 좌, 우 네 방향 탐색 # Explore all four directions: up, down, left, and right
                for (int d = 0; d < 4; d++) {
                    // 다음 이동 위치를 현재 위치로 초기화 # Initialize the next position with the current position
                    int nextRow = row;
                    int nextCol = col;

                    // 장애물이나 게임판의 가장자리를 만날 때까지 이동 # Slide until the robot hits an obstacle or the edge of the board
                    while (nextRow + dr[d] >= 0
                            && nextRow + dr[d] < board.length
                            && nextCol + dc[d] >= 0
                            && nextCol + dc[d] < board[0].length()
                            && board[nextRow + dr[d]].charAt(nextCol + dc[d]) != 'D') {

                        // 이동 가능한 다음 위치로 갱신 # Update to the next reachable position
                        nextRow += dr[d];
                        nextCol += dc[d];
                    }

                    // 이동이 끝난 위치가 목표 지점이면 이동 횟수 반환 # Return the move count if the stopping position is the goal
                    if (nextRow == goalRow && nextCol == goalCol) {
                        return moves + 1;
                    }

                    // 아직 방문하지 않은 위치라면 방문 처리 후 Queue에 추가 # Mark an unvisited position and add it to the queue
                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }

            // 현재 단계의 탐색이 끝나면 이동 횟수 증가 # Increase the move count after completing the current level
            moves++;
        }

        // 목표 지점에 도달할 수 없다면 -1 반환 # Return -1 if the goal cannot be reached
        return -1;
    }
}
