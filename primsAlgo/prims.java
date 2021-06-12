import java.util.Scanner;

class prims{
    static int getMinVertex(int key[],Boolean visited[]){
        int min = Integer.MAX_VALUE;
        int min_vertex = -1;
        
        for(int i = 0; i < key.length; i++){
            if(visited[i] == false && key[i] < min){
                min = key[i];
                min_vertex = i;
            }
        }
        return min_vertex;
    }
    static int[] primsMST(int graph[][], int vertices){
        int parent[] = new int[vertices];   //saving parent vertices for the current vertex
        int keys[] = new int[vertices];     //distance from root vertex to present vertex
        Boolean visited[] = new Boolean[vertices];   //keeping track of visited and non-visited vertices
        
        for(int i = 0; i < vertices; i++){
            keys[i] = Integer.MAX_VALUE;   // initialize all keys to infinity;
            visited[i] = false;
        }
        keys[0] = 0;   // root vertex = 0 as it is the first or starting vertex
        parent[0] = -1;  // not parent for root vertex
        
        for(int count = 0; count < vertices - 1; count++){
           int u = getMinVertex(keys, visited);  // getting the minimum vertex after relaxing the neigbhour vertices
           
           visited[u] = true;  // mark current vertex as visited
           
           for(int v = 0; v < vertices; v++){
              if(graph[u][v] != 0 && visited[v] == false && graph[u][v] < keys[v]){
                  keys[v] = graph[u][v];     // change vertex from infinity to the weight of the edge between u and v
                  parent[v] = u;    // set parent of vertex as u
              }
           }
        }
        return parent;
    }
public static void main(String args[]){
    int vertices;

    System.out.print("Enter number of vertices:");
    Scanner scr = new Scanner(System.in);
    vertices = scr.nextInt();

    System.out.println();
    System.out.println("Enter the weights for the vertices. Enter 0 if no connection exists between them");

    int graph[][] = new int[vertices][vertices];

    for(int i = 0; i < vertices; i++){
        System.out.println("Enter vertices connecting " + i + " vertex");
        for(int j = 0; j < vertices; j++){
            graph[i][j] = scr.nextInt();
        }
    }
    System.out.println("The graphs look like this..........");
    for(int i = 0; i < vertices; i++){
        for(int j = 0; j < vertices; j++){
            System.out.print(graph[i][j] + " ");
        }
        System.out.println();
    }
    
    int[] parent = primsMST(graph, vertices);
    
    System.out.println("MST for the above graph using prims algo.");
    System.out.println("Edge \tWeight");
    for (int i = 1; i < vertices; i++){
        System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
    }
}
