public class ReEx082_BandageHealingSimulation {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5, 1, 5}, 30, new int[][] {{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        System.out.println(solution(new int[] {3, 2, 7}, 20, new int[][] {{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[] {4, 2, 7}, 20, new int[][] {{1, 15}, {5, 16}, {8, 6}}));
        System.out.println(solution(new int[] {1, 1, 1}, 5, new int[][] {{1, 2}, {3, 2}}));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int bandageTime = bandage[0];
        int bandagePerSec = bandage[1];
        int bandageBonus = bandage[2];
        int maxHealth = health;
        int bandageSuccessCount = 0;
        int time = 1;
        int lastTime = attacks[attacks.length - 1][0];
        int nextAttackIndex = 0;

        while (time <= lastTime) {
            if (nextAttackIndex < attacks.length && time == attacks[nextAttackIndex][0]) {
                health -= attacks[nextAttackIndex][1];
                bandageSuccessCount = 0;
                nextAttackIndex++;
            } else {
                health += bandagePerSec;
                bandageSuccessCount++;
                if (bandageSuccessCount == bandageTime) {
                    health += bandageBonus;
                    bandageSuccessCount = 0;
                }
                health = Math.min(health, maxHealth);
            }
            time++;

            if (health <= 0) {
                return -1;
            }
        }
        return health;
    }
}
