
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReEx083_GetReportResults {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution(new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String r: report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (!reportMap.containsKey(reporter)) {
                reportMap.put(reporter, new HashSet<>());
            }
            reportMap.get(reporter).add(reported);
        }

        for (Map.Entry<String, Set<String>> entry : reportMap.entrySet()) {
            for (String reportedUser : entry.getValue()) {
                if(!countMap.containsKey(reportedUser)) {
                    countMap.put(reportedUser, 1);
                } else {
                    countMap.put(reportedUser, countMap.get(reportedUser) + 1);
                }
            }
        }

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            Set<String> reportedNames = reportMap.get(name);
            if (reportedNames == null) continue;
            for (String reportedUser: reportedNames) {
                if(countMap.get(reportedUser) >= k) {
                    result[i]++;   
                }
            }
        }
        return result;
    }
}
