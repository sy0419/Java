// 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
//  X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

// 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 
// 큰 정수인 330입니다. 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 
// 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
// 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.

// 제한사항
// 3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
// X, Y는 0으로 시작하지 않습니다.
// X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.

public class Ex070_PartnerNumber {
    public static void main(String[] args) {
        System.out.println(solution("100", "2345"));
        System.out.println(solution("100", "203045"));
        System.out.println(solution("100", "123450"));
        System.out.println(solution("12321", "42531"));
        System.out.println(solution("5525", "1255"));
    }

    public static String solution(String X, String Y) {
        int[] cntX = new int[10]; // X의 각 숫자(0~9) 등장 횟수 저장 배열 # Count occurrences of each digit in X
        int[] cntY = new int[10]; // Y의 각 숫자(0~9) 등장 횟수 저장 배열 # Count occurrences of each digit in Y

        // X 문자열의 각 문자(숫자)를 순회하며 등장 횟수 증가 # Count digits in X
        for (char x: X.toCharArray()) {
            cntX[x - '0']++;
        }
        
        // Y 문자열의 각 문자(숫자)를 순회하며 등장 횟수 증가 # Count digits in Y
        for (char y: Y.toCharArray()) {
            cntY[y - '0']++;
        }

        StringBuilder sb = new StringBuilder(); // 짝꿍 숫자 조합을 위한 StringBuilder # To build the partner number

        // 9부터 0까지 순회하며 공통으로 등장한 숫자들을 큰 순서대로 추가 # Append digits from 9 to 0 in descending order
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(cntX[i], cntY[i]); // 두 수에서 공통으로 등장한 횟수 # Count of matching digits
            for (int j = 0; j < common; j++) {
                sb.append(i); // 공통 숫자를 짝꿍 결과에 추가 # Append the common digit
            }
        }

        // 공통 숫자가 하나도 없는 경우 # If there is no common digit
        if (sb.length() == 0)  {
            return "-1";    
        }

        // 짝꿍이 모두 0으로만 이루어진 경우 # If all digits are 0
        if (sb.charAt(0) == '0') {
            return "0";
        }

        // 완성된 짝꿍 문자열 반환 # Return the final partner number
        return sb.toString(); 
    }
}