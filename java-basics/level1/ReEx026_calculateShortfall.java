public class ReEx026_calculateShortfall {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }

    public static int solution(int price, int money, int count) {
        int total = 0;

        for (int i = 1; i <= count; i++) {
            total += price * i;
        }

        if (total <= money) {
            return 0;
        }

        return total - money;
    }
}