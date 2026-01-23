public class ReEx012_CountPY {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        String intergrates = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < intergrates.length(); i++) {
            char ch = intergrates.charAt(i);
            if (ch == 'p') {
                pCount++;
            } else if (ch == 'y') {
                yCount++;
            } 
        }
        return pCount == yCount;
    }
}