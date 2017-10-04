// 10.02  
// bit位从左往右依次确定， 最大数在该位是多少。
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i); // 修改mask的第i位，用于获取第31位到第i位的数
            Set<Integer> set = new HashSet<>();
            // 判断当前数中是否有该位为1的数
            for (int num : nums) 
                set.add(num & mask);
            int tmp = max | (1 << i); // 修改当前最大值的第i位；
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}