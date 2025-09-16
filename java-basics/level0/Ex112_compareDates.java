// 정수 배열 date1과 date2가 주어집니다. 두 배열은 각각 날짜를 나타내며 [year, month, day] 꼴로 주어집니다. 
// 각 배열에서 year는 연도를, month는 월을, day는 날짜를 나타냅니다.
// 만약 date1이 date2보다 앞서는 날짜라면 1을, 아니면 0을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// date1의 길이 = date2의 길이 = 3
// 0 ≤ year ≤ 10,000
// 1 ≤ month ≤ 12
// day는 month에 따라 가능한 날짜로 주어집니다.

import java.time.LocalDate;

public class Ex112_compareDates {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print test cases
        System.out.println(solution1(new int[] {2021, 12, 28}, new int[] {2021, 12, 29}));
        System.out.println(solution1(new int[] {1024, 10, 24}, new int[] {1024, 10, 24}));
        System.out.println(solution2(new int[] {2021, 12, 28}, new int[] {2021, 12, 29}));
        System.out.println(solution2(new int[] {1024, 10, 24}, new int[] {1024, 10, 24}));
    }

    // 날짜를 직접 요소별로 비교하는 방식 # Compare year, month, and day manually
    public static int solution1(int[] date1, int[] date2) {
        // 연도 비교 # Compare year
        if (date1[0] < date2[0]) return 1;
        if (date1[0] > date2[0]) return 0;

        // 월 비교 # Compare month
        if (date1[1] < date2[1]) return 1;
        if (date1[1] > date2[1]) return 0;

        // 일 비교 # Compare day
        if (date1[2] < date2[2]) return 1;
        else return 0;  // 같거나 이후인 경우 # Same or after
    }

    // 자바의 LocalDate 클래스를 활용하는 방식 # Use Java's LocalDate class
    public static int solution2(int[] date1, int[] date2) {
        // LocalDate 인스턴스 생성 # Create LocalDate instances
        LocalDate dateA = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate dateB = LocalDate.of(date2[0], date2[1], date2[2]);

        // dateA가 dateB보다 앞서는지 확인 # Check if dateA is before dateB
        if (dateA.isBefore(dateB)) {
            return 1;
        } else {
            return 0;
        }
    }
}