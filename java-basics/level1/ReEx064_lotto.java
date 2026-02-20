import java.util.Arrays;

public class ReEx064_lotto {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19}))); 
        System.out.println(Arrays.toString(solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35})));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] result = new int[2];

        int zeroCount = 0;
        for (int num: lottos) {
            if (num == 0) {
                zeroCount++;
            }
        }

        int matchingNum = 0;

        for (int i = 0; i < lottos.length; i++) {
            int num = lottos[i];
            if (num != 0) {
                for (int win: win_nums) {
                    if (num == win) {
                        matchingNum++;
                        break;
                    }
                }
            }
        }

        int bestRank = 7 - (matchingNum + zeroCount);
        if (bestRank > 6) {
            bestRank = 6;
        }
        
        int worstRank = 7 - matchingNum;
        if (worstRank > 6) {
            worstRank = 6;
        }
        result[0] = bestRank;
        result[1] = worstRank;
        
        return result;
    }
}