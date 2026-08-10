// 주차 요금 계산
// 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 
// 아래는 하나의 예시를 나타냅니다.

// 요금표
// 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
// 180	5000	10	600

// 입/출차 기록
// 시각(시:분)	차량 번호    내역
//   05:34	     5961	   입차
//   06:00	     0000      입차
//   06:34	     0000	   출차
//   07:59	     5961	   출차
//   07:59	     0148	   입차
//   18:59	     0000	   입차
//   19:09	     0148	   출차
//   22:59	     5961	   입차
//   23:00	     5961	   출차
//
// 자동차별 주차 요금
// 차량 번호	누적 주차 시간(분)	                주차 요금(원)
//   0000	    34 + 300 = 334	    5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
//   0148	         670	        5000 +⌈(670 - 180) / 10⌉x 600 = 34400
//   5961	    145 + 1 = 146	                      5000
// 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
// 0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
// 00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
// 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
// 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
// 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
// ⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
// 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 
// 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// fees의 길이 = 4
// fees[0] = 기본 시간(분)
// 1 ≤ fees[0] ≤ 1,439
// fees[1] = 기본 요금(원)
// 0 ≤ fees[1] ≤ 100,000
// fees[2] = 단위 시간(분)
// 1 ≤ fees[2] ≤ 1,439
// fees[3] = 단위 요금(원)
// 1 ≤ fees[3] ≤ 10,000
// 1 ≤ records의 길이 ≤ 1,000
//
// records의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다.
// 시각, 차량번호, 내역은 하나의 공백으로 구분되어 있습니다.
// 시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다.
// HH:MM은 00:00부터 23:59까지 주어집니다.
// 잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다.
// 차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.
// 내역은 길이 2 또는 3인 문자열로, IN 또는 OUT입니다. IN은 입차를, OUT은 출차를 의미합니다.
// records의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.
// records는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다.
// 같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.
// 마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다.
// 아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다.
//
// 입출력 예
//          fees	                           records	                                    result
// [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
//                       "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",         [14600, 34400, 5000]
//                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	
//   [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT",
//                       "18:00 0202 OUT","23:58 3961 IN"]	                               [0, 591]
//    [1, 461, 1, 10]	                  ["00:00 1234 IN"]	                               [14841]
//
// 입출력 예 설명
// 입출력 예 #1
// 문제 예시와 같습니다.
// 입출력 예 #2
// 요금표
// 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
//     120	           0	           60	         591
// 입/출차 기록
// 시각(시:분)	차량 번호	내역
// 16:00	3961	IN
// 16:00	0202	IN
// 18:00	3961	OUT
// 18:00	0202	OUT
// 23:58	3961	IN
// 자동차별 주차 요금
// 차량 번호	누적 주차 시간(분)	          주차 요금(원)
//   0202	          120	                     0
//   3961	     120 + 1 = 121	   0 +⌈(121 - 120) / 60⌉x 591 = 591
// 3961번 차량은 2번째 입차된 후에는 출차된 내역이 없으므로, 23:59에 출차되었다고 간주합니다.
// 입출력 예 #3
// 요금표
// 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
//      1	           461	            1	          10
// 입/출차 기록
// 시각(시:분)	차량 번호	내역
//    00:00	     1234	   IN
// 자동차별 주차 요금
// 차량 번호	누적 주차 시간(분)	             주차 요금(원)
//   1234	         1439	        461 +⌈(1439 - 1) / 1⌉x 10 = 14841
// 1234번 차량은 출차 내역이 없으므로, 23:59에 출차되었다고 간주합니다.

// Parking Fee Calculation
// Given a parking fee table and records of cars entering and leaving a parking lot, calculate the parking fee for each car.
// The following is an example.
// Fee Table
// Basic time (minutes)	   Basic fee (won)	 Unit time (minutes)    Unit fee (won)
//         180	               5000	                10	                 600
// Entry/Exit Records
// Time(HH:MM)	 Car number   Status
//   05:34	       5961	        IN
//   06:00	       0000	        IN
//   06:34	       0000	        OUT
//   07:59	       5961	        OUT
//   07:59	       0148	        IN
//   18:59	       0000	        IN
//   19:09	       0148	        OUT
//   22:59	       5961	        IN
//   23:00	       5961	        OUT
// Parking Fees by Car
// Car number	  Total parking time (minutes)	               Parking fee (won)
//    0000	            34 + 300 = 334	          5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
//    0148	                 670	              5000 + ⌈(670 - 180) / 10⌉ x 600 = 34400
//    5961	            145 + 1 = 146	                              5000
// If a car has an entry record but no corresponding exit record, it is considered to have exited at 23:59.
// Car 0000 entered at 18:59 and has no exit record. Therefore, it is considered to have exited at 23:59.
// Based on the entry and exit records from 00:00 to 23:59, calculate the total parking time for each car and settle the parking fees.
// If the total parking time is less than or equal to the basic time, charge only the basic fee.
// If the total parking time exceeds the basic time, charge the basic fee plus the unit fee for each unit of time exceeding the basic time.
// If the excess time is not evenly divisible by the unit time, round it up.
// ⌈a⌉ means the smallest integer that is greater than or equal to a, which means rounding up.
// Given an integer array fees representing the parking fee table and a string array records representing the entry and exit records of cars,
// complete the solution function to return an integer array containing the parking fees for each car in ascending order of car number.

