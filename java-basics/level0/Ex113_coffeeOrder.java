// 팀의 막내인 철수는 아메리카노와 카페 라테만 판매하는 카페에서 팀원들의 커피를 사려고 합니다. 
// 아메리카노와 카페 라테의 가격은 차가운 것과 뜨거운 것 상관없이 각각 4500, 5000원입니다. 
// 각 팀원에게 마실 메뉴를 적어달라고 하였고, 그 중에서 메뉴만 적은 팀원의 것은 차가운 것으로 통일하고 
// "아무거나"를 적은 팀원의 것은 차가운 아메리카노로 통일하기로 하였습니다.
// 각 직원이 적은 메뉴가 문자열 배열 order로 주어질 때, 카페에서 결제하게 될 금액을 return 하는 solution 함수를 작성해주세요. order의 원소는 아래의 것들만 들어오고, 각각의 의미는 다음과 같습니다.

// order의 원소	                     의미
// "iceamericano", "americanoice"	차가운 아메리카노
// "hotamericano", "americanohot"	따뜻한 아메리카노
// "icecafelatte", "cafelatteice"	차가운 카페 라테
// "hotcafelatte", "cafelattehot"	따뜻한 카페 라테
// "americano"	                    아메리카노
// "cafelatte"	                    카페 라테
// "anything"	                    아무거나

// 제한사항
// 1 ≤ order의 길이 ≤ 1,000

public class Ex113_coffeeOrder {
    public static void main(String[] args) {
        // 테스트 케이스 실행 # Run test cases
        System.out.println(solution1(new String[] {"cafelatte", "americanoice", "hotcafelatte", "anything"}));
        System.out.println(solution1(new String[] {"americanoice", "americano", "iceamericano"}));
        System.out.println(solution2(new String[] {"cafelatte", "americanoice", "hotcafelatte", "anything"}));
        System.out.println(solution2(new String[] {"americanoice", "americano", "iceamericano"}));
    }

    // 명시적으로 모든 아메리카노 관련 문자열을 비교하는 방식
    // # Explicitly compares all possible americano strings
    public static int solution1(String[] order) {
        int total = 0; // 총 결제 금액 # Total payment

        for (String order1 : order) {
            // 아메리카노 또는 anything이면 4500원 # Americano or anything = 4500
            if (order1.equals("iceamericano") || order1.equals("americanoice")
                || order1.equals("hotamericano") || order1.equals("americanohot")
                || order1.equals("americano") || order1.equals("anything")) {
                total += 4500;
            } else {
                // 나머지는 모두 카페 라테로 처리 # All others = cafe latte = 5000
                total += 5000;
            }
        }

        return total; // 총합 반환 # Return total
    }

    // "cafelatte" 문자열이 포함되어 있는지로 간단히 판단
    // # Uses simple contains() to determine if it's a latte
    public static int solution2(String[] order) {
        int answer = 0; // 총 결제 금액 # Total payment

        for(String o : order) {
            if(o.contains("cafelatte")) {
                // 카페 라테는 5000원 # Latte = 5000
                answer += 5000;
            } else {
                // 나머지는 아메리카노 취급 # Others = americano = 4500
                answer += 4500;
            }
        }

        return answer; // 최종 금액 반환 # Return final total
    }
}