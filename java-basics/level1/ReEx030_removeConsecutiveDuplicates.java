import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReEx030_removeConsecutiveDuplicates {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[] {1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution1(new int[] {4, 4, 4, 3})));
        System.out.println(Arrays.toString(solution2(new int[] {1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution2(new int[] {4, 4, 4, 3})));
    }

    public static int[] solution1(int[] arr) {
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arrList.isEmpty() || arrList.get(arrList.size() - 1) != arr[i]) {
                arrList.add(arr[i]);
            }
        }

        int[] result = new int[arrList.size()];
        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }

        return result;
    }

    public static int[] solution2(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}