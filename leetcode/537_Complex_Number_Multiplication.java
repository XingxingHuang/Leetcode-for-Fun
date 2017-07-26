// @Author: Xingxing Huang
// 题目中的负数形式要求比较严格。不包含一些特殊情况，例如"i", "0"等。
// 直接根据字符串的分割得到复数，然后相乘后转化成字符串即可。
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        // 得到数字
        int[] num1 = convert(a);
        int[] num2 = convert(b);
        // 拼接得到结果
        StringBuilder sb = new StringBuilder("");
        sb.append(Integer.toString(num1[0] * num2[0] - num1[1] * num2[1]));
        sb.append('+');
        sb.append(Integer.toString(num1[0] * num2[1] + num1[1] * num2[0]));
        sb.append('i');
        return sb.toString();
    }
    public int[] convert(String a) {
        int n = a.length();
        int n1 = 0;
        for (int i = 1; i < n; i++) {
            if (a.charAt(i) - '0' < 0) {
                n1 = i;
                break;
            }
        }
        return new int[]{Integer.parseInt(a.substring(0, n1)), Integer.parseInt(a.substring(n1 + 1, n - 1))};
    }
}



// 使用stream
public String complexNumberMultiply(String a, String b) {
    int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(), 
          coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
    return (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]) + "+" + (coefs1[0]*coefs2[1] + coefs1[1]*coefs2[0]) + "i";
}

// 类似的一种方法，见solution
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        
        return real + "+" + img + "i";
    }
    
    private int[] getValue(String s) {
        String[] str = s.split("\\+");
        int[] val = new int[2];
        val[0] = Integer.valueOf(str[0]);
        int indexOfI = str[1].indexOf("i");
        val[1] = Integer.valueOf(str[1].substring(0, indexOfI));
        
        return val;
    }
}