// 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
// 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
// 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

// 제한 조건
// 시험은 최대 10,000 문제로 구성되어있습니다.
// 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
// 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

import java.util.ArrayList; // 리스트 사용을 위한 import # Import ArrayList for dynamic list
import java.util.Arrays;
import java.util.List; // List 인터페이스 import # Import List interface

public class Ex053_MockExam {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,2,3,4,5}))); // 테스트 케이스 1 # Test case 1
        System.out.println(Arrays.toString(solution(new int[] {1,3,2,4,2}))); // 테스트 케이스 2 # Test case 2
    }

    public static int[] solution(int[] answers) {
        // 각 수포자의 찍기 패턴 정의 # Define answer patterns for each student
        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 각 수포자의 맞춘 문제 수를 저장할 변수 # Counters for correct answers per person
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        // 모든 문제를 돌면서 정답 비교 # Compare answers for each question
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == no1[i % no1.length]) cnt1++; // 1번 수포자 확인 # Check pattern 1
            if (answers[i] == no2[i % no2.length]) cnt2++; // 2번 수포자 확인 # Check pattern 2
            if (answers[i] == no3[i % no3.length]) cnt3++; // 3번 수포자 확인 # Check pattern 3
        }

        // 최고 점수 계산 # Find the maximum score
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));

        // 최고 점수를 받은 수포자 번호 저장 리스트 # List to store top scorers
        List<Integer> list = new ArrayList<>();

        if (cnt1 == max) list.add(1); // 1번 수포자가 최고 점수면 추가 # Add student 1 if max
        if (cnt2 == max) list.add(2); // 2번 수포자가 최고 점수면 추가 # Add student 2 if max
        if (cnt3 == max) list.add(3); // 3번 수포자가 최고 점수면 추가 # Add student 3 if max
        
        // 리스트를 배열로 변환 # Convert List to array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i); // 리스트 요소를 배열에 복사 # Copy elements from list to array
        }

        return result; // 결과 배열 반환 # Return result array
    }
}