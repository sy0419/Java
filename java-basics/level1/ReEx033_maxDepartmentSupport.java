
import java.util.Arrays;

public class ReEx033_maxDepartmentSupport {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget -= d[i];
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}