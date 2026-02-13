public class ReEx054_RepaintingWall {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, new int[] {2, 3, 6})); 
        System.out.println(solution(5, 4, new int[] {1, 3}));     
        System.out.println(solution(4, 1, new int[] {1, 2, 3, 4}));
    }

    public static int solution(int n, int m, int[] section) {
        int result = 1;
        int coverageEnd = section[0] + m - 1;
        
        for (int i = 1; i < section.length; i++) {
            if (section[i] > coverageEnd) {
                result++;
                coverageEnd = section[i] + m - 1;
            }
        }

        return result;
    }
}