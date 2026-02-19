
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReEx060_failureRate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
    }

    public static int[] solution(int n, int[] stages) {
        int TotalPlayers = stages.length;
        HashMap<Integer, Double> failureRate = new HashMap<>();
        int[] stagePlayers = new int[n+2];

        for (int i = 0; i < TotalPlayers; i++) {
            stagePlayers[stages[i]]++;
        }

        int remainingPlayers = TotalPlayers;
        for (int stage = 1; stage <= n; stage++) {
            double rate = 0;
            if (remainingPlayers > 0) {
                rate = stagePlayers[stage] / (double) remainingPlayers;
            }
            failureRate.put(stage, rate);
            remainingPlayers -= stagePlayers[stage];
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(failureRate.entrySet());
        list.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue().compareTo(a.getValue());
            } else {
                return a.getKey() - b.getKey();
            }
        });

        int[] result = new int[n];
        for (int i = 0; i < failureRate.size(); i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}