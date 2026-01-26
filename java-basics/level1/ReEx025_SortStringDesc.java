import java.util.ArrayList;
import java.util.Collections;

public class ReEx025_SortStringDesc {
    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        ArrayList<String> arrList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arrList.add(String.valueOf(s.charAt(i)));
        }
        Collections.sort(arrList);

        for (int i = arrList.size() - 1; i >= 0; i--) {
            sb.append(arrList.get(i));
        }

        return sb.toString();
    }
}