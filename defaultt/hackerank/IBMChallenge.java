package defaultt.hackerank;

import java.util.*;

public class IBMChallenge {

    public static List<String> getJSONDiff(String json1String, String json2String) {
        // Write your code here

        Map<String, Object> json1 = parseJson(json1String);
        Map<String, Object> json2 = parseJson(json2String);

        Set<String> differences = json1.keySet();
        differences.addAll(json2.keySet());

        differences.removeIf(key -> json1.containsKey(key) && json2.containsKey(key) && json1.get(key).equals(json2.get(key)));

        List<String> result = new ArrayList<>(differences);
        return result;

    }

    public static Map<String, Object> parseJson(String jsonString) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonString = jsonString.replaceAll("[{}]", "");
        String[] keyValuePairs = jsonString.split(",");
        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":");
            jsonMap.put(entry[0].trim(), entry.length > 1 ? entry[1].trim() : null);
        }
        return jsonMap;
    }

}
