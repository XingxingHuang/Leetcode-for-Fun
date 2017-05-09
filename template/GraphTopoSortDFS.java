// youtube: https://www.youtube.com/watch?v=n_yl2a6n7nM
private void dfs (int v, boolean[] visited) {
    visited[v] = true;
    for (Neighbor nbr = adjLists[v].adjList;
            nbr != null;
            nbr = nbr.next) {
        if (!visited[nbr.vertexNum]) {
            dfs(nbr.vertexNum, visited);
        }
    }
}

private void dfs (int v, boolean[] visited) {
    visited[v] = true;
    for (Neighbor nbr = adjLists[v].adjList;
            nbr != null;
            nbr = nbr.next) {
        if (!visited[nbr.vertexNum]) {
            dfs(nbr.vertexNum, visited);
        }
    }
    topnum[v] = n; // assign top num
    n--; // decrement, ready for next vertex
}

private int dfsTopSort (int v, boolean[] visited,
                         int[] topnum, int n) {
    visited[v] = true;
    for (Neighbor nbr = adjLists[v].adjList;
            nbr != null;
            nbr = nbr.next) {
        if (!visited[nbr.vertexNum]) {
            n = dfs(nbr.vertexNum, visited, topnum, n);
        }
    }
    topnum[v] = n; // assign top num
    return n-1; // return to caller
}

public int[] dfsTopSort() {
    boolean[] visited = 
            new boolean[adjLists.length];
    int[] topnum = new int[adjLists.length];
    int n = adjLists.length - 1; // largest top num
    for (int v = 0; v < visited.length; v++) {
        if (!visited[v]) {
            n = dfsTopSort(v, visited, topnum, n);
        }
    }
    return topnum;
}