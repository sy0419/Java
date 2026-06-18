// News Clustering

// When reading the flood of news articles from various media outlets,
// especially breaking news, there are often many articles with very similar titles,
// making it difficult to find the articles that users actually need.
// Tube, a new employee responsible for developing Daum News,
// was assigned the task of improving this issue so that users could conveniently browse various news articles.
// To determine the direction of development, Tube first searched for articles related to
// "Kakao's Recruitment of New Developers", which had recently become a hot topic.

// Kakao's first open recruitment... Hiring through a 'blind' process
// Kakao's first open recruitment after the merger... Recruiting developers through a blind screening process
// Kakao recruits new developers through a blind screening process
// Kakao open recruitment evaluates only coding ability of new developers
// Kakao's new recruitment... "Only coding skills matter"
// Kakao: "We will hire new developers in 2018 based solely on coding ability."
// Tube noticed that the articles could be divided into those focusing on
// the "blind screening process" and those focusing on the "coding test."
// He thought that grouping them accordingly would be useful for users searching for articles related to Kakao's recruitment.

// While researching papers and materials to establish criteria for grouping similar articles,
// Tube discovered a method called "Jaccard Similarity."
// Jaccard similarity is one of several methods used to measure the similarity between sets.
// The Jaccard similarity J(A, B) between two sets A and B is defined as
// the size of their intersection divided by the size of their union.
// For example, let A = {1, 2, 3} and B = {2, 3, 4}.
// Then A ∩ B = {2, 3} and A ∪ B = {1, 2, 3, 4},
// so J(A, B) = 2 / 4 = 0.5.
// If both sets are empty, division is undefined,
// so J(A, B) is defined as 1 in that case.
// Jaccard similarity can be extended to multisets that allow duplicate elements.
// Suppose multiset A contains three occurrences of "1",
// and multiset B contains five occurrences of "1".
// Then A ∩ B contains min(3, 5) = 3 occurrences of "1",
// and A ∪ B contains max(3, 5) = 5 occurrences of "1".
// If A = {1, 1, 2, 2, 3} and B = {1, 2, 2, 4, 5},
// then A ∩ B = {1, 2, 2} and A ∪ B = {1, 1, 2, 2, 3, 4, 5},
// so J(A, B) = 3 / 7 ≈ 0.42.

// This method can also be used to calculate similarity between strings.
// Given the strings "FRANCE" and "FRENCH",
// we can create multisets by splitting them into two-character substrings.
// The resulting multisets are
// {FR, RA, AN, NC, CE} and {FR, RE, EN, NC, CH}.
// Their intersection is {FR, NC},
// and their union is {FR, RA, AN, NC, CE, RE, EN, CH},
// so J("FRANCE", "FRENCH") = 2 / 8 = 0.25.

// Input Format
// The input consists of two strings, str1 and str2.
// The length of each string is between 2 and 1,000.
// Each string is split into two-character substrings to form a multiset.
// Only pairs consisting entirely of alphabetic characters are considered valid.
// Any pair containing spaces, digits, or special characters is discarded.
// For example, if the input is "ab+",
// only "ab" is included in the multiset, and "b+" is discarded.
// When comparing multiset elements,
// uppercase and lowercase letters are treated as the same.
// "AB", "Ab", and "ab" are considered identical.

// Output Format
// Output the Jaccard similarity of the two input strings.
// Since the similarity value is a real number between 0 and 1,
// multiply it by 65536, discard the fractional part,
// and return only the integer part.

// Example Input and Output
//   str1          str2          answer
//  FRANCE        french         16384
// handshake   shake hands       65536
//  aa1+aa2       AAAA12         43690
//  E=M*C^2      e=m*c^2         65536

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex036_NewsClustering {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        // 문자열 비교 시 대소문자를 무시하기 위해 모두 소문자로 변환 
        // # Convert both strings to lowercase to ignore case differences
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 두 문자열의 다중집합을 저장할 리스트 # Lists to store the multisets of the two strings
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // str1을 두 글자씩 잘라 다중집합 생성 # Create a multiset by slicing str1 into two-character substrings
        for (int i = 0; i < str1.length() - 1; i++) {
            String s1 = str1.substring(i, i + 2);

            // 두 글자를 하나씩 꺼내 영문자인지 검사 # Extract each character and check whether both are alphabetic
            char c1 = s1.charAt(0);
            char c2 = s1.charAt(1);

            // 두 문자 모두 영문자인 경우에만 다중집합에 추가 
            // # Add to the multiset only if both characters are alphabetic
            if ('a' <= c1 && c1 <= 'z' && 'a' <= c2 && c2 <= 'z') {
                list1.add(s1);
            }
        }

        // str2를 두 글자씩 잘라 다중집합 생성 # Create a multiset by slicing str2 into two-character substrings
        for (int i = 0; i < str2.length() - 1; i++) {
            String s2 = str2.substring(i, i + 2);

            // 두 글자를 하나씩 꺼내 영문자인지 검사 # Extract each character and check whether both are alphabetic
            char c1 = s2.charAt(0);
            char c2 = s2.charAt(1);

            // 두 문자 모두 영문자인 경우에만 다중집합에 추가 
            // # Add to the multiset only if both characters are alphabetic
            if ('a' <= c1 && c1 <= 'z' && 'a' <= c2 && c2 <= 'z') {
                list2.add(s2);
            }
        }

        // 각 문자열 원소의 등장 횟수를 저장할 맵 # Maps to store the frequency of each element
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // 교집합 크기 저장 # Store the size of the intersection
        int intersection = 0;

        // list1의 원소 개수 세기 # Count the frequency of elements in list1
        for (String s : list1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        // list2의 원소 개수 세기 # Count the frequency of elements in list2
        for (String s : list2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        // 교집합 크기 계산 (min 사용) # Calculate the intersection size using the minimum frequency
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
        }

        // 합집합에 존재하는 모든 원소를 중복 없이 저장 # Store all unique elements that exist in either multiset
        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());

        // 합집합 크기 저장 # Store the size of the union
        int union = 0;

        // 합집합 크기 계산 (max 사용) # Calculate the union size using the maximum frequency
        for (String key : set) {
            union += Math.max(
                    map1.getOrDefault(key, 0),
                    map2.getOrDefault(key, 0)
            );
        }

        // 두 다중집합이 모두 공집합인 경우 자카드 유사도는 1 
        // # If both multisets are empty, Jaccard similarity is defined as 1
        if (union == 0) {
            return 65536;
        }

        // 자카드 유사도 계산 # Calculate the Jaccard similarity
        double j = (double) intersection / union;

        // 문제 조건에 따라 65536을 곱한 후 정수 반환 # Multiply by 65536 and return the integer part
        return (int) (j * 65536);
    }
}