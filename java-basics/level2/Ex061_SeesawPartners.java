// 시소 짝꿍
// 어느 공원 놀이터에는 시소가 하나 설치되어 있습니다.
// 이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
// 이 시소를 두 명이 마주 보고 탄다고 할 때, 시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어
// 완전한 균형을 이룰 수 있다면 그 두 사람을 시소 짝꿍이라고 합니다.
// 즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
// 사람들의 몸무게 목록 weights가 주어질 때, 시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.

// 제한 사항
// 2 ≤ weights의 길이 ≤ 100,000
// 100 ≤ weights[i] ≤ 1,000
// 몸무게 단위는 N(뉴턴)으로 주어집니다.
// 몸무게는 모두 정수입니다.

// 입출력 예
//        weights           result
// [100,180,360,100,270]      4

// 입출력 예 설명
// {100, 100} 은 서로 같은 거리에 마주보고 앉으면 균형을 이룹니다.
// {180, 360} 은 각각 4(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
// {180, 270} 은 각각 3(m), 2(m) 거리에 마주보고 앉으면 균형을 이룹니다.
// {270, 360} 은 각각 4(m), 3(m) 거리에 마주보고 앉으면 균형을 이룹니다.

// Seesaw Partners
// A seesaw is installed in a playground.
// There are seats located at distances of 2m, 3m, and 4m from the center.
// When two people sit facing each other on the seesaw, they are called seesaw partners
// if the magnitudes of the torques applied by each person cancel each other out and 
// the seesaw is perfectly balanced.
// In other words, two people are seesaw partners if the product of each person's weight
// and the distance between the seesaw axis and their seat is equal on both sides.
// Given an array weights containing people's weights, complete the solution function
// to return the number of pairs of people who can balance the seesaw.

// Constraints
// 2 ≤ length of weights ≤ 100,000
// 100 ≤ weights[i] ≤ 1,000
// The unit of weight is N (Newtons).
// All weights are integers.

// Examples
//        weights           result
// [100,180,360,100,270]      4

// Example Explanation
// {100, 100} can balance the seesaw by sitting at the same distance from the center.
// {180, 360} can balance the seesaw by sitting at distances of 4m and 2m, respectively.
// {180, 270} can balance the seesaw by sitting at distances of 3m and 2m, respectively.
// {270, 360} can balance the seesaw by sitting at distances of 4m and 3m, respectively.

public class Ex061_SeesawPartners {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {100, 180, 360, 100, 270}));
    }

    public static long solution(int[] weights) {
        long result = 0;
        int[] count = new int[1001];

        // 각 몸무게의 사람 수를 저장한다. # Store the number of people for each weight.
        for (int weight : weights) {
            count[weight]++;
        }

        // 시소의 좌석 거리를 저장한다. # Store the possible seat distances.
        int[] distances = {2, 3, 4};

        // 모든 몸무게를 확인한다. # Check every possible weight.
        for (int w = 100; w <= 1000; w++) {

            // 같은 몸무게의 사람들끼리 만들 수 있는 쌍을 계산한다. # Calculate pairs of people with the same weight.
            if (count[w] > 1) {
                result += (long) count[w] * (count[w] - 1) / 2;
            }

            // 현재 사람과 상대방이 앉을 수 있는 모든 거리 조합을 확인한다. # Check all combinations of seat distances.
            for (int distance1 : distances) {
                for (int distance2 : distances) {

                    // 같은 거리에 앉는 경우는 같은 몸무게에서 이미 계산했으므로 제외한다. # Exclude equal distances because they were already handled for the same weight.
                    if (distance1 != distance2) {

                        // 두 사람의 토크가 같아지는 경우만 확인한다. # Check only cases where the two torques are equal.
                        if ((w * distance1) % distance2 == 0) {
                            int partner = w * distance1 / distance2;

                            // 중복 계산을 방지하고 상대방 몸무게가 존재하는지 확인한다. # Prevent duplicate counting and check whether the partner's weight exists.
                            if (partner > w && partner <= 1000 && count[partner] > 0) {
                                result += (long) count[w] * count[partner];
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}