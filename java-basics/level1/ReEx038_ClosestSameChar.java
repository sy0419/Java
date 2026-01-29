import java.util.Arrays;

public class ReEx038_ClosestSameChar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
        System.out.println(Arrays.toString(solution("foobar")));
    }

    public static int[] solution(String s) {
        int[] result = new int[s.length()];
        int[] lastIndex = new int[26];

        Arrays.fill(lastIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (lastIndex[idx] == -1) {
                result[i] = -1;
            } else {
                result[i] = i - lastIndex[idx];
            }
            lastIndex[idx] = i;
        }

        return result;
    }
}