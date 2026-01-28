public class ReEx037_WalletSize {
    public static void main(String[] args) {
        System.out.println(solution1(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}})); 
        System.out.println(solution1(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); 
        System.out.println(solution1(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); 

        System.out.println(solution2(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}})); 
        System.out.println(solution2(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); 
        System.out.println(solution2(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); 
    }

    public static int solution1(int[][] size) {
        for (int[] size1 : size) {
            int w = size1[0];
            int h = size1[1];

            size1[0] = Math.max(w, h);
            size1[1] = Math.min(w, h);
        }

        int maxW = 0;
        int maxH = 0;

        for (int[] size1 : size) {
            maxW = Math.max(maxW, size1[0]);
            maxH = Math.max(maxH, size1[1]);
        }

        return maxW * maxH;
    }

    public static int solution2(int[][] size) {
        int maxW = 0;
        int maxH = 0;

        for (int[] s : size) {
            int w = Math.max(s[0], s[1]);
            int h = Math.min(s[0], s[1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}