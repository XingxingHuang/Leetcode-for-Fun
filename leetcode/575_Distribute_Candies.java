// 10.10
// using set
public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet < Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}

// using sort
public class Solution {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
}


// solutions in the leetcode
// https://leetcode.com/problems/distribute-candies/solution/