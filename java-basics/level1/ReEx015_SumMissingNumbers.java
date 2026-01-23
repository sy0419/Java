public class ReEx015_SumMissingNumbers {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,4,6,7,8,0}));
        System.out.println(solution(new int[] {5,8,4,0,6,7,9}));
    }

    public static int solution(int[] numbers) {
        int total = 45;
        int arrNumTotal = 0;

        for (int i = 0; i < numbers.length; i++) {
            arrNumTotal += numbers[i];
        }

        return total - arrNumTotal;
    }
}