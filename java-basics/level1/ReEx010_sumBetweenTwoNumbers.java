public class ReEx010_sumBetweenTwoNumbers {
    public static void main(String[] args) {
        System.out.println(solution(3, 5));
        System.out.println(solution(3, 3));
        System.out.println(solution(5, 3));
    }

    public static long solution(int a, int b) {
        int min;
        int max;
        long result = 0;
        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        for (int i = min; i <= max; i++) {
            result += i;
        }
        return result;
    }
}