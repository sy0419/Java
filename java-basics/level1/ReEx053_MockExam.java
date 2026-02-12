import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReEx053_MockExam {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[] {1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == no1[i % no1.length]) cnt1++;
            if (answers[i] == no2[i % no2.length]) cnt2++;
            if (answers[i] == no3[i % no3.length]) cnt3++;
        }

        int max = Math.max(cnt1, Math.max(cnt2, cnt3));

        List<Integer> winners = new ArrayList<>();
        if (cnt1 == max) winners.add(1);
        if (cnt2 == max) winners.add(2);
        if (cnt3 == max) winners.add(3);

        int[] result = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            result[i] = winners.get(i);
        }

        return result;
    }
}