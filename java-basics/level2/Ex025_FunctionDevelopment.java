// 기능개발

// 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
// 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
// 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
// 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 
// 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

// 제한 사항
// 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
// 작업 진도는 100 미만의 자연수입니다.
// 작업 속도는 100 이하의 자연수입니다.
// 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
// 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

// 입출력 예
//        progresses	           speeds	          return
//       [93, 30, 55]	         [1, 30, 5]	          [2, 1]
// [95, 90, 99, 99, 80, 99]	  [1, 1, 1, 1, 1, 1]	 [1, 3, 2]

// 입출력 예 설명
// 입출력 예 #1
// 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
// 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
// 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
// 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
// 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.

// 입출력 예 #2
// 모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 
// 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
// 따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.

// Function Development

// The Programmers team is improving features.
// Each feature can only be deployed when its progress reaches 100%.

// Since each feature has a different development speed,
// a later feature may finish earlier than a previous feature.
// However, later features are deployed together only when previous features are deployed.

// Given an integer array progresses representing current progress,
// and an integer array speeds representing daily development speed,
// return the number of features deployed in each release.

// Constraints
// 1 ≤ number of tasks ≤ 100
// progress < 100
// speed ≤ 100
// Deployment occurs once per day at the end of the day.
// For example, if a task is at 95% progress and develops at 4% per day,
// it will be deployed after 2 days.

// Example Input / Output
//        progresses	           speeds	          return
//       [93, 30, 55]	         [1, 30, 5]	          [2, 1]
// [95, 90, 99, 99, 80, 99]	  [1, 1, 1, 1, 1, 1]	 [1, 3, 2]

// Example Explanation
// Example #1
// Feature 1 finishes in 7 days.
// Feature 2 finishes in 3 days, but waits for Feature 1.
// Feature 3 finishes in 9 days.
// Therefore, [2,1] is returned.

// Example #2
// Remaining days are [5,10,1,1,20,1].
// Even if a feature finishes earlier,
// deployment must wait for previous unfinished features.
// Therefore, [1,3,2] is returned.

import java.util.ArrayList;
import java.util.Arrays;

public class Ex025_FunctionDevelopment {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5})));

        System.out.println(Arrays.toString(solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1})));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length]; // 완료까지 걸리는 날짜 저장 # Store days required for completion

        // 각 기능 완료 날짜 계산 # Calculate completion days for each feature
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i]; // 남은 작업량 계산 # Calculate remaining progress

            // 올림 처리하여 완료 날짜 계산 # Calculate required days with ceiling
            int dayPlus = (int) Math.ceil((double) remain / speeds[i]); 

            days[i] = dayPlus; // 완료 날짜 저장 # Store completion day
        }

        int deployDay = days[0]; // 배포 기준 날짜 # Deployment 기준 day
        int count = 1; // 현재 배포 개수 # Current deployment count

        ArrayList<Integer> list = new ArrayList<>(); // 배포 개수 저장 리스트 # Store deployment counts

        // 기능 배포 그룹화 # Group features by deployment day
        for (int i = 1; i < days.length; i++) {
            // 현재 기능이 기준 날짜 안에 배포 가능 # Deploy together if within deploy day
            if (days[i] <= deployDay) {
                count++;
            } else {
                list.add(count); // 이전 배포 개수 저장 # Save previous deployment count
                deployDay = days[i]; // 새로운 배포 기준 날짜 설정 # Set new deployment day
                count = 1; // 배포 개수 초기화 # Reset deployment count
            }
        }
        list.add(count); // 마지막 배포 그룹 저장 # Save final deployment group

        int[] result = new int[list.size()]; // 결과 배열 생성 # Create result array

        // ArrayList → 배열 변환 # Convert ArrayList to array
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}