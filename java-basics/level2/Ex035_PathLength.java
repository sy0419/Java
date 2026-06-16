// 방문 길이

// 게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
// U: 위쪽으로 한 칸 가기
// D: 아래쪽으로 한 칸 가기
// R: 오른쪽으로 한 칸 가기
// L: 왼쪽으로 한 칸 가기

// 캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다.
// 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.
// 예를 들어, "ULURRDLLU"로 명령했다면
// 1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.
// 8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.
// 이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다.
// 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
// (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)
// 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.
// 예를 들어, "LULLLLLLU"로 명령했다면
// 1번 명령어부터 6번 명령어대로 움직인 후, 7, 8번 명령어는 무시합니다. 다시 9번 명령어대로 움직입니다.
// 이때 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.
// 명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
// dirs의 길이는 500 이하의 자연수입니다.

// 입출력 예
//     dirs	     answer
// "ULURRDLLU"	   7
// "LULLLLLLU"	   7

// 입출력 예 설명
// 입출력 예 #1
// 문제의 예시와 같습니다.
// 입출력 예 #2
// 문제의 예시와 같습니다.


// Path Length

// The game character moves using four commands as follows.
// U: Move up by one cell
// D: Move down by one cell
// R: Move right by one cell
// L: Move left by one cell

// The character starts at coordinate (0, 0).
// The boundaries of the coordinate plane are:
// top-left (-5, 5), bottom-left (-5, -5),
// top-right (5, 5), and bottom-right (5, -5).
// For example, if the command is "ULURRDLLU"
// the character moves as described from command 1 to 7.
// Then, command 8 to 9 moves as described.

// We want to calculate the length of the path
// that the character walks for the first time.
// In the example above, the character moves 9 times,
// but the number of unique paths is 7.
// (The paths in commands 8 and 9
// were already visited in commands 2 and 3.)

// Commands that move outside the boundary are ignored.
// For example, if the command is "LULLLLLLU"
// after moving according to commands 1 to 6,
// commands 7 and 8 are ignored,
// and command 9 is processed.

// In this case, the number of unique paths is 7.
// Complete the solution function so that
// it returns the number of unique paths
// the character walked for the first time.

// Constraints
// dirs is given as a string
// and contains only 'U', 'D', 'R', 'L'.
// The length of dirs is a natural number
// less than or equal to 500.

// Example Input / Output
//      dirs          answer
// "ULURRDLLU"          7
// "LULLLLLLU"          7

// Example Explanation
// Example #1
// Same as described in the problem.

// Example #2
// Same as described in the problem.

import java.util.HashSet;
import java.util.Set;

public class Ex035_PathLength {

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs) {

        Set<String> direction = new HashSet<>(); // 지나간 길 저장 # Store visited paths
        int result = 0; // 처음 걸어본 길 개수 # Count of unique paths
        int x = 0; // 현재 x 좌표 # Current x coordinate
        int y = 0; // 현재 y 좌표 # Current y coordinate

        // 명령어 하나씩 이동 # Process each movement command
        for (char d : dirs.toCharArray()) {

            int nx = x; // 이동할 x 좌표 # Next x coordinate
            int ny = y; // 이동할 y 좌표 # Next y coordinate

            // 방향에 따라 좌표 이동 # Move coordinates based on direction
            switch (d) {
                case 'U' -> ny++;
                case 'D' -> ny--;
                case 'R' -> nx++;
                case 'L' -> nx--;
            }

            // 좌표평면 경계 밖이면 무시 # Ignore movement outside boundary
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 현재 위치 → 다음 위치 경로 # Current to next path
            String path = x + "," + y + "->" + nx + "," + ny;

            // 반대 방향 경로 # Reverse path
            String reversePath = nx + "," + ny + "->" + x + "," + y;

            // 처음 가는 길이면 저장 # Save if path is visited for the first time
            if (!direction.contains(path)) {
                result++; // 새로운 길 개수 증가 # Increase unique path count
                direction.add(path); // 정방향 저장 # Save forward path
                direction.add(reversePath); // 역방향 저장 # Save reverse path
            }

            // 현재 위치 갱신 # Update current position
            x = nx;
            y = ny;
        }

        return result;
    }
}