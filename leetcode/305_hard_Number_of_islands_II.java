// A 2d grid map of m rows and n columns is initially filled with water. 
// We may perform an addLand operation which turns the water at position (row, col) into a land. 
// Given a list of positions to operate, count the number of islands after each addLand operation. 
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.




// use Union Find instead.

public List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[] rootArray = new int[m*n];
    Arrays.fill(rootArray,-1);
 
    ArrayList<Integer> result = new ArrayList<Integer>();
 
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    int count=0;
 
    for(int k=0; k<positions.length; k++){
        count++;
 
        int[] p = positions[k];
        int index = p[0]*n+p[1];
        rootArray[index]=index;//set root to be itself for each node
 
        for(int r=0;r<4;r++){
            int i=p[0]+directions[r][0];
            int j=p[1]+directions[r][1];
 
            if(i>=0&&j>=0&&i<m&&j<n&&rootArray[i*n+j]!=-1){
                //get neighbor's root
                int thisRoot = getRoot(rootArray, i*n+j);
                if(thisRoot!=index){
                    rootArray[thisRoot]=index;//set previous root's root
                    count--;
                }
            }
        }
 
        result.add(count);
    }
 
    return result;
}
 
public int getRoot(int[] arr, int i){
    while(i!=arr[i]){
        i=arr[i];
    }
    return i;
}