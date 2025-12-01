// 나만의 카카오 성격 유형 검사지를 만들려고 합니다.
// 성격 유형 검사는 다음과 같은 4개 지표로 성격 유형을 구분합니다. 성격은 각 지표에서 두 유형 중 하나로 결정됩니다.

// 지표 번호  성격 유형
// 1번 지표	  라이언형(R), 튜브형(T)
// 2번 지표	  콘형(C), 프로도형(F)
// 3번 지표	  제이지형(J), 무지형(M)
// 4번 지표	  어피치형(A), 네오형(N)
// 4개의 지표가 있으므로 성격 유형은 총 16(=2 x 2 x 2 x 2)가지가 나올 수 있습니다. 예를 들어, "RFMN"이나 "TCMA"와 같은 성격 유형이 있습니다.
// 검사지에는 총 n개의 질문이 있고, 각 질문에는 아래와 같은 7개의 선택지가 있습니다.

// 매우 비동의  
// 비동의
// 약간 비동의
// 모르겠음
// 약간 동의
// 동의
// 매우 동의
// 각 질문은 1가지 지표로 성격 유형 점수를 판단합니다. 예를 들어, 어떤 한 질문에서 4번 지표로 아래 표처럼 점수를 매길 수 있습니다.

// 선택지	      성격 유형 점수
// 매우 비동의	   네오형 3점
// 비동의	       네오형 2점
// 약간 비동의	   네오형 1점
// 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
// 약간 동의	   어피치형 1점
// 동의	       어피치형 2점
// 매우 동의	   어피치형 3점
// 검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다.
// 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.

// 제한사항
// 1 ≤ survey의 길이 ( = n) ≤ 1,000
// survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나입니다.
// survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
// survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
// choices의 길이 = survey의 길이
// 1 ≤ choices의 원소 ≤ 7

import java.util.HashMap;

public class Ex073_KakaoPersonalityTest {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
        System.out.println(solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = ""; // 최종 성격 유형 문자열 # Final personality type
        HashMap<Character, Integer> map = new HashMap<>(); // 각 성격 유형 점수를 저장하는 맵 # Map to store scores

        // 1. 각 질문별 점수 누적 # Accumulate scores for each question
        for (int i = 0; i < survey.length; i++){
            char first = survey[i].charAt(0); // 비동의 선택 시 점수 받는 성격 유형 # Personality type for disagree
            char second = survey[i].charAt(1); // 동의 선택 시 점수 받는 성격 유형 # Personality type for agree

            if (choices[i] >= 4){
                // 동의 계열 선택 # Agree choice
                // 점수 계산: 4 → 0점, 5 → 1점, 6 → 2점, 7 → 3점 # Calculate score
                map.put(second, map.getOrDefault(second, 0) + (choices[i] - 4));
            } else {
                // 비동의 계열 선택 # Disagree choice
                // 점수 계산: 3 → 1점, 2 → 2점, 1 → 3점 # Calculate score
                map.put(first, map.getOrDefault(first, 0) + (4 - choices[i]));
            }
        }

        String[] arr = {"RT", "CF", "JM", "AN"}; // 지표별 성격 유형 쌍 # Pairs of personality types per indicator

        // 2. 각 지표에서 점수 비교하여 최종 성격 유형 결정 # Determine final personality type per indicator
        for (String str : arr) {
            char first = str.charAt(0); // 지표 첫 번째 유형 # First type
            char second = str.charAt(1); // 지표 두 번째 유형 # Second type

            int scoreFirst = map.getOrDefault(first, 0); // first 점수 # Score of first type
            int scoreSecond = map.getOrDefault(second, 0); // second 점수 # Score of second type

            if (scoreFirst > scoreSecond) {
                answer += first; // first 점수가 높으면 first 선택 # Choose first if higher
            } else if (scoreFirst < scoreSecond) {
                answer += second; // second 점수가 높으면 second 선택 # Choose second if higher
            } else {
                answer += first; // 점수가 같으면 사전순 빠른 first 선택 # If tie, choose first
            }
        }

        return answer; // 최종 성격 유형 반환 # Return final personality type
    }
}