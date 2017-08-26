//아래코드는 Vertex가 1부터 시작될때이다.
//0부터인 경우에는 j=1;j<=V,[N+1]을 j=0;j<V,[N]로 바꾸면 되겠다.
import java.util.*;
  
public class DFS_BFS {
      
    static int[][] graph;	//2D matrix
    static boolean visited[];
    static int V;	//Vertex
    static int E;	//Edge
    static int startPoint;

    public static void dfs(int i){
        visited[i] = true;
        System.out.print(i+" ");
          
        for(int j=1; j<=V; j++){
            if(graph[i][j]==1&& visited[j]==false){
                //Recursion is the main Idea
				dfs(j);
            }
        }
    }
    public static void bfs(int i){
		//Queue class has
		//1.offer() : add V to rear	(== add())
		//2.poll() : get V of front & delete V (== remove())
		//3.peek() : just get V of front (== element())
			//*add(), remove(), element() can have error
			// because they return Exception when there is a size limit
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(i);
        visited[i] = true;
        System.out.print(i+" ");
          
        int temp;
		//isEmpty()
        while(!q.isEmpty()){
            temp = q.poll();
            for(int j=1; j<=V; j++){
                if(graph[temp][j]==1&&visited[j]==false){
                    q.offer(j);
                    visited[j]=true;
                    System.out.print(j+" ");
                }
            }                       
        }
    }  
    public static void main(String[] args) {
                  
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        graph = new int[V+1][V+1];
        E = sc.nextInt();
        visited = new boolean[V+1];
        startPoint = sc.nextInt();
          
        int a,b;
          
        for(int i=0; i<E; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            //when two vertex(a,b) get connected, thay are Edge(==1);  
            graph[a][b] = graph[b][a] = 1;
        }
          
        dfs(startPoint);
        //initialize 
        for(int j=1; j<=V; j++){
            visited[j]=false;
        }
        System.out.println();
          
        bfs(startPoint);
    }
}
