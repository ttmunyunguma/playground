package defaultt.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 692
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 * <p>
 * Example 1:
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * <p>
 * Example 2:
 * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
 * Output: ["the","is","sunny","day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordsMap.merge(words[i], 1, Integer::sum);
        }

        List<String> resultingList = new ArrayList<>();

        do{

        }
        while (resultingList.size() < k);



            return null;
    }

    public static void main(String[] args) {
        new TopKFrequentWords().topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2);
    }

}













