import java.util.Arrays;
import java.util.HashMap;

public class ReEx048_memoryScore {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"may", "kein", "kain", "radi"}, new int[] {5, 10, 1, 3}, new String[][] {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}})));
        System.out.println(Arrays.toString(solution(new String[] {"kali", "mari", "don"}, new int[] {11, 1, 55}, new String[][] {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}})));
        System.out.println(Arrays.toString(solution(new String[] {"may", "kein", "kain", "radi"}, new int[] {5, 10, 1, 3}, new String[][] {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}})));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] result = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int total = 0;
            for (String person: photo[i]) {
                if (map.containsKey(person)) {
                    total += map.get(person);
                }
            }
            result[i] = total;
        }

        return result;
    }
}