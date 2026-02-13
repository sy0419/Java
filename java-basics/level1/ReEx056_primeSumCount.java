public class ReEx056_primeSumCount {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}));
        System.out.println(solution(new int[] {1, 2, 7, 6, 4}));
    }

    public static int solution(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime(sum)) {
                        result++;
                    }
                }
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