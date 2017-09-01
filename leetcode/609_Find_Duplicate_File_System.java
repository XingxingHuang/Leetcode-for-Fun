// 2017.08.31
// Hashmap
public class Solution {
    public List < List < String >> findDuplicate(String[] paths) {
        HashMap < String, List < String >> map = new HashMap < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                List < String > list = map.getOrDefault(name_cont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }
        List < List < String >> res = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        }
        return res;
    }
}

// using java8
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] tokens = path.split(" ");
            for(int i = 1; i < tokens.length; i++) {
                String file = tokens[i].substring(0, tokens[i].indexOf('('));
                String content = tokens[i].substring(tokens[i].indexOf('(') + 1, tokens[i].indexOf(')'));
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(tokens[0] + "/" + file);
            }
        }
        return map.values().stream().filter(e -> e.size() > 1).collect(Collectors.toList());
    }