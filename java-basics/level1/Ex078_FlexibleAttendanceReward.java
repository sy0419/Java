// 프로그래머스 사이트를 운영하는 그렙에서는 재택근무와 함께 출근 희망 시각을 자유롭게 정하는 유연근무제를 시행하고 있습니다.
// 제도 정착을 위해 오늘부터 일주일 동안 각자 설정한 출근 희망 시각에 늦지 않고 출근한 직원들에게 상품을 주는 이벤트를 진행하려고 합니다.
// 직원들은 일주일동안 자신이 설정한 출근 희망 시각 + 10분까지 어플로 출근해야 합니다. 
// 예를 들어 출근 희망 시각이 9시 58분인 직원은 10시 8분까지 출근해야 합니다.
// 단, 토요일, 일요일의 출근 시각은 이벤트에 영향을 끼치지 않습니다. 
// 직원들은 매일 한 번씩만 어플로 출근하고, 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현됩니다. 
// 예를 들어 10시 13분은 1013이 되고 9시 58분은 958이 됩니다.
// 당신은 직원들이 설정한 출근 희망 시각과 실제로 출근한 기록을 바탕으로 상품을 받을 직원이 몇 명인지 알고 싶습니다.

// 직원 n명이 설정한 출근 희망 시각을 담은 1차원 정수 배열 schedules, 
// 직원들이 일주일 동안 출근한 시각을 담은 2차원 정수 배열 timelogs, 
// 이벤트를 시작한 요일을 의미하는 정수 startday가 매개변수로 주어집니다. 
// 이때 상품을 받을 직원의 수를 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ schedules의 길이 = n ≤ 1,000
// schedules[i]는 i + 1번째 직원이 설정한 출근 희망 시각을 의미합니다.
// 700 ≤ schedules[i] ≤ 1100
// 1 ≤ timelogs의 길이 = n ≤ 1,000
// timelogs[i]의 길이 = 7
// timelogs[i][j]는 i + 1번째 직원이 이벤트 j + 1일차에 출근한 시각을 의미합니다.
// 600 ≤ timelogs[i][j] ≤ 2359
// 1 ≤ startday ≤ 7
// 1은 월요일, 2는 화요일, 3은 수요일, 4는 목요일, 5는 금요일, 6은 토요일, 7은 일요일에 이벤트를 시작했음을 의미합니다.
// 출근 희망 시각과 실제로 출근한 시각을 100으로 나눈 나머지는 59 이하입니다.

public class Ex078_FlexibleAttendanceReward {
    public static void main(String[] args) {
        // 첫 번째 테스트 케이스 # Test case1
        System.out.println(solution(new int[] {700, 800, 1100},
                                    new int[][] {{710, 2359, 1050, 700, 650, 631, 659}, 
                                                 {800, 801, 805, 800, 759, 810, 809}, 
                                                 {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5));

        // 두 번째 테스트 케이스 # Test case 2
        // ⚠ timelogs.length가 schedules.length와 일치하지 않으면 에러 또는 결과 불일치 발생
        System.out.println(solution(new int[] {700, 800, 1100}, 
                                    new int[][] {{710, 700, 650, 735, 700, 931, 912}, 
                                                 {908, 901, 805, 815, 800, 831, 835}, 
                                                 {705, 701, 702, 705, 710, 710, 711}}, 1));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0; // 상품을 받을 직원 수 # number of eligible employees

        for (int i = 0; i < schedules.length; i++) { 
            // 직원별 출근 희망 시각 계산 # calculate employee desired start time
            int hour = schedules[i] / 100; // 시 # hour
            int minute = schedules[i] % 100; // 분 # minute

            minute += 10; // 허용 지각 10분 추가 # add 10 minutes grace period
            if (minute >= 60) { // 60분 이상이면 시간 올림 # if minutes exceed 60
                hour += 1;
                minute -= 60;
            }
            int maxTime = hour * 100 + minute; // 실제 허용 출근 시각 # max allowed time

            boolean isEligible = true; // 해당 직원 상품 대상 여부 # eligibility flag

            for (int j = 0; j < timelogs[i].length; j++) { 
                // 실제 출근 요일 계산 # calculate real weekday (0=월 ~ 6=일)
                int realDay = (startday - 1 + j) % 7; 

                if (realDay == 5 || realDay == 6) { 
                    // 주말은 이벤트 영향 없음 # skip weekends
                } else {
                    if (timelogs[i][j] > maxTime) { 
                        
                        // 하루라도 늦으면 탈락 # if late even once
                        isEligible = false;
                        break; // 더 이상 검사 필요 없음 # stop checking this employee
                    }
                }
            }

            if (isEligible) { 
                result++; // 모든 평일 통과 시 상품 대상 증가 # increment eligible employee count
            }
        }

        return result; // 최종 결과 반환 # return total eligible employees
    }
}