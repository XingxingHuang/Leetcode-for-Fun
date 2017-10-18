// 10.16
// graph dfs to find the path.
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // map for string pairs
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        // map for the value of string paris
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        // bfs search for the shortest
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }
    
    private double dfs(String start, String end, 
                       HashMap<String, ArrayList<String>> pairs, 
                       HashMap<String, ArrayList<Double>> values, 
                       HashSet<String> set, 
                       double value) {
        // found loop / cannot found pair / start=end
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);
        
        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            // found the path
            if (tmp != 0.0) break;
        }
        set.remove(start);
        return tmp;
    }
}

// very shor python code 
// https://discuss.leetcode.com/topic/58482/9-lines-floyd-warshall-in-python
// A variation of Floyd–Warshall, computing quotients instead of shortest paths.
// An equation A/B=k is like a graph edge A->B, 
// and (A/B)*(B/C)*(C/D) is like the path A->B->C->D.
def calcEquation(self, equations, values, queries):
    quot = collections.defaultdict(dict)
    for (num, den), val in zip(equations, values):
        quot[num][num] = quot[den][den] = 1.0
        quot[num][den] = val
        quot[den][num] = 1 / val
    for k, i, j in itertools.permutations(quot, 3):
        if k in quot[i] and j in quot[k]:
            quot[i][j] = quot[i][k] * quot[k][j]
    return [quot[num].get(den, -1.0) for num, den in queries]