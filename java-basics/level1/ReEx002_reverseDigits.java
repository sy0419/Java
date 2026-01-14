public class ReEx002_reverseDigits {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }

    public static String solution(int num) {
        String result = "";
        if (num % 2 == 1) {
            result += "Odd";
        } else {
            result += "Even";
        }
        return result;
    }
}