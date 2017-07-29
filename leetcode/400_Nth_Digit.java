// 这道题的关键就是要找出第N位所在的数字，然后可以把数字转为字符串，这样直接可以访问任何一位。那么我们首先来分析自然数序列和其位数的关系、
// 前九个数都是1位的，然后10到99总共90个数字都是两位的，100到999这900个数都是三位的，那么这就很有规律了，我们可以定义个变量cnt，初始化为9，然后每次循环扩大10倍，再用一个变量len记录当前循环区间数字的位数，另外再需要一个变量start用来记录当前循环区间的第一个数字，我们n每次循环都减去len*cnt (区间总位数)，
// 当n落到某一个确定的区间里了，比如在区间1000-1999，那么下面每个数字都是百位，十位，个位这么循环。那么(n-1) / len  就是目标数字在该区间里的坐标，加上start就是得到了目标数字，然后我们将目标数字start转为字符串，(n-1)%len就是所要求的目标位，
// 最后别忘了考虑int溢出问题. (right) n -= len * count; (wrong) n = n - len * count;



public class Solution {
//  public int findNthDigit(int n) {
//      int len = 1;
//      long count = 9;
//      int start = 1;

//      while (n > len * count) {
//          n -= len * count;
//          len += 1;
//          count *= 10;
//          start *= 10;
//      }
//      System.out.println(n);
//      System.out.println(len);
//      System.out.println(count);
//
//      start += (n - 1) / len;
//      String s = Integer.toString(start);
//      return Character.getNumericValue(s.charAt((n - 1) % len));
//  }
    public int findNthDigit(int n) {
        // the number of char between 
        // 1-9: 1*9
        // 10-99: 2*90
        // 100-999: 3*900
        long count = 9;  // 9, 90, 900, ...
        int level = 1;  // 1, 2, 3, ...
        while (n  > level * count) {
            // n = n - level * count; // fail 
            n -= level * count;
            count = 10 * count;
            level++;
        }
        System.out.println(n);
        System.out.println(level);

        // the results number should start with ?00...0, (level - 1) numbers of 0. 
        // the results number should be ?00..0 + (n - 1) / level.  n should minus because there is a 100 like element.
        // the results should at (n - 1) % level postion.
        int start =  (int) Math.pow(10, level - 1) + (n - 1) / level;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % level));
    }
}