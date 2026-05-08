import java.util.HashMap;
import java.util.Map;

public class ReEx086_GiftPrediction {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"muzi", "ryan", "frodo", "neo"}, 
                                    new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(solution(new String[] {"joy", "brad", "alessandro", "conan", "david"}, 
                                    new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
        System.out.println(solution(new String[] {"a", "b", "c"}, 
                                    new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}));
    }

    public static int solution(String[] friends, String[] gifts) {
        Map<String, Integer> mapping = new HashMap<>();
        int n = friends.length;
        int[][] giftCount = new int[n][n];
        int[] giveCount = new int[n];
        int[] receiveCount = new int[n];
        int[] nextGift = new int[n];

        for(int i = 0; i < friends.length; i++) {
            mapping.put(friends[i], i);
        }

        for(String gift: gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];

            int giverIndex = mapping.get(giver);
            int receiverIndex = mapping.get(receiver);
            giftCount[giverIndex][receiverIndex]++;
            giveCount[giverIndex]++;
            receiveCount[receiverIndex]++;
        }

        for(int i = 0; i < friends.length; i++) {
            for(int j = i+1; j < friends.length; j++) {
                if (giftCount[i][j] > giftCount[j][i]) {
                    nextGift[i]++;
                } else if (giftCount[i][j] == giftCount[j][i]) {
                    int giftValueI = giveCount[i] - receiveCount[i];
                    int giftValueJ = giveCount[j] - receiveCount[j];
                    if (giftValueI > giftValueJ) {
                        nextGift[i]++;
                    } else if (giftValueJ > giftValueI) {
                        nextGift[j]++;
                    } else {}
                }else {
                    nextGift[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, nextGift[i]);
        }
        return result;
    }
}