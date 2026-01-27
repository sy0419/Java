public class ReEx027_validateString {
    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        if (4 <= s.length() && s.length() <= 6) {
            for (char c: s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}