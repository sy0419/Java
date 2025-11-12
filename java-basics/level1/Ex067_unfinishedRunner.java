// 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
// 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
// completion의 길이는 participant의 길이보다 1 작습니다.
// 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
// 참가자 중에는 동명이인이 있을 수 있습니다.

import java.util.HashMap;

public class Ex067_unfinishedRunner {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"})); // 예상: "leo"
        System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"})); // 예상: "vinko"
        System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"})); // 예상: "mislav"
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashmap = new HashMap<>(); // 참가자 이름과 등장 횟수를 저장할 해시맵 # HashMap to store participant name and count

        for (String participant1 : participant) {
            hashmap.put(participant1, hashmap.getOrDefault(participant1, 0) + 1); // 참가자 이름 등장 횟수 증가 # Increase count for participant name
        }
        
        for (String completion1 : completion) {
            hashmap.put(completion1, hashmap.get(completion1) - 1); // 완주한 선수는 등장 횟수 1 감소 # Decrease count for completed runner
        }

        for (String name : hashmap.keySet()) {
            if (hashmap.get(name) != 0) {  
                return name; // value가 0이 아닌 사람 반환 = 완주하지 못한 선수 # Return name with value != 0 (unfinished runner)
            }
        }

        return ""; // 안전을 위한 기본 return # Default return (won't actually reach)
    }
}