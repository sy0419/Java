// 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 
// 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다. 
// 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

// 제한 조건
// 2016년은 윤년입니다.
// 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

import java.time.DayOfWeek; // 요일 정보를 가져오기 위한 클래스 # Class for getting day of week
import java.time.LocalDate; // 날짜 정보를 가져오기 위한 클래스 # Class for handling dates

public class Ex052_2016Day {
    public static void main(String[] args) {
        System.out.println(solution1(5, 24)); // 배열과 누적합 방식 테스트 # Test using array + cumulative sum
        System.out.println(solution1(3, 5));  // 다른 날짜 테스트 # Test another date
        System.out.println(solution2(5, 24)); // LocalDate 사용 방식 테스트 # Test using LocalDate method
    }
    
    public static String solution1(int a, int b) {
        int[] daysInMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 각 달의 일수 # Number of days in each month
        int totalDays = 0; // 1월 1일부터 입력된 날짜까지 총 일수 # Total days from Jan 1 to the given date

        for (int i = 0; i < a-1; i++) {
            totalDays += daysInMonth[i]; // 이전 달들의 날짜 합산 # Add days of previous months
        }
        totalDays += b; // 입력된 달의 날짜 추가 # Add days of current month

        int dayIndex = (totalDays - 1) % 7; // 1월 1일 금요일 기준 요일 인덱스 계산 # Calculate index from Jan 1 (Friday)
        switch (dayIndex) { 
            case 0 -> { return "FRI"; } // 금요일 # Friday
            case 1 -> { return "SAT"; } // 토요일 # Saturday
            case 2 -> { return "SUN"; } // 일요일 # Sunday
            case 3 -> { return "MON"; } // 월요일 # Monday
            case 4 -> { return "TUE"; } // 화요일 # Tuesday
            case 5 -> { return "WED"; } // 수요일 # Wednesday
            case 6 -> { return "THU"; } // 목요일 # Thursday
            default -> { return "ERROR"; } // 예외 처리 # Safety return
        }
    }

    public static String solution2(int a, int b) {
        DayOfWeek day = LocalDate.of(2016, a, b).getDayOfWeek(); // LocalDate로 날짜 생성 후 요일 가져오기 # Get day of week from LocalDate
        return day.toString(); // DayOfWeek 객체를 문자열로 변환 # Convert DayOfWeek to String like "MON", "TUE"
    }
}