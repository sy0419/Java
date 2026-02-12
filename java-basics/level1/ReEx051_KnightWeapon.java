public class ReEx051_KnightWeapon {
    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
        System.out.println(solution(10, 3, 2)); 
    }

    public static int solution(int number, int limit, int power) {
        int result = 0;

        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    cnt += 2;
                    if (j * j == i) {
                        cnt--;
                    }
                }
            }

            if (cnt > limit) {
                cnt = power;
            }
            result += cnt;
        }

        return result;
    }
}