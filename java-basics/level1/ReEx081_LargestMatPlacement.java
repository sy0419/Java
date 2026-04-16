
import java.util.Arrays;

public class ReEx081_LargestMatPlacement {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5, 3, 2}, 
                            new String[][] {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
                                            {"A", "A", "-1", "B", "B", "B", "B", "-1"}, 
                                            {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, 
                                            {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, 
                                            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, 
                                            {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}}));
    }

    public static int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int mat = mats[idx];
            int row = park.length;
            int col = park[0].length;

            for (int i = 0; i <= row - mat; i++) {
                for (int j = 0; j <= col - mat; j++) {
                    boolean canPlace = true;

                    for (int x = i; x < i + mat; x++) {
                        for (int y = j; y < j + mat; y++) {
                            if (!park[x][y].equals("-1")) {
                                canPlace = false;
                                break;
                            }
                        }
                        if (!canPlace) break;
                    }
                    if (canPlace) return mat;
                }
            } 
        }
        return -1;
    }
}