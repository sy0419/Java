
import java.util.HashSet;

public class ReEx050_Ponketmon {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,3})); 
        System.out.println(solution(new int[] {3,3,3,2,2,4})); 
        System.out.println(solution(new int[] {3,3,3,2,2,2}));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> differentKind = new HashSet<>();
        
        for (int num : nums) {
            differentKind.add(num);
        }

        return Math.min(differentKind.size(), nums.length/2);
    }
}