public class ReEx032_substringCount {
    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.println(solution("10203", "15"));
    }

    public static int solution(String t, String p) {
        int cnt = 0;
        int pLen = p.length();
        long pLong = Long.parseLong(p);

        for (int i = 0; i <= t.length() - pLen; i++) {
            String tPart = t.substring(i, i + pLen);
            Long tPartLong = Long.valueOf(tPart);

            if (pLong >= tPartLong) {
                cnt++;
            }
        }

        return cnt;
    }
}