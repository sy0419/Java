// 정수가 담긴 리스트 num_list가 주어질 때, 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.
// When an integer list num_list is given, if the length of the list is 11 or more, return the sum of all elements,
// and if it is 10 or less, return the product of all elements.

public class Ex072_operationsBasedOnLength {
    public static void main(String[] args) {
        // 테스트 케이스 출력
        // Print test case results
        System.out.println(solution(new int[] {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1}));
        System.out.println(solution(new int[] {2, 3, 4, 5}));
    }

    public static int solution(int[] numList) {
        int result;

        // 리스트 길이가 11 이상인 경우 합을 구한다
        // If the list length is 11 or more, calculate the sum
        if (numList.length >= 11) {
            result = 0;
            for (int num : numList) {
                result += num;  // 각 원소를 더한다
                                // Add each element
            }
        } else {
            // 리스트 길이가 10 이하인 경우 곱을 구한다
            // If the list length is 10 or less, calculate the product
            result = 1;
            for (int num : numList) {
                result *= num;  // 각 원소를 곱한다
                                // Multiply each element
            }
        }

        return result;  // 결과 반환
                       // Return the result
    }
}