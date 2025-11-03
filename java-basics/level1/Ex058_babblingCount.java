// 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 
// 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 
// 연속해서 같은 발음을 하는 것을 어려워합니다. 문자열 배열 babbling이 매개변수로 주었을 때, 
// 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ babbling의 길이 ≤ 100
// 1 ≤ babbling[i]의 길이 ≤ 30
// 문자열은 알파벳 소문자로만 이루어져 있습니다.

public class Ex058_babblingCount {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"aya", "yee", "u", "maa"})); // 1
        System.out.println(solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"})); // 2
    }

    public static int solution(String[] babbling) {
        int result = 0; // 결과 개수 # Count of pronounceable words
        String[] sounds = {"aya", "ye", "woo", "ma"}; // 가능한 발음 # Allowed sounds

        for (String word : babbling) {
            String prevSound = ""; // 이전에 사용한 발음 저장 # Previous sound
            int index = 0; // 현재 word에서 확인할 위치 # Current index in word
            boolean valid = true; // 단어가 유효한지 확인 # Whether the word is valid

            while (index < word.length()) {
                boolean matched = false; // 현재 위치에서 매칭 여부 # Whether current position matched any sound

                for (String sound : sounds) {
                    // 현재 위치에서 sound로 시작하는지 확인 # Check if the word starts with this sound at index
                    if (word.startsWith(sound, index)) {
                        if (sound.equals(prevSound)) { 
                            // 연속 반복이면 유효하지 않음 # Invalid if same sound repeats consecutively
                            valid = false;
                        }
                        prevSound = sound; // 이전 발음을 현재로 갱신 # Update previous sound
                        index += sound.length(); // 인덱스 이동 # Move index forward
                        matched = true;
                        break;
                    }
                }

                if (!matched) { 
                    // 현재 위치에서 어떤 발음도 매칭되지 않으면 유효하지 않음 # Invalid if no sound matched
                    valid = false;
                    break;
                }
                if (!valid) break; // 유효하지 않으면 루프 종료 # Stop loop if invalid
            }

            if (valid) result++; // 유효한 단어이면 결과 증가 # Increase count if valid
        }

        return result; // 결과 반환 # Return count
    }
}