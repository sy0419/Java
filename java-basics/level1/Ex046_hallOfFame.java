// "명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다.
// 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에
// 올려 기념합니다. 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. 
// k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 
// 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

// 이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 
// 예를 들어, k = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 
// 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
// 명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때, 
// 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.

// 제한사항
// 3 ≤ k ≤ 100
// 7 ≤ score의 길이 ≤ 1,000
// 0 ≤ score[i] ≤ 2,000

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex046_hallOfFame {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(solution(4, new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    public static int[] solution(int k, int[] score) {
        ArrayList<Integer> arrlist = new ArrayList<>();  // 명예의 전당 점수 리스트 # Hall of Fame score list
        int[] result = new int[score.length];            // 매일 최하위 점수를 저장할 배열 # Array to store daily lowest scores in Hall of Fame

        for (int i = 0; i < score.length; i++) {
            arrlist.add(score[i]);                      // 오늘 점수를 명예의 전당 후보에 추가 # Add today's score to candidate list
            Collections.sort(arrlist);                   // 명예의 전당 점수 오름차순 정렬 # Sort scores in ascending order
            
            if (arrlist.size() > k) {                    // 명예의 전당 점수가 k개 초과하면 # If more than k scores, remove lowest
                arrlist.remove(0);                       // 최하위 점수 제거 # Remove the lowest score
            }
            
            result[i] = arrlist.get(0);                  // 현재 명예의 전당 최하위 점수 기록 # Record current lowest score in Hall of Fame
        }
        return result;                                   // 결과 배열 반환 # Return result array
    }
}