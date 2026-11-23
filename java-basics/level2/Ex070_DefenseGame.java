// 디펜스 게임
// 준호는 요즘 디펜스 게임에 푹 빠져 있습니다.
// 디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임입니다.
// 디펜스 게임은 다음과 같은 규칙으로 진행됩니다.
// 준호는 처음에 병사 n명을 가지고 있습니다.
// 매 라운드마다 enemy[i]마리의 적이 등장합니다.
// 남은 병사 중 enemy[i]명 만큼 소모하여 enemy[i]마리의 적을 막을 수 있습니다.
//   예를 들어 남은 병사가 7명이고, 적의 수가 2마리인 경우,
//   현재 라운드를 막으면 7 - 2 = 5명의 병사가 남습니다.
//   남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료됩니다.
// 게임에는 무적권이라는 스킬이 있으며,
// 무적권을 사용하면 병사의 소모없이 한 라운드의 공격을 막을 수 있습니다.
// 무적권은 최대 k번 사용할 수 있습니다.
// 준호는 무적권을 적절한 시기에 사용하여 최대한 많은 라운드를 진행하고 싶습니다.
// 준호가 처음 가지고 있는 병사의 수 n,
// 사용 가능한 무적권의 횟수 k,
// 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열 enemy가 주어집니다.
// 준호가 몇 라운드까지 막을 수 있는지 return 하도록 solution 함수를 완성해 주세요.
//
// 제한사항
// - 1 <= n <= 1,000,000,000
// - 1 <= k <= 500,000
// - 1 <= enemy.length <= 1,000,000
// - 1 <= enemy[i] <= 1,000,000
// - enemy[i]에는 i + 1 라운드에서 공격해오는 적의 수가 담겨 있습니다.
// - 모든 라운드를 막을 수 있는 경우에는 enemy의 길이를 return 합니다.
//
// 입출력 예
// n    k            enemy                result
// 7    3    [4, 2, 4, 5, 3, 3, 1]          5
// 2    4        [3, 3, 3, 3]               4

// 입출력 예 설명
// 예제 1
// 1, 3, 5 라운드의 공격을 무적권으로 막고,
// 2, 4 라운드에 각각 병사를 2명, 5명 소모하면 5라운드까지 막을 수 있습니다.
// 또는 1, 3, 4번째 공격을 무적권으로 막고,
// 2, 5번째 공격에 각각 병사를 2명, 3명 소모하여 5라운드까지 막을 수 있습니다.
// 그보다 많은 라운드를 막는 방법은 없으므로 5를 return 합니다.
// 예제 2
// 모든 공격에 무적권을 사용하여 4라운드까지 막을 수 있습니다.

// Defense Game
// Junho is currently enjoying a defense game.
// In this game, Junho must defend against consecutive enemy attacks in order
// using his n soldiers.
// The game proceeds according to the following rules:
// Junho initially has n soldiers.
// enemy[i] enemies appear in each round.
// He can defend against the enemies by using the same number of soldiers
// as the number of enemies in that round.
//   For example, if he has 7 soldiers and 2 enemies appear,
//   defending the round leaves him with 7 - 2 = 5 soldiers.
//   If the number of enemies is greater than the number of remaining soldiers,
//   the game ends.
// The game provides an invincibility skill.
// When used, it allows him to defend against one round without consuming soldiers.
// The invincibility skill can be used at most k times.
// Junho wants to use the invincibility skill strategically
// to defend against as many rounds as possible.
// Given the initial number of soldiers n,
// the number of available invincibility uses k,
// and an integer array enemy containing the number of enemies attacking in each round,
// complete the solution function to return the maximum number of rounds he can defend.

// Constraints
// - 1 <= n <= 1,000,000,000
// - 1 <= k <= 500,000
// - 1 <= enemy.length <= 1,000,000
// - 1 <= enemy[i] <= 1,000,000
// - enemy[i] represents the number of enemies attacking in round i + 1.
// - If all rounds can be defended, return enemy.length.

// Examples
// n    k            enemy                result
// 7    3    [4, 2, 4, 5, 3, 3, 1]          5
// 2    4        [3, 3, 3, 3]               4

// Example Explanation
// Example 1
// Use invincibility in rounds 1, 3, and 5,
// and use 2 and 5 soldiers in rounds 2 and 4 respectively.
// This allows Junho to defend against 5 rounds.
// Alternatively, use invincibility in rounds 1, 3, and 4,
// and use 2 and 3 soldiers in rounds 2 and 5 respectively.
// No strategy can defend against more rounds, so return 5.
// Example 2
// Junho can use invincibility for every attack
// and defend against all 4 rounds.

import java.util.PriorityQueue;

public class Ex070_DefenseGame {

    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
    }

    public static int solution(int n, int k, int[] enemy) {
         // 무적권을 사용할 라운드의 후보를 저장할 최소 힙 생성 
         // # Create a min-heap to store candidate rounds for invincibility
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 각 라운드의 적의 수를 순서대로 확인 # Check the number of enemies in each round in order
        for (int i = 0; i < enemy.length; i++) {

            // 현재 라운드의 적의 수를 최소 힙에 추가 
            // # Add the number of enemies in the current round to the min-heap
            pq.offer(enemy[i]);

            // 저장된 라운드 수가 무적권 사용 횟수보다 많으면 
            // # If the number of stored rounds exceeds the number of invincibility uses
            if (pq.size() > k) {

                // 적의 수가 가장 적은 라운드는 무적권 후보에서 제외하고 병사를 소모 
                // # Remove the round with the fewest enemies from the invincibility candidates and consume soldiers
                n -= pq.poll();

                // 병사가 음수가 되면 현재 라운드를 막을 수 없으므로 이전까지의 라운드 수 반환 
                // # If the number of soldiers becomes negative, return the number of rounds defended before the current round
                if (n < 0) {
                    return i;
                }
            }
        }

        // 모든 라운드를 막았다면 전체 라운드 수 반환 # If all rounds are defended, return the total number of rounds
        return enemy.length;
    }
}