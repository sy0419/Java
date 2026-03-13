import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReEx077_PrivacyExpiration {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
            "2022.05.19", 
            new String[] {"A 6", "B 12", "C 3"}, 
            new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
        )));
        System.out.println(Arrays.toString(solution(
            "2020.01.01", 
            new String[] {"Z 3", "D 5"}, 
            new String[] {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
        )));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        int totalDay = (year * 12 * 28) + (month * 28) + day;

        Map<String, Integer> map = new HashMap<>();
        for (String term: terms) {
            String[] part = term.split(" ");
            map.put(part[0], Integer.valueOf(part[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] part = privacies[i].split(" ");
            String[] dates = part[0].split("\\.");
            int yearP = Integer.parseInt(dates[0]);
            int monthP = Integer.parseInt(dates[1]);
            int dayP = Integer.parseInt(dates[2]);
            int expireDay = (yearP * 12 * 28) + (monthP * 28) + dayP;
            int totalExpireDay = expireDay + (map.get(part[1]) * 28) - 1;

            if (totalDay > totalExpireDay) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}