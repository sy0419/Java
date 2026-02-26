
public class ReEx070_PartnerNumber {
    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }

    public static String solution(String X, String Y) {
        int[] cntX = new int[10]; 
        int[] cntY = new int[10]; 

        for (char x: X.toCharArray()) {
            cntX[x - '0']++;
        }

        for (char y: Y.toCharArray()) {
            cntY[y - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(cntX[i], cntY[i]); 
            for (int j = 0; j < common; j++) {
                sb.append(i); 
            }
        }

        if (sb.length() == 0)  {
            return "-1";    
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString(); 
    }
}