// 실수 flo가 매개 변수로 주어질 때, flo의 정수 부분을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 0 ≤ flo ≤ 100

public class Ex101_floatToInt {
    public static void main(String[] args) {
        // solution1: Math.floor()를 이용한 정수 부분 추출
        System.out.println(solution1(1.42)); // 출력: 1
        System.out.println(solution1(69.32)); // 출력: 69

        // solution2: 명시적 형 변환 (캐스팅)만 사용한 정수 부분 추출
        System.out.println(solution2(1.42)); // 출력: 1
        System.out.println(solution2(69.32)); // 출력: 69 ← 오타 있었던 부분 수정
    }

    // 방법 1: Math.floor()로 실수를 가장 가까운 작은 정수로 만든 뒤, int로 형 변환
    public static int solution1(double flo) {
        return (int) Math.floor(flo); // # Use Math.floor to truncate decimal and cast to int
    }

    // 방법 2: 실수를 바로 int로 캐스팅하면 소수점 이하는 잘림 (floor 효과와 동일)
    public static int solution2(double flo) {
        return (int) flo; // # Directly cast double to int to remove decimal part
    }
}