// Constraints
// fees has a length of 4.
// fees[0] = basic time (minutes)
// 1 ≤ fees[0] ≤ 1,439
// fees[1] = basic fee (won)
// 0 ≤ fees[1] ≤ 100,000
// fees[2] = unit time (minutes)
// 1 ≤ fees[2] ≤ 1,439
// fees[3] = unit fee (won)
// 1 ≤ fees[3] ≤ 10,000
// 1 ≤ records.length ≤ 1,000

// Each element of records is in the format "time car number status".
// Time, car number, and status are separated by a single space.
// Time represents when a car enters or exits the parking lot and has the format HH:MM with a length of 5.
// HH:MM is given between 00:00 and 23:59.
// Invalid times such as "25:22" or "09:65" are not given.
// The car number is a 4-digit string consisting of '0'~'9'.
// Status is a string of length 2 or 3 and is either IN or OUT. IN means entry and OUT means exit.
// The elements of records are sorted in ascending order by time.
// records contains only entry and exit records from one day, and a car entering the parking lot will not exit on the following day.
// The same car number does not have multiple records with the same time.
// A car that is not in the parking lot cannot have an exit record.
// A car that is already in the parking lot cannot enter again with the same car number.
// An entry record at 23:59 is not given.
// Invalid inputs, including the cases above, are not given.

// Examples
//          fees	                           records	                                    result
// [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
//                       "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",         [14600, 34400, 5000]
//                        "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	
//   [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT",
//                       "18:00 0202 OUT","23:58 3961 IN"]	                               [0, 591]
//    [1, 461, 1, 10]	                  ["00:00 1234 IN"]	                               [14841]

// Example Explanation
// Example #1
// This is the same as the example in the problem statement.
// Example #2
// Fee Table
// Basic time(minutes)	 Basic fee(won)	  Unit time (minutes)	Unit fee (won)
//       120	               0	              60	             591
// Entry/Exit Records
// Time(HH:MM)    Car number	Status
//   16:00	        3961	      IN
//   16:00	        0202	      IN
//   18:00	        3961	      OUT
//   18:00	        0202	      OUT
//   23:58	        3961	      IN
// Parking Fees by Car
// Car number	Total parking time(minutes)	Parking fee(won)
//    0202	                120	                  0
// 3961	120 + 1 = 121	0 +⌈(121 - 120) / 60⌉x 591 = 591
// Car 3961 has no exit record after its second entry, so it is considered to have exited at 23:59.
// Example #3
// Fee Table
// Basic time(minutes)	Basic fee(won)	Unit time(minutes)	Unit fee (won)
//         1	              461	           1	             10
// Entry/Exit Records
// Time(HH:MM)	Car number	Status
//   00:00	      1234	      IN
// Parking Fees by Car
// Car number	Total parking time(minutes)	           Parking fee (won)
//   1234	              1439	               461 +⌈(1439 - 1) / 1⌉ x 10 = 14841
// Car 1234 has no exit record, so it is considered to have exited at 23:59.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ex046_ParkingFee {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{180, 5000, 10, 600},
                new String[]{
                    "05:34 5961 IN",
                    "06:00 0000 IN",
                    "06:34 0000 OUT",
                    "07:59 5961 OUT",
                    "07:59 0148 IN",
                    "18:59 0000 IN",
                    "19:09 0148 OUT",
                    "22:59 5961 IN",
                    "23:00 5961 OUT"
                }
        )));

        System.out.println(Arrays.toString(solution(
                new int[]{120, 0, 60, 591},
                new String[]{
                    "16:00 3961 IN",
                    "16:00 0202 IN",
                    "18:00 3961 OUT",
                    "18:00 0202 OUT",
                    "23:58 3961 IN"
                }
        )));

        System.out.println(Arrays.toString(solution(
                new int[]{1, 461, 1, 10},
                new String[]{
                    "00:00 1234 IN"
                }
        )));
    }

