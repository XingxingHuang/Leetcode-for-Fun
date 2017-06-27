// 正方形需要四个角度为90度，可以通过向量乘积判断。
// 先确定哪三个顶点组成的是一个直角，然后加入另外一个顶点，判断他们的角度关系。
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] line1 = new int[] {p1[1] - p2[1], p1[0] - p2[0]};
        int[] line2 = new int[] {p1[1] - p3[1], p1[0] - p3[0]};
        int[] line3 = new int[] {p1[1] - p4[1], p1[0] - p4[0]};
        if (len2(line1) == len2(line2)) {
            return check(p1, p2, p3, p4);
        } else if (len2(line1) == len2(line3)) {
            return check(p1, p2, p4, p3);
        } else if (len2(line2) == len2(line3)) {
            return check(p1, p3, p4, p2);
        }
        return false;
    }
    
    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] line1 = new int[] {p1[1] - p2[1], p1[0] - p2[0]};
        int[] line2 = new int[] {p1[1] - p3[1], p1[0] - p3[0]};
        int[] line3 = new int[] {p4[1] - p2[1], p4[0] - p2[0]};
        int[] line4 = new int[] {p4[1] - p3[1], p4[0] - p3[0]};
        if (len2(line1) != len2(line2) || 
                len2(line1) != len2(line3) || 
                len2(line1) != len2(line4) || 
                len2(line1) == 0) {
            return false;
        }
        return dot(line1, line2) == 0 && dot(line3, line4) == 0; 
    }
    
    public int dot(int[] line1, int[] line2) {
        return line1[0] * line2[0] + line1[1] * line2[1];
    }
    
    public int len2(int[] line) {
        return dot(line, line); 
    }
}

// 一种方法，所有顶点组成的边长只有两个长度。
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(dot(p1, p2));
        set.add(dot(p1, p3));
        set.add(dot(p1, p4));
        set.add(dot(p2, p3));
        set.add(dot(p2, p4));
        set.add(dot(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }
    public int dot(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
    
}

// Solution 中的非hash表的方法
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] lengths = {length(p1, p2), length(p2, p3), length(p3, p4),
                length(p4, p1), length(p1, p3),length(p2, p4)}; // all 6 sides
    
        long max = 0, nonMax = 0;
        for(long len : lengths) {
            max = Math.max(max, len);
        }
        int count = 0;
        for(int i = 0; i < lengths.length; i++) {
            if(lengths[i] == max) count++;
            else nonMax = lengths[i]; // non diagonal side.
        }
        if(count != 2) return false; // diagonals lenghts have to be same.
    
        for(long len : lengths) {
            if(len != max && len != nonMax) return false; // sides have to be same length
        }
        return true;
    }
    private long length(int[] p1, int[] p2) {
        return (long)Math.pow(p1[0]-p2[0],2) + (long)Math.pow(p1[1]-p2[1], 2);
    }
}