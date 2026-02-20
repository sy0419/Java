
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReEx066_minKeyPress {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD", "AABB"})));
        System.out.println(Arrays.toString(solution(new String[] {"AA"}, new String[] {"BB"})));
        System.out.println(Arrays.toString(solution(new String[] {"AGZ", "BSSS"}, new String[] {"ASA", "BGZ"})));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();

        for (String key: keymap) {
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                int pressCount = i + 1;
                if (!map.containsKey(ch) || map.get(ch) > pressCount) {
                    map.put(ch, pressCount);
                }
            }
        }

        int[] result = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean impossible = false;

            for (int j = 0; j < target.length(); j++) {
                char ch = target.charAt(j);
                if (!map.containsKey(ch)) {
                    impossible = true;
                    break;
                }
                count += map.get(ch);
            }
            if (impossible) {
                result[i] = -1;
            } else {
                result[i] = count;
            }
        }

        return result;
    }
}