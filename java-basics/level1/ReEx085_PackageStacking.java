public class ReEx085_PackageStacking {
    public static void main(String[] args) {
        System.out.println(solution(22, 6, 8));  // 3
        System.out.println(solution(13, 3, 6));  // 4
    }

    public static int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col;

        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - ((num - 1) % w);
        }

        int totalRow = (n - 1) / w;
        int count = 0;

        for (int r = row; r <= totalRow; r++) {
            int boxNumber;
            if (r % 2 == 0) {
                boxNumber = r * w + col + 1;
            } else {
                boxNumber = r * w + (w - col);
            }

            if (boxNumber <= n) {
                count++;
            }
        }
        return count;
    }
}