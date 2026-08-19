// 스킬트리
// 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
// 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 
// 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
// 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
// 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
// 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
// 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 
// 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

// 제한 조건
// 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
// 스킬 순서와 스킬트리는 문자열로 표기합니다.
// 예를 들어, C → B → D 라면 "CBD"로 표기합니다
// 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
// skill_trees는 길이 1 이상 20 이하인 배열입니다.
// skill_trees의 원소는 스킬을 나타내는 문자열입니다.
// skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

// 입출력 예
// skill                   skill_trees                return
// "CBD"        ["BACDE", "CBADF", "AECB", "BDA"]       2

// 입출력 예 설명
// "BACDE": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
// "CBADF": 가능한 스킬트리입니다.
// "AECB": 가능한 스킬트리입니다.
// "BDA": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

// Prerequisite Skills
// A prerequisite skill is a skill that must be learned before another skill.
// For example, if the prerequisite skill order is Spark → Lightning Bolt → Thunder, 
// you must learn Lightning Bolt before learning Thunder, 
// and you must learn Spark before learning Lightning Bolt.
// Other skills that are not included in the prerequisite order, such as Healing, can be learned in any order. 
// Therefore, a skill tree such as Spark → Healing → Lightning Bolt → Thunder is possible, 
// while skill trees such as Thunder → Spark or Lightning Bolt → Spark → Healing → Thunder are not possible.
// Given the prerequisite skill order skill and an array skill_trees containing skill trees created by users, 
// write the solution function to return the number of possible skill trees.

// Constraints
// Skills are represented by uppercase English letters, and all strings consist only of uppercase English letters.
// The skill order and skill trees are represented as strings.
// For example, C → B → D is represented as "CBD".
// The length of skill is between 1 and 26, and no skill is duplicated.
// The length of skill_trees is between 1 and 20.
// Each element of skill_trees represents a skill tree.
// Each element of skill_trees has a length between 2 and 26, and no skill is duplicated.

// Example
// skill                   skill_trees                return
// "CBD"        ["BACDE", "CBADF", "AECB", "BDA"]       2

// Example Explanation
// "BACDE": Skill B must be learned after skill C, so this skill tree is invalid.
// "CBADF": This is a valid skill tree.
// "AECB": This is a valid skill tree.
// "BDA": Skill B must be learned after skill C, so this skill tree is invalid.

public class Ex047_SkillTree {
    public static void main(String[] args) {
        System.out.println(solution(
                "CBD",
                new String[]{"BACDE", "CBADF", "AECB", "BDA"}
        ));
    }

    public static int solution(String skill, String[] skill_trees) {
        // 가능한 스킬트리의 개수를 저장한다.
        // Store the number of possible skill trees.
        int result = 0;

        // 주어진 모든 스킬트리를 하나씩 확인한다.
        // Check each given skill tree one by one.
        for (String skill_tree : skill_trees) {

            // 현재 스킬트리에서 다음으로 배워야 하는 선행 스킬의 위치를 저장한다.
            // Store the position of the next prerequisite skill that must be learned.
            int nextIndex = 0;

            // 현재 스킬트리가 가능한 스킬트리인지 나타낸다.
            // Indicate whether the current skill tree is valid.
            boolean possible = true;

            // 현재 스킬트리의 스킬을 앞에서부터 하나씩 확인한다.
            // Check each skill in the current skill tree from left to right.
            for (int i = 0; i < skill_tree.length(); i++) {

                // 현재 확인하고 있는 스킬을 가져온다.
                // Get the skill currently being checked.
                char currentSkill = skill_tree.charAt(i);

                // 현재 스킬이 선행 스킬 순서에 포함되어 있는지 확인한다.
                // Check whether the current skill is included in the prerequisite skill order.
                if (skill.contains(String.valueOf(currentSkill))) {

                    // 현재 스킬이 선행 스킬 순서에서 몇 번째 위치에 있는지 확인한다.
                    // Find the position of the current skill in the prerequisite skill order.
                    int index = skill.indexOf(String.valueOf(currentSkill));

                    // 현재 스킬이 지금 배워야 하는 선행 스킬인지 확인한다.
                    // Check whether the current skill is the next prerequisite skill that must be learned.
                    if (index == nextIndex) {

                        // 현재 선행 스킬을 정상적으로 배웠으므로 다음 선행 스킬을 기다린다.
                        // The current prerequisite skill was learned correctly, so wait for the next prerequisite skill.
                        nextIndex++;

                    } else {

                        // 현재 배워야 하는 선행 스킬보다 뒤의 스킬이 먼저 등장했으므로 불가능한 스킬트리이다.
                        // A later prerequisite skill appeared before the required skill, so this skill tree is invalid.
                        possible = false;

                        // 이미 불가능한 스킬트리이므로 더 이상 확인하지 않는다.
                        // Stop checking because this skill tree is already invalid.
                        break;
                    }
                }
            }

            // 현재 스킬트리의 모든 검사를 통과했다면 가능한 스킬트리의 개수를 증가시킨다.
            // If the current skill tree passed all checks, increase the count of valid skill trees.
            if (possible) {
                result++;
            }
        }

        // 가능한 스킬트리의 총 개수를 반환한다.
        // Return the total number of possible skill trees.
        return result;
    }
}