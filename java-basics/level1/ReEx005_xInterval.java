import java.util.Arrays;

public class ReEx005_xInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));    
        System.out.println(Arrays.toString(solution(4, 3)));  
        System.out.println(Arrays.toString(solution(-4, 2)));
    }

    public static long[] solution(int x, int n) {
        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            result[i] += (long) x * (i + 1);
        }

        return result;
    }
}