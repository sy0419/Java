// 다리를 지나는 트럭
// 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려고 합니다.
// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
// 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
// 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
// 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
// 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

// 경과 시간    다리를 지난 트럭    다리를 건너는 트럭    대기 트럭
// 0            []                 []                  [7,4,5,6]
// 1~2          []                 [7]                 [4,5,6]
// 3            [7]                [4]                 [5,6]
// 4            [7]                [4,5]               [6]
// 5            [7,4]              [5]                 [6]
// 6~7          [7,4,5]            [6]                 []
// 8            [7,4,5,6]          []                  []

// 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
// solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
// 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
// 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

// 제한 조건
// bridge_length는 1 이상 10,000 이하입니다.
// weight는 1 이상 10,000 이하입니다.
// truck_weights의 길이는 1 이상 10,000 이하입니다.
// 모든 트럭의 무게는 1 이상 weight 이하입니다.

// 입출력 예
// bridge_length    weight    truck_weights                                      return
// 2               10        [7,4,5,6]                                           8
// 100             100       [10]                                                101
// 100             100       [10,10,10,10,10,10,10,10,10,10]                    110

// Trucks on Bridge
// Several trucks are crossing a one-lane bridge over a river in a fixed order.
// Find the minimum number of seconds required for all trucks to cross the bridge.
// The bridge can hold at most bridge_length trucks at a time,
// and it can support a total weight of up to weight.
// However, the weight of a truck that has not completely entered the bridge is ignored.
// For example, suppose a bridge can hold 2 trucks at a time and can support up to 10 kg.
// If trucks weighing [7, 4, 5, 6] kg cross the bridge in order,
// they can cross in the minimum possible time as follows.

// Elapsed time    Trucks crossed    Trucks on bridge    Waiting trucks
// 0               []                []                  [7,4,5,6]
// 1~2             []                [7]                 [4,5,6]
// 3               [7]               [4]                 [5,6]
// 4               [7]               [4,5]               [6]
// 5               [7,4]             [5]                 [6]
// 6~7             [7,4,5]           [6]                 []
// 8               [7,4,5,6]         []                  []

// Therefore, it takes a minimum of 8 seconds for all trucks to cross the bridge.
// Complete the solution function so that it returns the minimum time required
// for all trucks to cross the bridge,
// given bridge_length, weight, and truck_weights.

// Constraints
// bridge_length is between 1 and 10,000.
// weight is between 1 and 10,000.
// The length of truck_weights is between 1 and 10,000.
// Each truck's weight is between 1 and weight.

// Examples
// bridge_length    weight    truck_weights                                      return
// 2               10        [7,4,5,6]                                           8
// 100             100       [10]                                                101
// 100             100       [10,10,10,10,10,10,10,10,10,10]                    110

import java.util.LinkedList;
import java.util.Queue;

public class Ex058_TrucksOnBridge {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[] {10}));
        System.out.println(solution(100, 100,
                new int[] {10,10,10,10,10,10,10,10,10,10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int currentBridgeWeight = 0; // 현재 다리 위 트럭들의 총 무게를 저장한다. # Store the total weight of trucks currently on the bridge.
        int time = 1; // 현재 시간을 저장한다. # Store the current time.
        Queue<Truck> queueTruck = new LinkedList<>(); // 다리 위 트럭을 진입 순서대로 저장한다. # Store trucks on the bridge in entry order.

        for (int truck : truck_weights) {

            // 이미 다리를 건넌 트럭을 제거한다. # Remove trucks that have already crossed the bridge.
            while (!queueTruck.isEmpty()
                    && queueTruck.peek().time + bridge_length < time) {

                Truck firstTruck = queueTruck.poll();
                currentBridgeWeight -= firstTruck.weight;
            }

            // 현재 트럭이 올라갈 수 있을 때까지 기다린다. # Wait until the current truck can enter the bridge.
            while (currentBridgeWeight + truck > weight) {
                Truck firstTruck = queueTruck.poll();

                currentBridgeWeight -= firstTruck.weight;
                time = firstTruck.time + bridge_length;
            }

            // 현재 트럭을 다리에 올린다. # Add the current truck to the bridge.
            Truck currentTruck = new Truck();
            currentTruck.weight = truck;
            currentTruck.time = time;

            queueTruck.add(currentTruck);
            currentBridgeWeight += truck;

            // 다음 트럭이 들어올 시간으로 이동한다. # Move to the time when the next truck can enter.
            time++;
        }

        // 마지막 트럭이 다리를 건너는 시간을 반환한다. # Return the time when the last truck finishes crossing.
        return ((LinkedList<Truck>) queueTruck).peekLast().time + bridge_length;
    }

    public static class Truck {
        int weight; // 트럭의 무게를 저장한다. # Store the truck's weight.
        int time; // 트럭이 다리에 진입한 시간을 저장한다. # Store the time when the truck entered the bridge.
    }
}