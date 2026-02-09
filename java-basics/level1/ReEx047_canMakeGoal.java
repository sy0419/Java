public class ReEx047_canMakeGoal {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"i", "drink", "water"}, new String[] {"want", "to"},
                                    new String[] {"i", "want", "to", "drink", "water"}));
        System.out.println(solution(new String[] {"i", "water", "drink"}, new String[] {"want", "to"},
                                    new String[] {"i", "want", "to", "drink", "water"}));
    }

    public static String solution(String[] card1, String[] card2, String[] goal) {
        int card1Idx = 0;
        int card2Inx = 0;

        for (String word: goal) {
            if (card1Idx < card1.length && card1[card1Idx].equals(word)) {
                card1Idx++;
            } else if (card2Inx < card2.length && card2[card2Inx].equals(word)) {
                card2Inx++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}