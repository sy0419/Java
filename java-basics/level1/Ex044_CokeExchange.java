public class Ex044_CokeExchange {
    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20)); // 기대값: 19
        System.out.println(solution(3, 1, 20)); // 기대값: 9
    }

    public static int solution(int a, int b, int n) {
        int result = 0; // 총 받은 콜라 수 // # Total number of cokes received

        while (n >= a) { // 교환할 수 있을 때만 반복 // # Continue while enough bottles to exchange
            int newbottle = (n / a) * b; // 새로 받은 콜라 병 수 // # Number of new cokes from current bottles
            result += newbottle; // 누적 // # Add to total result
            n = newbottle + (n % a); // 마신 후 생긴 병 + 교환 안 된 병 // # Update n: new bottles + remainder bottles
        }

        return result; // 총 콜라 병 수 반환 // # Return the total number of cokes received
    }
}