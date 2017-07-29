/**
 * 实际是一个重构有向图的问题，输入是有向边的信息。
 * 如果是无环图，从顶节向下循环。有环就需要考虑同一地点重复访问的问题。
 * 思路是先从起点开始找到一个主要路径，然后在主路径上遇到回路就先遍历回路。结果用stack保存。题目假定了给出的字符串是能构成完整路径的，我们不用担心无解的情况。
 * tips: 
 *  为了快速找到每个点对应的所有目的地，需要建立一个hash表存储从每个机场出发的信息。
 *  输出欧拉回路和欧拉路径的常用算法是Hierholzer's Algorithm 和Fleury's Algorithm，复杂度分别为O(E) 和O(E2)
 * @author  Xingxing Huang  
 * @since   2017.04.21
 * @Time    O(n),   
 * @param   String[][2]
 * @return  List<String>, begin with JFK
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if (tickets == null || tickets.length == 0) {
            return res;
        }
        // 建立hashmap存储机票信息的
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<String>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        // 对图进行DFS的遍历
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            // 处理栈结构
            String cur = stack.peek();
            if (map.containsKey(cur) && !map.get(cur).isEmpty()) {
                stack.push(map.get(cur).poll());
            } else {
                // 处理结果
                res.add(0, stack.pop());
            }
        }
        return res;
    }
}

// DFS递归方法
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> list = new LinkedList<>();

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        dfs(list, "JFK", map);
        return new ArrayList<String>(list);
    }

    private void dfs(LinkedList<String> list, String airport, HashMap<String, PriorityQueue<String>> map){
        while(map.containsKey(airport) && !map.get(airport).isEmpty()){
            dfs(list, map.get(airport).poll(), map);
        }
        list.offerFirst(airport);
    }
}