public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int out = 0;
        for (int i = 0; i < 32; i++) {
         out <<= 1;
         out += n & 1; // add to out 
         n >>>= 1; // unsign shift
        }    
        return out;    
    }
}