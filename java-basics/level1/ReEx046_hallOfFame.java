
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReEx046_hallOfFame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(solution(4, new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    public static int[] solution(int k, int[] score) {
        ArrayList<Integer> resultArr = new ArrayList<>();
        int[] result = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            resultArr.add(score[i]);
            Collections.sort(resultArr);
            if (resultArr.size() > k) {
                resultArr.remove(0);
            }
            result[i] = resultArr.get(0);
        }

        return result;
    }
}