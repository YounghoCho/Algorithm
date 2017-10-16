//이사를 하는데 팀원이 N명이고 자리가 N개다.
//각 사람마다 선호하는 자리가 있다. 
//모두가 원하는 자리에 앉을 수 있는지 구하는 프로그램을 작성하시오. 
//T:테스트케이스 K:누가 어떤자리를 원하는지 

//입력  //입력
2(T)    1
3(N)    5 
5(K)    10
0 1     3 3
0 2     4 1
1 0     4 0
1 2     0 1
2 0     2 4
2       0 2
2       0 0
0 0     3 0
1 0     1 1
//출력  0 4
O      //출력
X      O

import java.util.Scanner;

class Main {
    private int[][] graph;
    private int N;
    static boolean flag=false;
    /*
     * Description : DFS인데 출발점이 모든점이어야 하고, 모든 정점에 방문하면 O 아니면 X를 출력한다. 단 출발점은 제외시켜야함.
     * Time complexity : O(N^2)
     * Space complexity :
     */
     
    private boolean solve(int [][]graph, boolean[] visited, boolean flag) {
      // TODO implement your code to here.
	  	for(int i=0; i<visited.length; i++)
			  flag=DFS(graph, visited, flag, i, true); //true는 시작점을 보내서 시작점은 안찍게함
	/*	for(int i=0; i<visited.length; i++)
			  System.out.print(visited[i]+" ");
		  System.out.println();
			System.out.println(flag);
	*/
		return flag;
	 }
   
	static boolean DFS(int graph[][], boolean visited[], boolean flag, int start, boolean first){
		int count=0;
		if(!first) visited[start] = true; // 시작시점이 아닐 때만 방문행렬 수정

		for(int i=0; i<visited.length; i++)
			if(visited[i]==false && graph[start][i]==1)
				DFS(graph, visited, flag, i, false);

    //모든점을 방문했는지 검사
		for(int j=0; j<visited.length; j++)
			if(visited[j]==true)
				count++;
		if(count==visited.length)
			flag=true;
		
    //여기서 리턴 안해주면, static 변수라고 해도 flag 값이 변하지 않음.
		return flag;
	}
		
    public static void main(String[] args) throws Exception {
	  	//private는 객체를 생성해준다.
      Main main = new Main();
      Scanner scan = new Scanner(System.in);
      int T = scan.nextInt();
      //결과를 한번에 출력하기 위해 배열 선언
			boolean result[]=new boolean[T];

      for (int t = 0; t < T; t++) {
        int N = scan.nextInt();
        main.N = N;
        main.graph = new int[N][N];
        
        int K = scan.nextInt();
        for (int i = 0; i < K; i++) {
            int P = scan.nextInt();
            int S = scan.nextInt();
            main.graph[P][S] = 1;
        }
        boolean[] visited = new boolean[N];
        result[t]=main.solve(main.graph, visited, main.flag);
      }
			for(int i=0; i<T; i++)
				System.out.println(result[i]?'O':'X');   
    }
}
