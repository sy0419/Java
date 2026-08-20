// 프렌즈4블록
// 블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
// 같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.
// 만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다.
// 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
// 블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
// 만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.
// 위 초기 배치를 문자로 표시하면 아래와 같다.
// TTTANT
// RRFACC
// RRRFCC
// TRRRAA
// TTMMMF
// TMMTTJ
// 각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다.
// 입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.

// 입력 형식
// 입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
// 2 ≦ n, m ≦ 30
// board는 길이 n인 문자열 m개의 배열로 주어진다.
// 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.

// 출력 형식
// 입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.

// 입출력 예제
// m	n	                            board	                            answer
// 4	5	            ["CCBDE", "AAADE", "AAABF", "CCBBF"]	              14
// 6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	  15

// 예제에 대한 설명
// 입출력 예제 1의 경우, 첫 번째에는 A 블록 6개가 지워지고, 두 번째에는 B 블록 4개와 C 블록 4개가 지워져, 모두 14개의 블록이 지워진다.
// 예제 2는 본문 설명에 있는 그림을 옮긴 것이다. 11개와 4개의 블록이 차례로 지워지며, 모두 15개가 지워진다.

// Friends 4 Block
// Ryan, a new employee who passed the blind recruitment process, has been assigned to develop a new game.
// The title of the game to be released is "Friends 4 Block".
// In this game, four Kakao Friends blocks disappear and give a score when blocks of the same shape are arranged in a 2×2 formation.
// If the board is given as shown above, 7 Ryan blocks and 4 Con blocks arranged in 2×2 formations are removed.
// The same block can belong to multiple 2×2 formations, and if there are multiple 2×2 formations that satisfy the removal condition, all of them are removed at the same time.
// After the blocks are removed, the blocks above fall down to fill the empty spaces.
// If the same-shaped blocks form another 2×2 formation after the empty spaces are filled, those blocks are removed again.
// This process is repeated until there are no more blocks that can be removed.
// The initial board configuration can be represented by the following characters.
// TTTANT
// RRFACC
// RRRFCC
// TRRRAA
// TTMMMF
// TMMTTJ
// Each character represents a Kakao Friends character: Ryan (R), Muzi (M), Apeach (A), Frodo (F), Neo (N), Tube (T), Jay-G (J), and Con (C).
// Given the initial arrangement of the blocks, determine the total number of blocks that disappear.

// Input Format
// The height m, width n, and board arrangement are given as input.
// 2 ≦ n, m ≦ 30
// board consists of m strings, each of length n.
// The characters representing blocks are uppercase letters from A to Z.

// Output Format
// Given the board information, return the total number of blocks that disappear.

// Input/Output Examples
// m	n	                            board	                            answer
// 4	5	            ["CCBDE", "AAADE", "AAABF", "CCBBF"]	              14
// 6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	  15

// Example Explanation
// In Example 1, 6 A blocks disappear in the first round.
// In the second round, 4 B blocks and 4 C blocks disappear.
// Therefore, a total of 14 blocks disappear.
// In Example 2, 11 blocks and then 4 blocks disappear, for a total of 15 blocks.

public class Ex051_Friends4Block {
    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[] {
            "CCBDE",
            "AAADE",
            "AAABF",
            "CCBBF"
        }));

        System.out.println(solution(6, 6, new String[] {
            "TTTANT",
            "RRFACC",
            "RRRFCC",
            "TRRRAA",
            "TTMMMF",
            "TMMTTJ"
        }));
    }

    public static int solution(int m, int n, String[] board) {
        int result = 0;
        boolean hasRemoved = true;

        char[][] boardArray = new char[m][n];

        // 문자열 배열을 수정 가능한 2차원 문자 배열로 변환한다. # Convert the string array into a mutable 2D character array.
        for (int i = 0; i < m; i++) {
            boardArray[i] = board[i].toCharArray();
        }

        while (hasRemoved) {
            hasRemoved = false;
            boolean[][] remove = new boolean[m][n];

            // 모든 2×2 블록을 확인한다. # Check every possible 2×2 block.
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char a = boardArray[i][j];
                    char b = boardArray[i][j + 1];
                    char c = boardArray[i + 1][j];
                    char d = boardArray[i + 1][j + 1];

                    // 네 블록이 같으면 삭제할 위치를 표시한다. # Mark the positions if all four blocks are the same.
                    if (a != '.' && a == b && a == c && a == d) {
                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;
                        hasRemoved = true;
                    }
                }
            }

            // 표시된 블록을 한꺼번에 삭제한다. # Remove all marked blocks at the same time.
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        result++;
                        boardArray[i][j] = '.';
                    }
                }
            }

            // 각 열의 블록을 아래로 떨어뜨린다. # Drop the blocks downward in each column.
            for (int j = 0; j < n; j++) {
                int writeRow = m - 1;

                // 아래에서부터 블록을 확인하며 빈 공간 없이 아래쪽에 배치한다.
                // Check blocks from the bottom and place them downward without empty spaces.
                for (int i = m - 1; i >= 0; i--) {
                    if (boardArray[i][j] != '.') {
                        boardArray[writeRow][j] = boardArray[i][j];
                        writeRow--;
                    }
                }

                // 블록이 이동한 후 남은 위쪽 공간을 빈칸으로 만든다.
                // Fill the remaining upper spaces with empty cells.
                for (int row = 0; row <= writeRow; row++) {
                    boardArray[row][j] = '.';
                }
            }
        }

        return result;
    }
}