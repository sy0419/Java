
import java.util.ArrayList;
import java.util.Arrays;

public class ReEx016_DivisibleNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(solution(new int[] {2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(solution(new int[] {3, 2, 6}, 10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                arrList.add(arr[i]);
            }
        }

        if (arrList.isEmpty()) {
            arrList.add(-1);
        }

        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] += arrList.get(i);
        }
        Arrays.sort(result);
        return result;
    }
}