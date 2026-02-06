public class ReEx044_CokeExchange {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));
    }

    public static int solution(int a, int b, int n) {
        int result = 0;

        while (n >= a) {
            int newbottle = (n / a) * b;
            result += newbottle;
            n = newbottle + (n % a);
        }

        return result;
    }
}