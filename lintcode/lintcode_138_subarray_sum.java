/**
 * 注意累加和为0的情况。
 * arraylist 的初始化： http://www.itstrike.cn/Question/e74b36fa-c01f-4254-87ec-e549df2abebe.html
 * @author  Xingxing Huang  
 * @since   2017.04.30
 * @Time    O(n),   
 * @param   
 * @return  
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                res.addAll(Arrays.asList(map.get(sum) + 1, i));
                return res;
            }
        }
        return res;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null) {
            return null;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                ArrayList<Integer> res = new ArrayList<Integer>();
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }
        }
        return null;
    }
}
 
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                return new ArrayList<Integer>(Arrays.asList(map.get(sum) + 1, i)) ;
            }
            if (sum == 0) {
                return new ArrayList<Integer>(Arrays.asList(0, i));
            }
        }
        return null;
    }
}