public class ReEx073_KakaoPersonalityTest {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
        System.out.println(solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
    }

    public static String solution(String[] survey, int[] choices) {
        String result = "";
        int[] score = new int[8];
        
        for (int i = 0; i < survey.length; i++) {
            char ch1 = survey[i].charAt(0);
            char ch2 = survey[i].charAt(1);
            int choice = choices[i];

            int point = Math.abs(4 - choice);

            if (choice < 4) {
                switch (ch1) {
                    case 'R' -> score[0] += point;
                    case 'T' -> score[1] += point;
                    case 'C' -> score[2] += point;
                    case 'F' -> score[3] += point;
                    case 'J' -> score[4] += point;
                    case 'M' -> score[5] += point;
                    case 'A' -> score[6] += point;
                    case 'N' -> score[7] += point;
                    default -> {
                    }
                }
            } else if (choice > 4) {
                switch (ch2) {
                    case 'R' -> score[0] += point;
                    case 'T' -> score[1] += point;
                    case 'C' -> score[2] += point;
                    case 'F' -> score[3] += point;
                    case 'J' -> score[4] += point;
                    case 'M' -> score[5] += point;
                    case 'A' -> score[6] += point;
                    case 'N' -> score[7] += point;
                    default -> {
                    }
                }
            }
        }

        if (score[0] >= score[1]) {
            result += "R";
        } else {
            result += "T";
        } 
        if (score[2] >= score[3]) {
            result += "C";
        } else {
            result += "F";
        }
        if (score[4] >= score[5]) {
            result += "J";
        } else {
            result += "M";
        }
        if (score[6] >= score[7]) {
            result += "A";
        } else {
            result += "N";
        }
        
        return result;
    }
}