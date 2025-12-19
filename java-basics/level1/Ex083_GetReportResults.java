// 문제 설명 및 제한사항
// 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다.
// 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
// 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
// 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
// k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
// 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
// 이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 
// 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때, 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return.

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex083_GetReportResults {
    public static void main(String[] args) {
        // 테스트 케이스 1 # Test case 1
        System.out.println(Arrays.toString(solution(new String[] {"muzi", "frodo", "apeach", "neo"},
                new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)));
        // 테스트 케이스 2 # Test case 2
        System.out.println(Arrays.toString(solution(new String[] {"con", "ryan"},
                new String[] {"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 각 유저가 신고한 유저 목록 저장 # Stores users each user has reported
        Map<String, Set<String>> reportMap = new HashMap<>();
        // 각 유저가 신고당한 횟수 저장 # Stores count of reports received per user
        Map<String, Integer> countMap = new HashMap<>();
        // 정지된 유저 목록 저장 # Stores users who are banned
        Set<String> bannedSet = new HashSet<>();
        // 결과 배열 초기화 # Initialize result array
        int[] result = new int[id_list.length];

        // 신고 기록 처리, 중복 신고 제거 # Process reports and remove duplicates
        for (String report1 : report) {
            String[] parts = report1.split(" ");
            String reporter = parts[0];       // 신고한 사람 # Reporter
            String reportedUser = parts[1];   // 신고당한 사람 # Reported user
            if (!reportMap.containsKey(reporter)) {
                reportMap.put(reporter, new HashSet<String>()); 
            }
            reportMap.get(reporter).add(reportedUser);
        }

        // 신고당한 횟수 계산 및 k 이상이면 정지 처리 # Count reports received and add to banned if count >= k
        for (String reporter : reportMap.keySet()) {
            Set<String> reportedSet = reportMap.get(reporter);
            for (String reportedUser : reportedSet) {
                countMap.put(reportedUser, countMap.getOrDefault(reportedUser, 0) + 1);
                if (countMap.get(reportedUser) >= k) {
                    bannedSet.add(reportedUser);
                }
            }
        }

        // 각 유저가 받은 정지 메일 수 계산 # Count how many ban notifications each user receives
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            Set<String> reportedSet = reportMap.get(user);
            int mailCount = 0;
            if (reportedSet != null) {
                for (String reportedUser : reportedSet) {
                    if (bannedSet.contains(reportedUser)) {
                        mailCount++;
                    }
                }
            }
            result[i] = mailCount;
        }
        return result; // 결과 반환 # Return result array
    }
}