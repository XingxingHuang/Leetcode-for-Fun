//2017.08.09 XingxingHuang
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.size() < 3) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            } else if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                for (int key : map.keySet()) {
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0){
                        map.remove(key);
                        break;
                    }            
                }
            }
        }
        
        for (int key: map.keySet()) 
            map.put(key, 0);
        
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])) 
                map.put(nums[i], map.get(nums[i]) + 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int key: map.keySet()) {
            if (map.get(key) > nums.length / 3) 
                list.add(key);
        }
        return list;
    }
}


/**
 * 
 * @author  Xingxing Huang  
 * @since   2017.05.05
 * @Time    O(n)    
 * @param   int[]
 * @return  List<Integer>
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        findMajor(nums, 0, nums.length - 1, result);
        return result;
    }
    
    public void findMajor(int[] nums, int start, int end, List<Integer> result) {
        if (nums == null || end - start + 1 <= nums.length / 3) {
            return;
        } // this is important
        int target = nums[end];
        int first = start;
        int last = end;
        for (int i = first; i <= last; i++) {
            if (nums[i] < target) {
                swap(nums, i, first++);
            } else if (nums[i] > target){
                swap(nums, i, last--);
                i--;
            }
        }
        // start, first, last, end,
        if (last - first + 1 > nums.length / 3) {
            result.add(target);
        }
        findMajor(nums, start, first - 1, result);
        findMajor(nums, last + 1, end, result);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 拓展到 k的情况
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int k = 3;
        List<Integer> result = new ArrayList<Integer>();
        findMajority(nums, 0, nums.length - 1, result, 3);
        return result;
    }
    public void findMajority(int[] nums, int start, int end, List<Integer> result, int k){
        if (nums == null || end - start + 1 <= nums.length / k) {return;}
        int target = nums[end];
        int left = start;
        int right = end;
        for (int i = left; i <= right; i++) {
            if (nums[i] < target) {
                swap(nums, i, left++);
            } else if (nums[i] > target) {
                swap(nums, i, right--);
                i--;
            }
        }
        // 中间长度大，那么target 即为最终元素
        if (right - left + 1 > nums.length / k) {result.add(target);}
        // 分别在左边或者右边寻找，
        findMajority(nums, start, left - 1, result, k);
        findMajority(nums, right + 1, end, result, k);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// Moore Majority Vote algorithm
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int size = 3;
        if (nums == null || nums.length < 1) {
            return result;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            // 如果包含key
            if (count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            // 如果hash 数组没有装满
            } else if (count.size() < size - 1) {
                count.put(n, 1);
            // hash 数组满了，更新。
            } else {
                boolean flag = false; // 是否在key中
                for (int i : count.keySet()) {
                    if (count.get(i) == 0 ) {
                        count.remove(i);
                        count.put(n, 1);
                        flag = true;
                        break;
                    }
                }
                if (flag == false) { // 不在key中时，所有计数减一
                    for (int i : count.keySet()) {
                        count.put(i, count.get(i) - 1);    
                    }    
                }
            }
        }
        // 最后计算留在HashMap中的几个的元素的出现次数。
        for (int i : count.keySet()) {
            // System.out.printf("a: %d %d\n", i, count.get(i));
            count.put(i, 0);
        }    
        for (int n: nums) {
            if (count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            }
        }
        for (int i : count.keySet()) {
            if (count.get(i) > nums.length / size) {
                result.add(i);
            }
        }
        return result;
    }
}