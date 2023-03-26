package defaultt.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 * Example 1:
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 *
 * Example 2:
 * Input: sentence = "leetcode"
 * Output: false
 */
public class CheckSentencePangram1832 {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] sentenceCharArray = sentence.toCharArray();
        Arrays.sort(sentenceCharArray);
        Map<Character, Integer> characterOccuranceMap = new HashMap<>();
        for (int i = 0; i < sentenceCharArray.length; i++) {
            characterOccuranceMap.merge(sentenceCharArray[i], 1, Integer::sum);
        }
        for (char c : alphabet) {
            if(!characterOccuranceMap.containsKey(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckSentencePangram1832().checkIfPangram("thequickbrownfoxjumpsoverthelazydo"));
    }
}
