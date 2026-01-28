public class ReEx036_StrangeString {
    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    public static String solution(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (i % 2) {
                case 0 -> result += Character.toUpperCase(ch);
                case 1 -> result += Character.toLowerCase(ch);
                default -> result += " ";
            }
        }

        return result;
    }
}