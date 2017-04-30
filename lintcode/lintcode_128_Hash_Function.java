/**
 * 注意溢出的情况
 * @author  Xingxing Huang  
 * @since   2017.04.30
 * @Time    O(n),   
 * @param   
 * @return  
 */
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    // public int hashCode(char[] key, int HASH_SIZE) {
    //     long hash = 0;
    //     for (int i = 0; i < key.length; i++) {
    //         hash = (hash * 33 + (int) key[i]) % HASH_SIZE;
    //     }
    //     return (int) hash;
    // } 
    
    
    // 溢出了！！！！！ 需要采用长整型
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long hash = 0;
        long count = 1;
        for (int i = key.length - 1; i >= 0; i--) {
            hash = (hash % HASH_SIZE + count * (int) key[i]) % HASH_SIZE;
            //hash += count * (key[i] - ' ' + 32);
            count = (count * 33)  % HASH_SIZE;
        }
        return (int) hash;
    }
};


// class Solution {
//     public int hashCode(char[] key,int HASH_SIZE) {
//         long ans = 0;
//         for(int i = 0; i < key.length;i++) {
//             ans = (ans * 33 + (int)(key[i])) % HASH_SIZE; 
//         }
//  return (int)ans;
//     }
// };