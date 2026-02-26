
import java.util.HashMap;

public class ReEx067_unfinishedRunner {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"})); // 예상: "leo"
        System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"})); // 예상: "vinko"
        System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"})); // 예상: "mislav"
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> partiList = new HashMap<>();
        
        for (String name: participant) {
            if (partiList.containsKey(name)) {
                partiList.put(name, partiList.get(name) + 1);
            } else {
                partiList.put(name, 1);
            }
        }

        for (String name: completion) {
            partiList.put(name, partiList.get(name) - 1);
        }

        for (String key : partiList.keySet()) {
            if (partiList.get(key) != 0) {
                return key;
            }
        }

        return "";
    }
}