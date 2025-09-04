// 정수 배열 arr가 주어집니다. arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고, 
// 50보다 작은 홀수라면 2를 곱합니다. 그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 1,000,000
// 1 ≤ arr의 원소의 값 ≤ 100

import java.util.ArrayList;
import java.util.Arrays;

public class Ex069_convertingASequence1 {
    public static void main(String[] args) {
        // 테스트 케이스 출력 # Print the result of the test cases
        System.out.println(Arrays.toString(solution1(new int[] {1, 2, 3, 100, 99, 98})));
        System.out.println(Arrays.toString(solution2(new int[] {1, 2, 3, 100, 99, 98})));
    }

    public static int[] solution1(int[] arr) {
        ArrayList<Integer> numList = new ArrayList(); 
        // # Create a list to store transformed numbers

        for (int i = 0; i < arr.length; i++) {
            // 조건 1: 50보다 크거나 같고, 짝수이면 2로 나눈다
            // # Condition 1: If number is even and >= 50, divide by 2
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                numList.add(arr[i] / 2);
            } 
            // 조건 2: 50보다 작고, 홀수이면 2를 곱한다
            // # Condition 2: If number is odd and < 50, multiply by 2
            else if (arr[i] < 50 && arr[i] % 2 == 1) {
                numList.add(arr[i] * 2);
            } 
            // 그 외의 경우는 그대로 유지
            // # Otherwise, keep the number as is
            else {
                numList.add(arr[i]);
            }
        }

        // ArrayList를 배열로 변환
        // # Convert ArrayList to int[] array
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = (int) numList.get(i); 
            // # Cast to int because ArrayList stores Object
        }

        return result;
    }
// 특징
// 새로운 ArrayList에 변환된 값을 저장한다.
// 배열 크기만큼 반복하면서 변환된 값들을 리스트에 넣고, 다시 배열로 변환해서 반환한다.
// 원본 배열 arr를 건드리지 않는다.

// 장점
// 원본 배열을 유지해야 하는 경우에 적합하다.
// 변환된 결과를 새로운 배열로 만들어서 반환하기 때문에 안전하다.

// 단점
// ArrayList 사용과 배열 변환 때문에 메모리와 실행시간이 더 든다.
// 큰 배열일 경우 비효율적일 수 있다.

    public static int[] solution2(int[] arr) {
        // # Directly modify the original array
        for (int i = 0; i < arr.length; i++) {
            // 50 이상 짝수는 2로 나누기
            // # Divide by 2 if even and >= 50
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] /= 2;
            }
            // 50 미만 홀수는 2 곱하기
            // # Multiply by 2 if odd and < 50
            else if (arr[i] < 50 && arr[i] % 2 == 1) {
                arr[i] *= 2;
            }
            // 나머지는 그대로 (별도 처리 없음)
            // # Leave the value unchanged otherwise
        }

        return arr; // # Return the modified array
    }
// 특징
// 입력받은 배열 arr 자체를 직접 변경한다.
// 변환된 배열을 그대로 반환한다.

// 장점
// 메모리 효율적이다. 새로운 배열이나 리스트를 만들지 않는다.
// 실행 속도가 빠르다.
// 코드가 간결하다.

// 단점
// 원본 배열이 변하기 때문에 원본 데이터가 필요한 경우에는 문제가 될 수 있다.
// 만약 다른 곳에서도 이 배열을 참조한다면 의도치 않은 변경이 생길 수 있다.
}

// 어떤 방법이 더 나은가?
// 원본 배열을 유지해야 한다면 → solution1처럼 새로운 배열을 만들어서 반환하는 게 안전하다.
// 성능과 메모리가 더 중요하다면, 그리고 원본 배열을 변경해도 괜찮다면 → solution2가 더 나은 선택이다.