public static int[] solution(int[] fees, String[] records) {
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금을 저장
        // Store the basic time, basic fee, unit time, and unit fee
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        // 차량번호와 현재 입차 시간을 저장
        // Store each car number and its current entry time
        Map<String, Integer> inTime = new HashMap<>();

        // 차량번호와 누적 주차 시간을 저장
        // Store each car number and its accumulated parking time
        // TreeMap을 사용하여 차량번호를 오름차순으로 정렬
        // Use TreeMap to sort car numbers in ascending order
        Map<String, Integer> totalTime = new TreeMap<>();

        // 계산된 주차 요금을 저장
        // Store the calculated parking fees
        ArrayList<Integer> answer = new ArrayList<>();

        // 모든 입출차 기록을 순서대로 확인
        // Process all entry and exit records in order
        for (String record1 : records) {

            // 하나의 기록을 공백 기준으로 분리
            // Split one record using spaces
            String[] record = record1.split(" ");

            // 기록에서 시간, 차량번호, 입출차 상태를 각각 가져옴
            // Get the time, car number, and entry/exit status from the record
            String time = record[0];
            String carNumber = record[1];
            String inOrOut = record[2];

            // 시간 부분을 ':' 기준으로 시와 분으로 분리
            // Split the time into hours and minutes using ':'
            String[] timeParts = time.split(":");

            // 시간을 계산하기 편하도록 전체 분으로 변환
            // Convert the time into total minutes for easier calculation
            int minutes = Integer.parseInt(timeParts[0]) * 60
                    + Integer.parseInt(timeParts[1]);

            // 입차 기록인 경우
            // If the record is an entry
            if ("IN".equals(inOrOut)) {

                // 해당 차량의 현재 입차 시간을 저장
                // Store the current entry time of the car
                inTime.put(carNumber, minutes);
            }

            // 출차 기록인 경우
            // If the record is an exit
            if ("OUT".equals(inOrOut)) {

                // 해당 차량의 입차 시간을 가져옴
                // Get the entry time of the car
                int startTime = inTime.get(carNumber);

                // 이전까지 누적된 주차 시간을 가져옴
                // Get the parking time accumulated so far
                int previousTime = totalTime.getOrDefault(carNumber, 0);

                // 이번 입차부터 출차까지의 주차 시간을 계산
                // Calculate the parking time for this entry-exit pair
                int parkingTime = minutes - startTime;

                // 기존 누적 시간에 이번 주차 시간을 더함
                // Add the current parking time to the previous accumulated time
                int total = previousTime + parkingTime;

                // 계산된 누적 주차 시간을 저장
                // Store the accumulated parking time
                totalTime.put(carNumber, total);

                // 출차했으므로 현재 입차 기록을 삭제
                // Remove the current entry record because the car has exited
                inTime.remove(carNumber);
            }
        }

        // 아직 출차하지 않은 차량을 확인
        // Find cars that have not exited yet
        for (String carNumber : inTime.keySet()) {

            // 해당 차량의 마지막 입차 시간을 가져옴
            // Get the car's last entry time
            int startTime = inTime.get(carNumber);

            // 출차하지 않은 차량은 23:59에 출차한 것으로 처리
            // Treat cars without an exit record as leaving at 23:59
            int finishedTime = 23 * 60 + 59;

            // 이전까지 누적된 주차 시간을 가져옴
            // Get the parking time accumulated so far
            int previousTime = totalTime.getOrDefault(carNumber, 0);

            // 입차 시간부터 23:59까지의 주차 시간을 계산
            // Calculate the parking time from entry until 23:59
            int parkingTime = finishedTime - startTime;

            // 기존 누적 시간에 마지막 주차 시간을 더함
            // Add the final parking time to the accumulated time
            int total = previousTime + parkingTime;

            // 최종 누적 주차 시간을 저장
            // Store the final accumulated parking time
            totalTime.put(carNumber, total);
        }

        // 차량번호가 작은 순서대로 주차 요금을 계산
        // Calculate parking fees in ascending order of car number
        for (String carNumber : totalTime.keySet()) {

            // 해당 차량의 누적 주차 시간을 가져옴
            // Get the accumulated parking time of the car
            int total = totalTime.get(carNumber);

            // 누적 주차 시간이 기본 시간 이하인 경우
            // If the total parking time is within the basic time
            if (total <= basicTime) {

                // 기본 요금만 청구
                // Charge only the basic fee
                answer.add(basicFee);

            } else {

                // 기본 시간을 제외한 초과 주차 시간을 계산
                // Calculate the parking time exceeding the basic time
                int extraTime = total - basicTime;

                // 초과 시간을 단위 시간으로 나누고 올림하여 추가 요금을 계산
                // Divide the extra time by the unit time and round up to calculate the additional fee
                int totalPayment = basicFee
                        + ((int) Math.ceil((double) extraTime / unitTime) * unitFee);

                // 계산된 최종 주차 요금을 저장
                // Store the calculated parking fee
                answer.add(totalPayment);
            }
        }

        // ArrayList의 크기만큼 결과 배열 생성
        // Create a result array with the same size as the ArrayList
        int[] result = new int[answer.size()];

        // ArrayList의 값을 int 배열로 하나씩 복사
        // Copy each value from the ArrayList into the int array
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        // 차량별 주차 요금 배열 반환
        // Return the parking fee array for each car
        return result;
    }
}