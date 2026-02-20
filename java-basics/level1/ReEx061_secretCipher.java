
import java.util.ArrayList;
import java.util.List;

public class ReEx061_secretCipher {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c = 'a'; c <= 'z'; c++) {
            list.add(c);
        }

        for (char skipLetter:skip.toCharArray()) {
            list.remove(Character.valueOf(skipLetter));
        }

        for (char letter: s.toCharArray()) {
            int currentIndex = list.indexOf(letter);
            int newIndex = (currentIndex + index) % list.size();
            sb.append(list.get(newIndex));
        }

        return sb.toString();
    }
}