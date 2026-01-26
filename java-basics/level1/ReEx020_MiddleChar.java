public class ReEx020_MiddleChar {
    public static void main(String[] args) {
        System.out.println(solution1("abcde"));
        System.out.println(solution1("qwer"));
        System.out.println(solution2("abcde"));
        System.out.println(solution2("qwer"));
    }

    public static String solution1 (String s) {
        int sLen = s.length();
        String result = "";
        if (sLen % 2 == 0) {
            result += s.charAt(sLen/2 - 1);
            result += s.charAt(sLen/2);
        } else {
            result += s.charAt(sLen/2);
        }
        return result;
    }

    // 코드 리뷰 후 # After code review

    public static String solution2 (String s) {
        int sLen = s.length();
        int mid = sLen / 2;

        if (sLen % 2 == 0) {
            return "" + s.charAt(mid - 1) + s.charAt(mid);
        } else {
            return String.valueOf(s.charAt(mid)); 
        }
    }
}