/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

// 0929
// recursive DFS
class Solution {
    private Set<Integer> set = new HashSet<>();
    public int getImportance(List<Employee> employees, int id) {
        int val = 0;
        if (set.contains(id)) return 0;
        for (Employee em : employees) {
            if (em.id == id) {
                val += em.importance;
                for (int subid : em.subordinates) {
                    val += getImportance(employees, subid);
                }
                return val;
            }
        }
        return val;
    }
}