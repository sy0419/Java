public class ReEx024_DivisorSum {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int result = 0;

        for (int i = left; i <= right; i++) {
            int divisorCount = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCount++;
                }
            }
            if (divisorCount % 2 == 0) {
                result += i;
            } else {
                result -= i;
            }
        }

        return result;
    }
}