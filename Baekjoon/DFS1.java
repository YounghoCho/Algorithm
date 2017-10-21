//11403
//가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

//첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. 
//i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.

//총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 
//정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.

//입력      //출력
//3         1 1 1
//0 1 0     1 1 1 
//0 0 1     1 1 1
//1 0 0

import java.util.*;

class Main 
{
	static int N;
	//int mat[][]; 이렇게 선언할 수 없다.

	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		N= scan.nextInt();
		int mat[][]=new int[N][N];
		int result[][]=new int[N][N];
	
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				mat[i][j]=scan.nextInt();		
		scan.close();

		//solve1, 정점이 N개이므로 N번 출발한다.
		//solve2, 출발점 마다 visited를 만들어준다.
		//solve3, DFS후 완성된 visited를 result에 차곡차곡 넣어준다.
		//solve4, 출발점은 방문하지 않도록 ture를 보낸다.
		for(int i=0; i<N; i++){
			int visited[]=new int[N];
			DFS(i, mat, visited,true);
			result[i]=visited;
		}
		print(result);
	}
	static void DFS(int i, int mat[][], int visited[], boolean first){
		if(!first) visited[i]=1;
		for(int c=0; c<N; c++){				
			if(visited[c]==0 && mat[i][c]==1){
				DFS(c, mat, visited, false);
			}
		}
	}

	static void print(int result[][]){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++)
				System.out.print(result[i][j]+" ");
			System.out.println();
		}
	}
}
