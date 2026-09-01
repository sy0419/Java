// 마법의 엘리베이터
// 마법의 세계에 사는 민수는 아주 높은 탑에 살고 있습니다.
// 탑이 너무 높아서 걸어 다니기 힘든 민수는 마법의 엘리베이터를 만들었습니다.
// 마법의 엘리베이터의 버튼은 특별합니다.
// 마법의 엘리베이터에는 -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼이 있습니다.
// 마법의 엘리베이터의 버튼을 누르면 현재 층 수에 버튼에 적혀 있는 값을 더한 층으로 이동하게 됩니다.
// 단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않습니다.
// 민수의 세계에서는 0층이 가장 아래층이며 엘리베이터는 현재 민수가 있는 층에 있습니다.
// 마법의 엘리베이터를 움직이기 위해서 버튼 한 번당 마법의 돌 한 개를 사용하게 됩니다.

// 예를 들어, 16층에 있는 민수가 0층으로 가려면 -1이 적힌 버튼을 6번,
// -10이 적힌 버튼을 1번 눌러 마법의 돌 7개를 소모하여 0층으로 갈 수 있습니다.
// 하지만, +1이 적힌 버튼을 4번, -10이 적힌 버튼 2번을 누르면 마법의 돌 6개를 소모하여 0층으로 갈 수 있습니다.

// 마법의 돌을 아끼기 위해 민수는 항상 최소한의 버튼을 눌러서 이동하려고 합니다.
// 민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수를 알고 싶습니다.
// 민수와 마법의 엘리베이터가 있는 층을 나타내는 정수 storey 가 주어졌을 때,
// 0층으로 가기 위해 필요한 마법의 돌의 최소값을 return 하도록 solution 함수를 완성하세요.

// 제한사항
// 1 ≤ storey ≤ 100,000,000

// 입출력 예
// storey     result
//   16         6
//  2554        16

// 입출력 예 설명
// 입출력 예 #1
// 문제 예시와 같습니다.
// 입출력 예 #2
// -1, +100이 적힌 버튼을 4번, +10이 적힌 버튼을 5번, -1000이 적힌 버튼을 3번 누르면 0층에 도착 할 수 있습니다.
// 그러므로 16을 return 합니다.

// Magic Elevator
// Minsu lives in a very tall tower in a magical world.
// Since the tower is too high to walk around, Minsu built a magic elevator.
// The buttons on the magic elevator are special.
// The elevator has buttons labeled with integers such as -1, +1, -10, +10, -100, +100,
// whose absolute values are in the form of 10^c (c ≥ 0, where c is an integer).
// When a button is pressed, the elevator moves to the floor obtained by adding the value on the button
// to the current floor. However, if the result of adding the button value to the current floor is less than 0,
// the elevator does not move.
// In Minsu's world, floor 0 is the lowest floor, and the elevator is currently on the floor where Minsu is located.

// Each time Minsu presses a button to move the magic elevator, one magic stone is consumed.
// For example, if Minsu is on the 16th floor and wants to go to the 0th floor,
// he can press the -1 button 6 times and the -10 button once, consuming 7 magic stones.
// However, he can press the +1 button 4 times and the -10 button twice, consuming 6 magic stones.

// To save magic stones, Minsu always wants to reach the destination by pressing the minimum number of buttons.
// Given an integer storey representing the floor where Minsu and the magic elevator are located,
// complete the solution function to return the minimum number of magic stones required to reach floor 0.

// Constraints
// 1 ≤ storey ≤ 100,000,000

// Examples
// storey     result
//   16         6
//  2554        16

// Example Explanation
// Example #1
// It is the same as the example described in the problem.
// Example #2
// Press the -1 and +100 buttons 4 times, the +10 button 5 times, and the -1000 button 3 times to reach floor 0.
// Therefore, the answer is 16.

public class Ex060_MagicElevator {
    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(2554));
    }

    public static int solution(int storey) {
        int result = 0;

        while (storey > 0) {
            int digit = storey % 10;

            // 현재 자릿수가 0~4이면 내림한다. # Round down when the current digit is 0~4.
            if (digit < 5) {
                result += digit;
                storey /= 10;
            }
            // 현재 자릿수가 6~9이면 올림한다. # Round up when the current digit is 6~9.
            else if (digit > 5) {
                result += 10 - digit;
                storey = storey / 10 + 1;
            }
            // 현재 자릿수가 5이면 다음 자릿수를 확인한다. # Check the next digit when the current digit is 5.
            else {
                int nextDigit = (storey / 10) % 10;

                // 다음 자릿수가 5 이상이면 올림한다. # Round up when the next digit is 5 or greater.
                if (nextDigit >= 5) {
                    result += 5;
                    storey = storey / 10 + 1;
                }
                // 다음 자릿수가 4 이하이면 내림한다. # Round down when the next digit is 4 or less.
                else {
                    result += 5;
                    storey /= 10;
                }
            }
        }

        return result;
    }
}