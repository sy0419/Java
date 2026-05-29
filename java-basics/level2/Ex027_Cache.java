// 캐시

// 지도개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을 데이터베이스에서 
// 읽어 보여주는 서비스를 개발하고 있다.
// 이 프로그램의 테스팅 업무를 담당하고 있는 어피치는 서비스를 오픈하기 전 각 로직에 대한 성능 측정을 수행하였는데,
// 제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다는 것을 알게 되었다.
// 어피치는 제이지에게 해당 로직을 개선하라고 닦달하기 시작하였고, 제이지는 DB 캐시를 적용하여 성능 개선을 시도하고 있지만 
// 캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.
// 어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.

// 입력 형식
// 캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
// cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
// cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
// 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다. 
// 도시 이름은 최대 20자로 이루어져 있다.

// 출력 형식
// 입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.

// 조건
// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
// cache hit일 경우 실행시간은 1이다.
// cache miss일 경우 실행시간은 5이다.

// 입출력 예제
//  캐시크기                                               도시이름                                                              실행시간
// (cacheSize)	                                          (cities)	
//     3	            ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	               50
//     3	               ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	                   21
//     2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	   60
//     5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	   52
//     2	                                ["Jeju", "Pangyo", "NewYork", "newyork"]	                                           16
//     0	                              ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	                                           25

// Cache

// Jay, who works on the map development team, is developing a service
// that searches city names and displays restaurant posts related to the city from a database.
// During performance testing before release, Apeach discovered that
// the database retrieval logic was taking too long.
// Jay tried applying a DB cache to improve performance,
// but is unsure about the optimal cache size.
// Help Jay by implementing a program that measures execution time based on cache size.

// Input Format
// The input consists of a cache size (cacheSize) and an array of city names (cities).
// cacheSize is an integer where 0 ≤ cacheSize ≤ 30.
// cities is an array of city names with up to 100,000 elements.
// City names consist only of English letters without spaces, numbers, or special characters.
// Case sensitivity does not matter.
// Each city name is at most 20 characters long.

// Output Format
// Return the total execution time while processing the cities in order.

// Conditions
// The cache replacement algorithm uses LRU (Least Recently Used).
// Cache hit execution time is 1.
// Cache miss execution time is 5.

// Example Input / Output
// cacheSize	                                        cities	                                                              result
//     3	    ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	                50
//     3	        ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	                    21
//     2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
//     5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
//     2	                            ["Jeju", "Pangyo", "NewYork", "newyork"]	                                            16
//     0	                          ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	                                            25

import java.util.LinkedList;

public class Ex027_Cache {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    public static int solution(int cacheSize, String[] cities) {
        int result = 0;
        LinkedList<String> cache = new LinkedList<>();

        // 캐시 크기가 0이면 모두 cache miss # If cache size is 0, all requests are cache misses
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        // 도시를 하나씩 탐색 # Iterate through each city
        for (String city : cities) {
            city = city.toLowerCase(); // 대소문자 구분 제거 # Ignore case sensitivity

            // cache hit인 경우 # If cache hit occurs
            if (cache.contains(city)) {
                result += 1; // 실행시간 +1 # Execution time +1
                cache.remove(city); // 기존 위치 제거 # Remove old position
                cache.add(city); // 최근 사용 위치로 이동 # Move to most recently used position
            } else {
                result += 5; // 실행시간 +5 # Execution time +5

                // 캐시가 가득 찬 경우 가장 오래된 데이터 제거 # Remove least recently used data if cache is full
                if (cache.size() == cacheSize) {
                    cache.remove(0);
                }

                // 새 도시 추가 # Add new city to cache
                cache.add(city);
            }
        }

        return result;
    }
}