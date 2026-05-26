// H-Index

// H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 
// 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
// 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 
// h의 최댓값이 이 과학자의 H-Index입니다.
// 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 
// 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

// 제한사항
// 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
// 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

// 입출력 예
//    citations	     return
// [3, 0, 6, 1, 5]	   3

// 입출력 예 설명
// 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 
// 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

// H-Index

// H-Index is an indicator of a scientist's productivity and impact.
// The value h is determined according to the following rule.
// Among n published papers, if h papers have been cited at least h times,
// and the remaining papers have been cited no more than h times,
// the maximum value of h is the scientist's H-Index.
// Given an integer array citations representing citation counts of papers,
// return the H-Index.

// Constraints
// 1 ≤ number of papers ≤ 1,000
// 0 ≤ citations[i] ≤ 10,000

// Example Input / Output
// citations	     return
// [3, 0, 6, 1, 5]	   3

// Example Explanation
// The scientist has 5 papers.
// Among them, 3 papers have been cited at least 3 times,
// and the remaining 2 papers have been cited at most 3 times.
// Therefore, the H-Index is 3.

import java.util.Arrays;

public class Ex023_HIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
    }

    public static int solution(int[] citations) {

        // 인용 횟수를 오름차순 정렬 # Sort citations in ascending order
        Arrays.sort(citations);

        // 모든 논문 탐색 # Traverse all papers
        for (int i = 0; i < citations.length; i++) {

            // 현재 논문의 인용 수가 남은 논문 수 이상인지 확인
            // Check if citation count is greater than or equal to remaining paper count
            if (citations[i] >= citations.length - i) {

                // 가능한 최대 H-Index 반환
                // Return the possible maximum H-Index
                return citations.length - i;
            }
        }

        // H-Index가 없는 경우 0 반환 # Return 0 if H-Index does not exist
        return 0;
    }
}