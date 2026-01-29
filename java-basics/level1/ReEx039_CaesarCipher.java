public class ReEx039_CaesarCipher {
    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                sb.append(' ');
            } else if ('A' <= ch && ch <= 'Z') {
                char shifted = (char) ('A' + (ch - 'A' + n) % 26);
                sb.append(shifted);
            } else if ('a' <= ch && ch <= 'z') {
                char shifted = (char) ('a' + (ch - 'a' + n) % 26);
                sb.append(shifted);
            }
        }
        
        return sb.toString();
    }
}