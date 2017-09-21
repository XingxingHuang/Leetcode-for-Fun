// three method 
// O(n2) with O(1)
// O(nlogn) with O(1)
// O(n) with O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {

        final Set<Integer> distinct = new HashSet<Integer>();
        for(int num : nums) {
            if(distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }
}

