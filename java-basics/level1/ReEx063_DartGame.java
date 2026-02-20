public class ReEx063_DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if(Character.isDigit(c)) {
                int score;
                if (c == '1' && (i + 1 < dartResult.length()) && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++;
                } else {
                    score = c - '0';
                }
                i++;

                char bonus = dartResult.charAt(i);
                switch(bonus) {
                    case 'S' -> score = (int) Math.pow(score, 1);
                    case 'D' -> score = (int) Math.pow(score, 2);
                    case 'T' -> score = (int) Math.pow(score, 3);
                    default -> {}
                }
                scores[idx] = score;
                idx++;

                if (i + 1 < dartResult.length()) {
                    char next = dartResult.charAt(i + 1);
                    if (next == '*') {
                        scores[idx - 1] *= 2;
                        if (idx - 2 >= 0) {
                            scores[idx - 2] *= 2;
                        }
                        i++;
                    } else if (next == '#') {
                        scores[idx - 1] *= (-1);
                        i++;
                    }
                }
            }
        }
        int sum = 0;
        for (int s: scores) {
            sum +=s;
        }
        return sum;
    }
}