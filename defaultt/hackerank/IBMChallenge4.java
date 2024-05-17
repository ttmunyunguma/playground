package defaultt.hackerank;

import java.util.HashMap;
import java.util.Map;

public class IBMChallenge4 {

    public static int getMaxOccurrences(String components, int minLength, int maxLength, int maxUnique) {
        int n = components.length();
        Map<String, Integer> substringCount = new HashMap<>();
        int maxOccurrences = 0;

        for (int length = minLength; length <= maxLength; length++) {
            for (int i = 0; i <= n - length; i++) {
                String substring = components.substring(i, i + length);
                if (countUniqueCharacters(substring) <= maxUnique) {
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                    maxOccurrences = Math.max(maxOccurrences, substringCount.get(substring));
                }
            }
        }
        return maxOccurrences;
    }

    private static int countUniqueCharacters(String s) {
        boolean[] charPresent = new boolean[26]; // assuming the string contains only lowercase letters a-z
        int uniqueCount = 0;

        for (char c : s.toCharArray()) {
            if (!charPresent[c - 'a']) {
                charPresent[c - 'a'] = true;
                uniqueCount++;
            }
        }

        return uniqueCount;
    }
}
