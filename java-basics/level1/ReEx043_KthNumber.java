
import java.util.Arrays;

public class ReEx043_KthNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0] - 1;
            int j = commands[t][1];
            int k = commands[t][2] - 1;

            int[] sliced = Arrays.copyOfRange(array, i, j);
            Arrays.sort(sliced);
            int number = sliced[k];

            result[t] = number;
        }

        return result;
    }
}