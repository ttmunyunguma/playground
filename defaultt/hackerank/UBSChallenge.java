package defaultt.hackerank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Search Suggestion System
 */
public class UBSChallenge {


    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
        // Write your code here
        Collections.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        return trie.searchSuggestions(search);
    }

}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            if (curr.suggestions.size() < 3)
                curr.suggestions.add(word); // Add to suggestions list if there's space
        }
    }

    List<List<String>> searchSuggestions(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        for (char c : searchWord.toCharArray()) {
            if (curr != null) {
                curr = curr.children[c - 'a'];
            }
            result.add(curr != null ? curr.suggestions : new ArrayList<>());
        }
        return result;
    }
}

class TrieNode {
    TrieNode[] children;
    List<String> suggestions;

    TrieNode() {
        children = new TrieNode[26];
        suggestions = new ArrayList<>();
    }
}

