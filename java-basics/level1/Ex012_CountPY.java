// 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. 
// s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 
// 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

// 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.

// 제한사항
// 문자열 s의 길이 : 50 이하의 자연수
// 문자열 s는 알파벳으로만 이루어져 있습니다.

public class Ex012_CountPY {
    public static void main(String[] args) {
        System.out.println(solution("pPoooyY")); // true 출력 기대 # Expected: true
        System.out.println(solution("Pyy"));     // false 출력 기대 # Expected: false
    }

    public static boolean solution(String s) {
        String integratedS = s.toLowerCase(); // 모든 문자를 소문자로 변환 # Convert all characters to lowercase
        int pCount = 0; // 'p'의 개수를 저장할 변수 # Counter for 'p'
        int yCount = 0; // 'y'의 개수를 저장할 변수 # Counter for 'y'

        for (int i = 0; i < integratedS.length(); i++) {
            char ch = integratedS.charAt(i); // 현재 문자를 가져옴 # Get current character
            if (ch == 'p') {
                pCount++; // 'p'일 경우 카운트 증가 # Increment if character is 'p'
            } else if (ch == 'y') {
                yCount++; // 'y'일 경우 카운트 증가 # Increment if character is 'y'
            }
        }

        return pCount == yCount; // 'p'와 'y' 개수가 같으면 true 반환 # Return true if counts are equal
    }
}