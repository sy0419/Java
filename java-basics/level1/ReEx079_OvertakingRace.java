import java.util.Arrays;
import java.util.HashMap;

public class ReEx079_OvertakingRace {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"mumu", "soe", "poe", "kai", "mine"}, new String[] {"kai", "kai", "mine", "mine"})));
    }

    public static String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String name: callings) {
            int idx = map.get(name);
            int prevIdx = idx - 1;

            String temp = players[prevIdx];
            players[prevIdx] = players[idx];
            players[idx] = temp;

            map.put(players[prevIdx], prevIdx);
            map.put(players[idx], idx);
        }
        return players;
    }
}