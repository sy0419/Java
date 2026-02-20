public class ReEx062_sameColorNeighbor {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"blue", "red", "orange", "red"}, 
                                                    {"red", "red", "blue", "orange"},
                                                    {"blue", "orange", "red", "red"},
                                                    {"orange", "orange", "red", "blue"}},
                                                    1, 1));
        System.out.println(solution(new String[][] {{"yellow", "green", "blue"}, 
                                                    {"blue", "green", "yellow"},
                                                    {"yellow", "blue", "blue"}},
                                                    0, 1));
    }

    public static int solution(String[][] board, int h, int w) {
        String target = board[h][w];
        int count = 0;

        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newH = h + dh[i];
            int newW = w + dw[i];

            if (0 <= newH && newH < board.length && 0 <= newW && newW < board.length) {
                if (target.equals(board[newH][newW])) {
                    count++;
                }
            }
        }
        return count;
    }
}