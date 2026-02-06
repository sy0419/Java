
import java.util.Arrays;

public class ReEx045_sortByNthChar {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new String[] {"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution1(new String[] {"abce", "abcd", "cdx"}, 2)));

        System.out.println(Arrays.toString(solution2(new String[] {"sun", "bed", "car"}, 1)));
        System.out.println(Arrays.toString(solution2(new String[] {"abce", "abcd", "cdx"}, 2)));
    }

    public static String[] solution1(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            char ch1 = s1.charAt(n);
            char ch2 = s2.charAt(n);

            int gap = ch1 - ch2;

            if (gap == 0) {
                return s1.compareTo(s2);
            } else {
                return gap;
            }
        });

        return strings;
    }

    public static String[] solution2(String[] strings, int n) {
        String[] result = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
        }

        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++) {
            result[i] = strings[i].substring(1);
        }

        return result;
    }
}