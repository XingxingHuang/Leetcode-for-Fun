package graphs;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
 
class Neighbor {
    public int vertexNum;
    public Neighbor next;
    public Neighbor(int vnum, Neighbor nbr) {
            this.vertexNum = vnum;
            next = nbr;
    }
}
 
class Vertex {
    String name;
    Neighbor adjList;
    Vertex(String name, Neighbor neighbors) {
            this.name = name;
            this.adjList = neighbors;
    }
}
 
/**
 * @author Sesh Venugopal
 * https://www.youtube.com/watch?v=n_yl2a6n7nM
 */
public class Graph {
 
    Vertex[] adjLists;
     
    boolean undirected=true;
     
    public Graph(String file) throws FileNotFoundException {
         
        Scanner sc = new Scanner(new File(file));
         
        String graphType = sc.next();
        if (graphType.equals("directed")) {
            undirected=false;
        }
         
        adjLists = new Vertex[sc.nextInt()];
 
        // read vertices
        for (int v=0; v < adjLists.length; v++) {
            adjLists[v] = new Vertex(sc.next(), null);
        }
 
        // read edges
        while (sc.hasNext()) {
             
            // read vertex names and translate to vertex numbers
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());
             
            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
            if (undirected) {
                adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
            }
        }
    }
         
    int indexForName(String name) {
        for (int v=0; v < adjLists.length; v++) {
            if (adjLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }   
     
    public void print() {
        System.out.println();
        for (int v=0; v < adjLists.length; v++) {
            System.out.print(adjLists[v].name);
            for (Neighbor nbr=adjLists[v].adjList; nbr != null;nbr=nbr.next) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name);
            }
            System.out.println("\n");
        }
    }
     
    // public method called by application
    public int[] dfsTopsort() {
         boolean[] visited = new boolean[adjLists.length];
         int[] topnum = new int[adjLists.length];
         int n = adjLists.length-1;
         for (int v=0; v < visited.length; v++) {
             if (!visited[v]) {
                 n = dfsTopsort(v, visited, topnum, n);
             }
         }
         return topnum;
     }
     
    // recursive dfs based topsort
    // topnum[n]=v => vertex v's topological number is n
    // n is the current largest topological number that can be dealt out
    private int dfsTopsort(int v, boolean[] visited, int[] topnum, int n) {
        visited[v] = true;
        for (Neighbor nbr=adjLists[v].adjList; nbr != null; nbr=nbr.next) {
            if (!visited[nbr.vertexNum]) {
                n = dfsTopsort(nbr.vertexNum, visited, topnum, n);
            }
        }
        // about to back up to previous vertex
        topnum[n] = v;  // assign top num
        return n-1;  // return to caller
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) 
    throws IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        Graph graph = new Graph(file);
        graph.print();
         
        System.out.println("Toplogical sequence: ");
        int[] topnum = graph.dfsTopsort();
        System.out.print(graph.adjLists[topnum[0]].name);
        for (int i=1; i < topnum.length; i++) {
            System.out.print(", " + graph.adjLists[topnum[i]].name);
        }
        System.out.println();
        sc.close();
    }
}