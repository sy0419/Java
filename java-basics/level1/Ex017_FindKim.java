// String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

// 제한 사항
// seoul은 길이 1 이상, 1000 이하인 배열입니다.
// seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
// "Kim"은 반드시 seoul 안에 포함되어 있습니다.

public class Ex017_FindKim {
    public static void main(String[] args) {
        // 테스트 케이스 실행 # Run test case
        System.out.println(solution(new String[] {"Jane", "Kim"}));
    }

    public static String solution(String[] seoul) {
        int index = 0; // "Kim"의 위치를 저장할 변수 # Variable to store the index of "Kim"

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) { // 문자열 비교는 equals 사용 # Use equals for string comparison
                index = i; // 인덱스 저장 # Save the index
                break; // "Kim"은 한 번만 등장하므로 찾으면 종료 # Exit loop after finding "Kim"
            }
        }

        return String.format("Kim is in %d.", index); // 포맷팅된 문자열 반환 # Return formatted string
    }
}