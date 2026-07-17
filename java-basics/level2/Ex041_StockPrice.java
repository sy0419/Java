// 주식 가격
// 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
// 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

// 제한사항
// prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
// prices의 길이는 2 이상 100,000 이하입니다.

// 입출력 예
//     prices	        return
// [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]

// 입출력 예 설명
// 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
// 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
// 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
// 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
// 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.

// Stock Price

// Given an array of stock prices recorded every second,
// return an array indicating how many seconds each price remains
// without dropping.

// Constraints
// Each price is a natural number between 1 and 10,000.
// The length of prices is between 2 and 100,000.

// Example
//     prices	        return
// [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]

// Explanation
// The price of 1 at the first second never drops until the end.
// The price of 2 at the second second never drops until the end.
// The price of 3 at the third second drops after one second.
// Therefore, its duration is 1 second.
// The price of 2 at the fourth second does not drop for 1 second.
// The last price has no following prices, so its duration is 0 seconds.

import java.util.Arrays;

public class Ex041_StockPrice {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {

        // 결과를 저장할 배열
        // Array to store the answer.
        int[] result = new int[prices.length];

        // 현재 가격을 하나씩 선택한다.
        // Select each price as the current reference.
        for (int i = 0; i < prices.length; i++) {

            // 가격이 유지된 시간을 저장한다.
            // Store how long the current price remains without dropping.
            int seconds = 0;

            // 현재 가격 이후의 가격을 확인한다.
            // Check all prices after the current position.
            for (int j = i + 1; j < prices.length; j++) {

                // 1초가 경과한다.
                // One second has passed.
                seconds++;

                // 가격이 처음으로 떨어지면 종료한다.
                // Stop when the price drops for the first time.
                if (prices[j] < prices[i]) {
                    break;
                }
            }

            // 현재 가격의 유지 시간을 저장한다.
            // Store the duration of the current price.
            result[i] = seconds;
        }

        return result;
    }
}