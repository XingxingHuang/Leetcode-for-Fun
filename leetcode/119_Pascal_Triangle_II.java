// 2017.08.27 Xingxing Huang
// 0th row > []
// 1th row > [1]
// ...
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i - 1; j > 0; j--) { // length in level i - 1 is i + 1.
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}
// Attention: ArrayList.add()  time complexity is O(n);
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> res = new ArrayList<Integer>();
//         for (int i = 0; i < rowIndex + 1; i++) {
//             for (int j = 0; j < i - 1; j++) { // length in level i - 1 is i + 1.
//                 res.set(j, res.get(j) + res.get(j + 1));
//             }
//             res.add(0, 1);
//         }
//         return res;
//     }
// }


// python
class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        res = [1]
        for _ in range(rowIndex):
            res = [x + y for x, y in zip([0] + res, res + [0])]
        return res