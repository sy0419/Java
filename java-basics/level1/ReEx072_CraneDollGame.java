
import java.util.Stack;

public class ReEx072_CraneDollGame {
    public static void main(String[] args) {
        System.out.println(solution(
            new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
            },
            new int[] {1,5,3,5,1,2,1,4}
        ));
    }

    public static int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move: moves) {
            int column = move - 1;

            for (int[] board1 : board) {
                if (board1[column] != 0) {
                    int doll = board1[column];
                    board1[column] = 0;
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        result += 2;
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        return result;
    }
}