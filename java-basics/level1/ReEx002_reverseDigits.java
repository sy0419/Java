import java.util.ArrayList;
import java.util.Arrays;

public class ReEx002_reverseDigits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        ArrayList<Integer> arr = new ArrayList<>();
        String strNum = Long.toString(n);
        for (int i = strNum.length() - 1; i >= 0; i--) {
            char ch = strNum.charAt(i);
            arr.add(ch - '0');
        }

        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }
}