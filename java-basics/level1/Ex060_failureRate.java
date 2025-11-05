// 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 
// 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

// 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
// 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 
// 오렐리를 위해 실패율을 구하는 코드를 완성하라.

// 실패율은 다음과 같이 정의한다.
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

// 제한사항
// 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
// stages의 길이는 1 이상 200,000 이하이다.
// stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
// 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
// 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
// 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
// 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

import java.util.ArrayList;   // 리스트 사용 # For using ArrayList
import java.util.Arrays;      // 배열 출력용 # For printing arrays
import java.util.Collections; // 정렬 기능 # For sorting
import java.util.HashMap;     // 해시맵 사용 # For using HashMap
import java.util.List;        // 리스트 인터페이스 # For List interface
import java.util.Map;         // 맵 인터페이스 # For Map interface

public class Ex060_failureRate {
    public static void main(String[] args) {
        // 테스트 케이스 실행 # Run test cases
        System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[] {4, 4, 4, 4, 4})));
    }

    public static int[] solution(int n, int[] stages) {
        Map<Integer, Double> map = new HashMap<>(); // 각 스테이지의 실패율 저장 # Store failure rate for each stage

        // 각 스테이지별 실패율 계산 # Calculate failure rate for each stage
        for (int i = 1; i <= n; i++) {
            int reached  = 0; // 해당 스테이지에 도달한 유저 수 # Users who reached the stage
            int failed = 0;   // 해당 스테이지에서 실패한 유저 수 # Users who failed the stage

            for (int j = 0; j < stages.length; j++) { // 모든 유저 순회 # Loop through all users
                if (stages[j] >= i) { // 스테이지 i에 도달한 경우 # User reached stage i
                    reached++;
                }
                if (stages[j] == i) { // 스테이지 i에서 실패한 경우 # User stuck on stage i
                    failed++;
                }
            }

            double rate = 0; // 실패율 초기화 # Initialize failure rate
            if (reached != 0) { // 도달한 유저가 있을 때만 계산 # Calculate only if someone reached
                rate = (double) failed / reached;
            }
            map.put(i, rate); // 계산된 실패율 저장 # Store calculated rate in map
        }

        // 실패율 기반으로 스테이지 정렬 # Sort stages by failure rate
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (a, b) -> {
            int compare = Double.compare(map.get(b), map.get(a)); // 실패율 내림차순 # Sort by descending rate
            if (compare == 0) return a - b; // 실패율 같으면 스테이지 번호 오름차순 # If same, sort by stage number ascending
            return compare;
        });
        
        // 정렬된 결과를 배열로 변환 # Convert sorted list to array
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = keyList.get(i);
        }

        return answer; // 결과 반환 # Return final result
    }
}