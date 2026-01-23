public class ReEx011_HarshadNumber {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        String strX = Integer.toString(x);
        int digitSum = 0;
        for (int i = 0; i < strX.length(); i++) {
            int digit = strX.charAt(i) - '0';
            digitSum += digit;
        }

        return x % digitSum == 0;
    }
}
