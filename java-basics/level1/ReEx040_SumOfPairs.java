
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class ReEx040_SumOfPairs {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[] {2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution1(new int[] {5, 0, 2, 7})));
        System.out.println(Arrays.toString(solution2(new int[] {2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution2(new int[] {5, 0, 2, 7})));
    }

    public static int[] solution1(int[] numbers) {
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!arrList.contains(sum)) {
                    arrList.add(sum);
                }
            }
        }
        
        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }
        Arrays.sort(result);

        return result;
    }

    public static int[] solution2(int[] numbers) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                treeSet.add(sum);
            }
        }

        int[] result = new int[treeSet.size()];
        int idx = 0;
        for (int num : treeSet) {
            result[idx++] = num;
        }

        return result;
    }
}