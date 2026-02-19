public class ReEx059_foldBill {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {30, 15}, new int[] {26, 17}));
        System.out.println(solution(new int[] {50, 50}, new int[] {100, 241}));
    }

    public static int solution(int[] wallet, int[] bill) {
        int result = 0;

        int wMin = Math.min(wallet[0], wallet[1]);
        int wMax = Math.max(wallet[0], wallet[1]);
        int bill1 = bill[0];
        int bill2 = bill[1];

        while (true) {
            if ((bill1 <= wMin && bill2 <= wMax) || (bill1 <= wMax && bill2 <= wMin)) {
                break;
            }
            if (bill1 >= bill2) {
                bill1 /= 2;
            } else {
                bill2 /= 2;
            }
            result++;
        }
        return result;
    }
}