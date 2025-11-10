// 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 
// 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
// 갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

// 1. 다트 게임은 총 3번의 기회로 구성된다.
// 2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
// 3. 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
// 4. 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
// 5. 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
// 6. 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
// 7. 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
// 8. Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
// 9. 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
// 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

// 입력 형식
// "점수|보너스|[옵션]"으로 이루어진 문자열 3세트. 예) 1S2D*3T

// 점수는 0에서 10 사이의 정수이다.
// 보너스는 S, D, T 중 하나이다.
// 옵선은 *이나 # 중 하나이며, 없을 수도 있다.

// 출력 형식
// 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
// 예) 37

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex063_DartGame {
    public static void main(String[] args) {
        // solution1 테스트 # Testing solution1
        System.out.println(solution1("1S2D*3T"));
        System.out.println(solution1("1D2S#10S"));
        System.out.println(solution1("1D2S0T"));
        System.out.println(solution1("1S*2T*3S"));
        System.out.println(solution1("1D#2S*3S"));
        System.out.println(solution1("1T2D3D#"));
        System.out.println(solution1("1D2S3T*"));

        System.out.println("--------------");

        // solution2 테스트 # Testing solution2
        System.out.println(solution2("1S2D*3T"));
        System.out.println(solution2("1D2S#10S"));
        System.out.println(solution2("1D2S0T"));
        System.out.println(solution2("1S*2T*3S"));
        System.out.println(solution2("1D#2S*3S"));
        System.out.println(solution2("1T2D3D#"));
        System.out.println(solution2("1D2S3T*"));
    }

    // 첫 번째 풀이 # First solution using manual parsing
    public static int solution1(String dartResult) {
        int[] scores = new int[3]; // 점수 배열 # Array to store scores
        int idx = 0; // 현재 점수 인덱스 # Current score index

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            // 숫자 처리 # Handling digit
            if (Character.isDigit(c)) {
                int score;
                // 10점 처리 # Handling 10
                if (c == '1' && (i + 1 < dartResult.length()) && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++;
                } else {
                    score = c - '0';
                }
                i++;

                // 보너스 처리 # Handling bonus
                char bonus = dartResult.charAt(i);
                switch (bonus) {
                    case 'S' -> score = (int) Math.pow(score, 1); // 싱글 # Single
                    case 'D' -> score = (int) Math.pow(score, 2); // 더블 # Double
                    case 'T' -> score = (int) Math.pow(score, 3); // 트리플 # Triple
                }

                scores[idx] = score; // 점수 저장 # Store score
                idx++;

                // 옵션 처리 # Handling option
                if (i + 1 < dartResult.length()) { 
                    char next = dartResult.charAt(i + 1);
                    if (next == '*') { 
                        scores[idx - 1] *= 2; // 스타상 적용 # Apply star
                        if (idx > 1) scores[idx - 2] *= 2; // 이전 점수에도 적용 # Apply to previous score
                        i++;
                    } else if (next == '#') {
                        scores[idx - 1] *= -1; // 아차상 적용 # Apply hash
                        i++; 
                    }
                }
            }
        }

        // 점수 합계 계산 # Calculating total score
        int sum = 0;
        for (int s : scores) sum += s;
        return sum;
    }

    // 두 번째 풀이 # Second solution using regex
    public static int solution2(String dartResult) {
        int[] scores = new int[3]; // 점수 배열 # Array to store scores
        int idx = 0; // 현재 점수 인덱스 # Current score index

        Pattern p = Pattern.compile("(\\d{1,2})([SDT])([*#]?)"); // 점수, 보너스, 옵션 패턴 # Pattern for score, bonus, option
        Matcher m = p.matcher(dartResult);

        while (m.find()) {
            int score = Integer.parseInt(m.group(1)); // 점수 # Score
            String bonus = m.group(2); // 보너스 # Bonus
            String option = m.group(3); // 옵션 # Option

            // 보너스 계산 # Calculating bonus
            switch (bonus) {
                case "S" -> score = score; // 싱글 # Single
                case "D" -> score = score * score; // 더블 # Double
                case "T" -> score = score * score * score; // 트리플 # Triple
            }

            // 옵션 적용 # Applying option
            if (option.equals("*")) {
                score *= 2; // 스타상 적용 # Apply star
                if (idx > 0) scores[idx - 1] *= 2; // 이전 점수에도 적용 # Apply to previous score
            } else if (option.equals("#")) {
                score *= -1; // 아차상 적용 # Apply hash
            }

            scores[idx++] = score; // 점수 저장 # Store score
        }

        return scores[0] + scores[1] + scores[2]; // 총점 반환 # Return total score
    }
}