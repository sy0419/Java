
import java.util.HashMap;

public class ReEx074_KeypadThumbs {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")); 
        System.out.println(solution(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));  
        System.out.println(solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String result = "";

        HashMap<Integer, int[]> keypad = new HashMap<>();
        keypad.put(1, new int[]{0, 0});
        keypad.put(2, new int[]{0, 1});
        keypad.put(3, new int[]{0, 2});
        keypad.put(4, new int[]{1, 0});
        keypad.put(5, new int[]{1, 1});
        keypad.put(6, new int[]{1, 2});
        keypad.put(7, new int[]{2, 0});
        keypad.put(8, new int[]{2, 1});
        keypad.put(9, new int[]{2, 2});
        keypad.put(0, new int[]{3, 1});
        keypad.put(-1, new int[]{3, 0}); 
        keypad.put(-2, new int[]{3, 2});

        int[] leftPos = keypad.get(-1);
        int[] rightPos = keypad.get(-2);
        for (int i = 0; i < numbers.length; i++) {
            int target = numbers[i];
            int[] targetPos = keypad.get(target);
            int leftDistance = Math.abs(leftPos[0] - targetPos[0]) + Math.abs(leftPos[1] - targetPos[1]); 
            int rightDistance = Math.abs(rightPos[0] - targetPos[0]) + Math.abs(rightPos[1] - targetPos[1]); 

            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                result += "L";
                leftPos = targetPos;
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                result += "R";
                rightPos = targetPos;
            } else if (leftDistance < rightDistance) {
                result += "L";
                leftPos = targetPos;
            } else if (leftDistance == rightDistance) {
                if (hand.equals("left")) {
                    result += "L";
                    leftPos = targetPos;
                } else {
                    result += "R";
                    rightPos = targetPos;
                }
            } else {
                result += "R";
                rightPos = targetPos;
            }
        }
        return result;
    }
}
