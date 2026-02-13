public class ReEx057_countPrimes {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int result = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result++;
            }
        }

        return result;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}