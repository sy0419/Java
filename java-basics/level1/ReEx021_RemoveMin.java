
import java.util.ArrayList;
import java.util.Arrays;

public class ReEx021_RemoveMin {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[] {10})));
    }

    public static int[] solution (int[] arr) {
        ArrayList<Integer> arrResult = new ArrayList<>();
        int minNum = arr[0];

        if (arr.length == 1) {
            return new int[] {-1};
        }
        
        for (int num : arr) {
            if (num < minNum) {
                minNum = num;
            }
        }

        for (int num : arr) {
            if (num != minNum) arrResult.add(num);
        }
        
        int[] result = new int[arr.length - 1];
        for (int i = 0; i < arrResult.size(); i++) {
            result[i] = arrResult.get(i);
        }

        return result;
    }
}
