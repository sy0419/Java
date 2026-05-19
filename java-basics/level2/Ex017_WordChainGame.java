// 영어 끝말잇기 # English Word Chain Game

// 1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. // # n players are playing an English word chain game.
// 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다. # The game follows these rules.
// 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다. // # Players say words in order starting from player 1.
// 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다. # After the last player, the turn goes back to player 1.
// 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다. # The next word must start with the last character of the previous word.
// 이전에 등장했던 단어는 사용할 수 없습니다. # Previously used words cannot be reused.
// 한 글자인 단어는 인정되지 않습니다. # Single-letter words are not allowed.

// 다음은 3명이 끝말잇기를 하는 상황을 나타냅니다. # Example of a word chain game with 3 players.
// tank → kick → know → wheel → land → dream → mother → robot → tank
// 위 끝말잇기는 다음과 같이 진행됩니다. # The game proceeds as follows.
// 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다. # Player 1 says "tank" in the first turn.
// 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다. # Player 2 says "kick" in the first turn.
// 3번 사람이 자신의 첫 번째 차례에 know를 말합니다. # Player 3 says "know" in the first turn.
// 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다. # Player 1 says "wheel" in the second turn.
// (계속 진행) # (Continues)
// 끝말잇기를 계속 진행해 나가다 보면, 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다. 
// # Player 3 loses in the third turn because "tank" has already been used.

// 사람의 수 n과 사람들이 순서대로 말한 단어 words가 매개변수로 주어질 때, # Given the number of players n and the words array,
// 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요. 
// # Return the first player who fails and the turn number when they fail.

// 제한 사항 # Constraints
// 끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다. # n is between 2 and 10.
// words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다. # words length is between n and 100.
// 단어의 길이는 2 이상 50 이하입니다. # Word length is between 2 and 50.
// 모든 단어는 알파벳 소문자로만 이루어져 있습니다. # All words contain lowercase English letters only.
// 정답은 [번호, 차례] 형태로 return 해주세요. # Return answer in [player number, turn] format.
// 탈락자가 없다면 [0,0]을 return 합니다. # Return [0,0] if no player fails.

import java.util.Arrays;
import java.util.HashSet;

public class Ex017_WordChainGame {
    public static void main(String[] args) {

        // 테스트 케이스 실행 # Run test cases
        System.out.println(Arrays.toString(solution(3, new String[] {
                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(solution(5, new String[] {
                "hello", "observe", "effect", "take", "either", "recognize", "encourage",
                "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(solution(2, new String[] {
                "hello", "one", "even", "never", "now", "world", "draw"})));
    }

    public static int[] solution(int n, String[] words) {
        int[] result = new int[2]; // 결과 배열 [번호, 차례] 저장 # Store result array [player number, turn]
        HashSet<String> usedWords = new HashSet<>(); // 사용한 단어 저장 # Store used words

        usedWords.add(words[0]); // 첫 단어 저장 # Store first word

        // 두 번째 단어부터 검사 # Check from the second word
        for (int i = 1; i < words.length; i++) {

            // 이전 단어 마지막 문자 가져오기 # Get last character of previous word
            char lastChar = words[i - 1].charAt(words[i - 1].length() - 1);

            // 현재 단어 첫 문자 가져오기 # Get first character of current word
            char currentChar = words[i].charAt(0);

            // 끝말잇기 규칙 위반 검사 # Check word chain rule violation
            if (lastChar != currentChar) {
                result[0] = (i % n) + 1; // 탈락한 사람 번호 계산 # Calculate failed player number
                result[1] = (i / n) + 1; // 탈락한 차례 계산 # Calculate failed turn
                return result; // 결과 반환 # Return result
            }

            // 중복 단어 사용 검사 # Check duplicate word usage
            if (usedWords.contains(words[i])) {
                result[0] = (i % n) + 1; // 탈락한 사람 번호 계산 # Calculate failed player number
                result[1] = (i / n) + 1; // 탈락한 차례 계산 # Calculate failed turn
                return result; // 결과 반환 # Return result
            }

            usedWords.add(words[i]); // 사용한 단어 저장 # Store used word
        }

        return new int[] {0, 0}; // 탈락자 없으면 [0,0] 반환 # Return [0,0] if no failure
    }
}