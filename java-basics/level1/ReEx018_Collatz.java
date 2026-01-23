public class ReEx018_Collatz {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }

    public static int solution(long num) {
        int cnt = 0;
        while (num != 1) {
            if (cnt > 500) {
                return -1;
            }
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            cnt++;
        }
        return cnt;
    }
}