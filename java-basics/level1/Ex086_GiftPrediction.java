// 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 
// 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

// 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
// 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
// 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 
// 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
// 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
// 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. 
// B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 
// 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
// 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
// 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.

// 친구들의 이름을 담은 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가
// 매개변수로 주어집니다. 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.

// 제한사항
// 2 ≤ friends의 길이 = 친구들의 수 ≤ 50
// friends의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.
// 이름이 같은 친구는 없습니다.
// 1 ≤ gifts의 길이 ≤ 10,000
// gifts의 원소는 "A B"형태의 문자열입니다. A는 선물을 준 친구의 이름 B는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.
// A와 B는 friends의 원소이며 A와 B가 같은 이름인 경우는 존재하지 않습니다.

import java.util.Arrays; // Arrays.asList, indexOf 사용 # for converting array to list

public class Ex086_GiftPrediction {

    public static void main(String[] args) {
        // 테스트 예시 # Test examples
        System.out.println(solution(new String[] {"muzi", "ryan", "frodo", "neo"}, 
                                    new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(solution(new String[] {"joy", "brad", "alessandro", "conan", "david"}, 
                                    new String[] {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}));
        System.out.println(solution(new String[] {"a", "b", "c"}, 
                                    new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}));
    }

    public static int solution(String[] friends, String[] gifts) {
        int n = friends.length; // 친구 수 # number of friends
        int[][] giftCount = new int[n][n]; // 친구 간 선물 횟수 # gifts given from i to j
        int[] giftScore = new int[n]; // 각 친구의 선물 지수 # gift score (give - receive)
        int[] nextMonth = new int[n]; // 다음 달 받을 선물 수 # gifts to receive next month
        int max = 0; // 다음 달 최대 선물 수 # max gifts next month

        // giftCount 채우기 # Fill giftCount array
        for (String gift : gifts) {
            String[] pair = gift.split(" "); // 공백 기준으로 나누기 # split giver and receiver
            int from = Arrays.asList(friends).indexOf(pair[0]); // 선물 준 친구 인덱스 # index of giver
            int to = Arrays.asList(friends).indexOf(pair[1]);   // 선물 받은 친구 인덱스 # index of receiver
            giftCount[from][to]++; // 카운트 증가 # increment gift count
        }

        // giftScore 계산 # Calculate gift score
        for (int i = 0; i < n; i++) {
            int give = 0; // i가 준 선물 총합 # total gifts given by i
            int receive = 0; // i가 받은 선물 총합 # total gifts received by i
            for (int j = 0; j < n; j++) {
                give += giftCount[i][j]; // j에게 준 선물 합산 # sum gifts given
                receive += giftCount[j][i]; // j에게 받은 선물 합산 # sum gifts received
            }
            giftScore[i] = give - receive; // 선물 지수 계산 # calculate gift score
        }

        // nextMonth 계산 # Calculate gifts next month
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftCount[i][j] > giftCount[j][i]) { 
                    nextMonth[i]++; // i가 더 많이 줬으면 i가 한 개 받음 # i receives 1
                } else if (giftCount[i][j] < giftCount[j][i]) {
                    nextMonth[j]++; // j가 더 많이 줬으면 j가 한 개 받음 # j receives 1
                } else { // giftCount[i][j] == giftCount[j][i]
                    if (giftScore[i] > giftScore[j]) {
                        nextMonth[i]++; // giftScore가 더 큰 친구가 받음 # higher gift score receives 1
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonth[j]++;
                    } // 같으면 아무도 안 받음 # equal score, no gift
                }
            }
        }

        // 최대값 계산 # Find max gifts next month
        for (int x : nextMonth) {
            if (x > max) max = x;
        }

        return max; // 다음 달 최대 선물 수 반환 # return max gifts
    }
}