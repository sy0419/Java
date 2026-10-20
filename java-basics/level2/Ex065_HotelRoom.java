// 호텔 대실
// 호텔 예약 시간과 퇴실 후 10분의 청소 시간을 고려하여
// 필요한 최소 객실 수를 구한다.
//
// 제한사항
// book_time의 길이는 1 이상 1,000 이하이다.
// book_time[i]는 [대실 시작 시각, 대실 종료 시각]이다.
// 시각은 "HH:MM" 형식이며 00:00부터 23:59까지이다.
// 시작 시각은 항상 종료 시각보다 빠르다.

// 입출력 예
//                                         book_time	                                                 result
// [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]	    3
//                            [["09:10", "10:10"], ["10:20", "12:20"]]	                                    1
//                  [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	                        3

// Hotel Room
// Given a 2D array of booking times, return the minimum number
// of rooms required, including 10 minutes of cleaning time
// after each guest checks out.
//
// Constraints
// The length of book_time is between 1 and 1,000.
// Each book_time[i] contains a check-in time and a check-out time.
// Times are given in "HH:MM" format, from 00:00 to 23:59.
// The check-in time is always earlier than the check-out time.

// Examples
//                                         book_time	                                                 result
// [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]	    3
//                            [["09:10", "10:10"], ["10:20", "12:20"]]	                                    1
//                  [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	                        3

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex065_HotelRoom {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"15:00", "17:00"}, {"16:40", "18:20"},
                                                    {"14:20", "15:20"},{"14:10", "19:20"},
                                                    {"18:20", "21:20"}}));

        System.out.println(solution(new String[][] {{"09:10", "10:10"},{"10:20", "12:20"}}));

        System.out.println(solution(new String[][] {{"10:20", "12:30"},{"10:20", "12:30"},
                                                    {"10:20", "12:30"}}));
    }

    public static int solution(String[][] book_time) {
        // 예약 시간을 분 단위로 저장할 배열 / Array to store booking times in minutes
        int[][] times = new int[book_time.length][2];

        // 입실 시각을 기준으로 예약 정렬 / Sort bookings by check-in time
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        // 각 객실의 다음 사용 가능 시각을 저장하는 우선순위 큐
        // Priority queue storing when each room becomes available
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < 2; j++) {
                String time = book_time[i][j];

                // 시각에서 시와 분 추출 / Extract hours and minutes
                String hour = time.substring(0, 2);
                String minute = time.substring(3, 5);

                int h = Integer.parseInt(hour);
                int m = Integer.parseInt(minute);

                // 시각을 자정부터 경과한 분으로 변환 / Convert time to minutes since midnight
                int totalTime = h * 60 + m;
                times[i][j] = totalTime;
            }
        }

        for (int[] time : times) {
            // 첫 예약이면 객실을 배정 / Assign a room for the first booking
            if (rooms.isEmpty()) {
                rooms.offer(time[1] + 10);
            } else {
                // 가장 빨리 사용 가능한 객실을 재사용할 수 있는지 확인
                // Check whether the earliest available room can be reused
                if (rooms.peek() <= time[0]) {
                    // 기존 사용 가능 시각 제거 / Remove the previous availability time
                    rooms.poll();

                    // 퇴실 후 청소 시간 10분을 더해 저장
                    // Store the new availability time, including 10 minutes for cleaning
                    rooms.offer(time[1] + 10);
                } else {
                    // 재사용할 수 없으면 새 객실 배정
                    // Assign a new room if the existing room is unavailable
                    rooms.offer(time[1] + 10);
                }
            }
        }

        // 배정된 객실 수 반환 / Return the number of rooms allocated
        return rooms.size();
    }
}