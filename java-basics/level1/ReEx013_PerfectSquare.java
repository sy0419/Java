public class ReEx013_PerfectSquare {
    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(3));
    }

    public static long solution(long n) {
        double x = Math.sqrt(n);
        if (x % 1 == 0) {
            return (long) Math.pow(x+1, 2);
        }
        return -1;
    }
}