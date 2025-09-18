// 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

// 제한사항
// arr은 길이 1 이상, 100 이하인 배열입니다.
// arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.

public class Ex004_average {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4}));  // 예제 테스트 1 # Example test 1
        System.out.println(solution(new int[] {5, 5}));        // 예제 테스트 2 # Example test 2
    }

    public static double solution(int[] arr) {
        double sum = 0;  // 총합을 저장할 변수 # Variable to store total sum

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];  // 각 요소를 더함 # Add each element to sum
        }

        return sum / arr.length;  // 총합을 길이로 나누어 평균 반환 # Return average by dividing sum by array length
    }
}