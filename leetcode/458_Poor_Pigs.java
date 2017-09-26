class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int status = minutesToTest/minutesToDie + 1;
        int num_of_pig = 0;
        while(Math.pow(status, num_of_pig) < buckets) {num_of_pig++;}
        return num_of_pig;
    }
}

// 09.24
// buckets: number of buckets
// minutesToDie: time for each test
// minutesToTest: total time.
// Then,  we can only test limited round, n = minutesToTest / minutesToDie. 
//In general, we can solve up to (⌊minutesToTest / minutesToDie⌋ + 1)^pigs buckets 

//// This is WRONG !!!!
// 1st round we can use m pig to test m + 1 groups of buckets, we left 1 group with poison and m - 1 pigs.
// 2st round, m - 1 pigs to test m groups, and left m - 2 pigs.
// ...
// last round, 1 pig  to test 2 bucket, got the poison one.
// We can think in reversed order. Then total bucket we can check is

