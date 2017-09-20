// use array to store the information 
class Solution {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) 
            return 0;
        int[][] dp = new int[4][8];
        for (int n : nums) {
            int level = n / 100 - 1;
            int index = (n % 100) / 10 - 1;
            dp[level][index] = 1;
            if (level > 0) {
                dp[level - 1][index / 2] = 0;
            }
        }
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 8; j++) {
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println('\n');
        // }
        int sum = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                if (dp[i][j] == 0) 
                    continue;
                int m = i;
                int n = j;
                while (m >= 1) {
                    m--;
                    n /= 2;
                    dp[m][n]++;
                }
            }
        }
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 8; j++) {
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println('\n');
        // }
        for (int n : nums) {
            int level = n / 100 - 1;
            int index = (n % 100) / 10 - 1;   
            // System.out.println(n + " " + level + " " + index);
            sum += (n % 10) * dp[level][index];
        }
        return sum;
    }
}

// a simple way use array
class Solution {
    public int pathSum(int[] nums) {
        int[][] m = new int[5][8];
        for (int n : nums) {
            int i = n / 100; // i is 1 based index;
            int j = (n % 100) / 10 - 1; // j used 0 based index;
            int v = n % 10;
            m[i][j] = m[i - 1][j / 2] + v;
        }

        int sum = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || m[i][j] != 0 && m[i + 1][j * 2] == 0 && m[i + 1][j * 2 + 1] == 0){
                    sum += m[i][j];
                }
            }
        }
        return sum;        
    }
}

// hashmap
class Solution {
    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        
        traverse(nums[0] / 10, 0);
        
        return sum;
    }
    
    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        
        int curSum = preSum + tree.get(root);
        
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        
        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }
}

