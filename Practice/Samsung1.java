*/
정사각형 4개를 이어 붙인 폴리오미노를 테트로미노라고 하며,
크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 
종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 써 있다.
테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
둘째 줄부터 N개의 줄에 종이에 써 있는 수가 주어진다. 
입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

입력       결과
5 5        19
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

입력                 결과
4 10                 7
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
*/

import java.util.*;

class Main 
{
	//최대 1000인 점 5개를 구하는 연산을 하기때문에.
	static int INF=5001;
	//위,오,아래,왼 순서
	static int cols[]={1,0,-1,0};
	static int rows[]={0,1,0,-1};
	//가로세로 N,M 최대 500
	static int visited[][]=new int[500][500];
	static int matrix[][]=new int[500][500];
	//DFS를 4번 돌려야한다.
	static int result=0,sum=0;
	static int N,M;
	static int limit=4;
	
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		N= scan.nextInt();
		M= scan.nextInt();
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				matrix[i][j]=scan.nextInt();
			}
		}
		//solve
		//각정점별로 이동하면서
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
			//깊이탐색 ㄱ,ㄴ 형태찾기(예제1,2)
			DFS(0,i,j,0);
			//DFS로 안되는 ㅗ,ㅓ,ㅏ,ㅜ 찾기(예제3)
			solve(i,j);
			}
		}
		System.out.println("결과: "+result);
	}
  
	static void DFS(int depth, int row, int col, int sum){
		//기본, 방문
		visited[row][col]=1;
		sum+=matrix[row][col];
		//print_visited();

		//4번 탐색하고 멈춰야함
		if(depth==limit-1){
			result= result<sum? sum: result;
			//마지막 방문을 취소해줘야, 이전 방문점에서 다시 시작할 수 있음★
			visited[row][col]=0;
			return;
		}

		//기본, for문
		for(int i=0; i<4; i++){
			//정점이동
			int x=row+rows[i];
			int y=col+cols[i];
			//기본, if문
			if(x<0 || x>=N || y<0 || y>=M) continue; //=넣어줘야해요★
			if(visited[x][y]==1) continue;//이게 먼저오면 x,y가 음수가 되서 예외발생함★
			DFS(depth+1,x,y,sum);			
		}
		//최초 방문점 방문 취소★
		visited[row][col]=0;
	}
  
	//DFS에서 i,j인 정점에 대해 조사를 했고 여기서 i,j에 대한 ㅗ,ㅜ,ㅏ,ㅓ를 탐색한다.
	static void solve(int row, int col){
		int count=0;
		int sum=matrix[row][col];
		int min=INF;
		//네방향을 더한다
		for(int i=0; i<limit; i++){
			int x=row+rows[i];
			int y=col+cols[i];
			if(x<0 || x>=N || y<0 || y>=M){
				count++;
				continue;
			}
			sum+=matrix[x][y];
			min= min>matrix[x][y]? matrix[x][y]: min;
		}
		//모서리인경우는 3개만 더한게 결과다
		if(count==1)
			result= result<sum? sum: result;
		//꼭지점인경우 무시
		else if(count==2)
			return;
		//둘다아닌경우 4개 점들중 최소값을 빼야 result가 최대가 된다.
		else{
			result= result<sum-min? sum-min: result;
		}
	}

	static void print_visited(){
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++)
				System.out.print(visited[i][j]+ " ");
			System.out.println();
		}
		System.out.println();
	}
  
}
