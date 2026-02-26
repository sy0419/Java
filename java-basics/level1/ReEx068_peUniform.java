public class ReEx068_peUniform {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
        System.out.println(solution(5, new int[] {2, 4}, new int[] {3}));
        System.out.println(solution(3, new int[] {3}, new int[] {1}));
    }
    
    public static int solution(int n, int[] lost, int[] reverse) {
        int[] clothes = new int[n+1];

        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        for (int l: lost) {
            clothes[l]--;
        }

        for (int r: reverse) {
            clothes[r]++;
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reverse.length; j++) {
                if (lost[i] == reverse[j]) {
                    clothes[lost[i]] = 1;
                    lost[i] = -1;
                    reverse[j] = -1;
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {
                if (i > 1 && clothes[i - 1] == 2) {
                    clothes[i - 1]--;
                    clothes[i]++;
                }
                else if (i < n && clothes[i + 1] == 2) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                count++;
            }
        }

        return count;
    }
}