// 땅따먹기 게임

// 땅따먹기 게임을 하려고 합니다. 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
// 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
// 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
//
// 예를 들면,
//
// | 1 | 2 | 3 | 5 |
// | 5 | 6 | 7 | 8 |
// | 4 | 3 | 2 | 1 |
//
// 로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.
//
// 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
// 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로
// 16을 return 하면 됩니다.
//
// 제한사항
// 행의 개수 N : 100,000 이하의 자연수
// 열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
// 점수 : 100 이하의 자연수
//
// 입출력 예
//              land                          answer
// [[1,2,3,5],[5,6,7,8],[4,3,2,1]]             16


// [English]
//
// Land Game
//
// You are going to play the Land Game.
// The land is composed of N rows and 4 columns, and each cell contains a score.
//
// Starting from the first row, you must step on exactly one cell in each row while moving downward.
// However, there is a special rule that you cannot step on the same column consecutively.
//
// For example:
//
// | 1 | 2 | 3 | 5 |
// | 5 | 6 | 7 | 8 |
// | 4 | 3 | 2 | 1 |
//
// If you choose the fourth column (5) in the first row,
// you cannot choose the fourth column (8) in the second row.
//
// Complete the solution function to return the maximum score obtainable after reaching the last row.
//
// In the example, choosing 5 from the first row, 7 from the second row,
// and 4 from the third row gives the maximum score of 16.
//
// Constraints
// N is a natural number less than or equal to 100,000.
// The number of columns is always 4.
// land is given as a 2D array.
// Each score is a natural number less than or equal to 100.
//
// Example
// land = [[1,2,3,5],[5,6,7,8],[4,3,2,1]]
// answer = 16


public class Ex039_LandGame {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));
    }

    public static int solution(int[][] land) {

        // 각 위치까지 도달했을 때의 최대 점수를 저장한다.
        // Store the maximum score that can be obtained at each position.
        for (int i = 1; i < land.length; i++) {

            // 현재 행의 각 열을 확인한다.
            // Check each column of the current row.
            for (int j = 0; j < 4; j++) {

                // 이전 행에서 같은 열을 제외한 최대 점수를 찾는다.
                // Find the maximum score from the previous row excluding the same column.
                int max = 0;

                // 이전 행의 모든 열을 확인한다.
                // Check all columns of the previous row.
                for (int k = 0; k < 4; k++) {

                    // 같은 열은 연속으로 선택할 수 없으므로 제외한다.
                    // Skip the same column because consecutive same columns are not allowed.
                    if (k == j) {
                        continue;
                    }

                    // 이전 행에서 가장 큰 누적 점수를 저장한다.
                    // Store the largest accumulated score from the previous row.
                    if (land[i - 1][k] > max) {
                        max = land[i - 1][k];
                    }
                }

                // 현재 점수에 이전 최대 점수를 더해 현재 위치의 최대 점수를 갱신한다.
                // Update the current position with the current score plus the previous maximum score.
                land[i][j] += max;
            }
        }

        // 마지막 행에서 가장 큰 점수를 찾는다.
        // Find the maximum score in the last row.
        int result = 0;

        for (int j = 0; j < 4; j++) {

            // 가장 큰 값을 결과값으로 갱신한다.
            // Update the result with the largest value.
            if (land[land.length - 1][j] > result) {
                result = land[land.length - 1][j];
            }
        }

        return result;
    }
}