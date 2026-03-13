public class ReEx078_FlexibleAttendanceReward {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {700, 800, 1100},
                                    new int[][] {{710, 2359, 1050, 700, 650, 631, 659}, 
                                                 {800, 801, 805, 800, 759, 810, 809}, 
                                                 {1105, 1001, 1002, 600, 1059, 1001, 1100}}, 5));
        System.out.println(solution(new int[] {730, 855, 700, 720}, 
                                    new int[][] {{710, 700, 650, 735, 700, 931, 912}, 
                                                 {908, 901, 805, 815, 800, 831, 835}, 
                                                 {705, 701, 702, 705, 710, 710, 711},
                                                 {707, 731, 859, 913, 934, 931, 905}}, 1));
    }
    
    public static int solution(int[] schedules, int[][] timelogs, int startday) {        
        int result = 0;

        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100; 

            minute += 10; 
            if (minute >= 60) { 
                hour += 1;
                minute -= 60;
            }
            int maxTime = hour * 100 + minute; 

            boolean isEligible = true; 

            for (int j = 0; j < timelogs[i].length; j++) { 
                int realDay = (startday - 1 + j) % 7; 

                if (realDay == 5 || realDay == 6) { 
                } else {
                    if (timelogs[i][j] > maxTime) { 
                        isEligible = false;
                        break; 
                    }
                }
            }

            if (isEligible) { 
                result++; 
            }
        }

        return result;
    }
}