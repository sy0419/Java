
import java.util.Arrays;

public class ReEx031_gcdLcm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(2, 5)));
    }

    public static int[] solution(int n, int m) {
        int a = n;
        int b = m;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;
        int lcm = (n * m) / gcd;

        return new int[] {gcd, lcm};
    }
}