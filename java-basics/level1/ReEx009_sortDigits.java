import java.util.Arrays;

public class ReEx009_sortDigits {
    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {
        String strN = Long.toString(n);
        char[] arr = strN.toCharArray();

        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder(new String(arr));
        sb.reverse();

        return Long.parseLong(sb.toString());
    }
}