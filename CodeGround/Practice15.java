//김씨만 행복한 세상
//김씨는 영토가 있는데 , A, B 가문 사람들을 관리자로 삼는다. 근데 인접영토가 같은 가문에서 관리할수는 없다. 
//테스트케이스 T, 지역개수N(<=200), 인접지역 수M(<=1000), M번만큼 두 지역의 번호 a,b가 입력된다. 
//이때 관리가 가능하면 1 아니면 0을 출력하라.

//입력  //출력
/2      Case #1
//5     1
//4     Case #2
//1 2   0
//2 3
//2 4
//4 5
//5
//5
//1 2
//2 3
//2 4
//2 5
//4 5

import java.util.Scanner;

class Solution {
	static int Answer;
	//사이클 형성 여부를 위해 스택과 flag를 만들었다.
    static int stack[]=new int[200];
    static int top=0;
    static boolean flag=false;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			/////////////////////////////////////////////////////////////////////////////////////////////
			int N= sc.nextInt();//정점
			int M= sc.nextInt();//간선
			int mat[][]=new int[N+1][N+1];//인접행렬 //정점 입력이 1부터 시작하므로 +1 해준다.
			boolean visited[]=new boolean[N];//방문행렬
			
            for(int i=0; i<M; i++){
                int x= sc.nextInt();
                int y= sc.nextInt();
                mat[x][y]=1;
            }
            DFS(0,true, mat, visited);
            Answer=(flag==true? 0: 1); //flag가 true면 0이다.
			/////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	static void DFS(int start, boolean first, int mat[][], boolean visited[]){
	    if(!first) visited[start]=true;
	    //사이클여부 체크
	    if(check(start)==false)
    	    stack[top++]=start; //사이클이 아니면 스택에 경로기록
    	else
    	    flag=true; //사이클이면 flag를 true로해서 0을 출력한다.
    	    
	    for(int i=0; i<visited.length; i++){
	        if(visited[i]==false && mat[start][i]==1)
	            DFS(i, false, mat, visited);
	    }
	}
	static boolean check(int start){
	    //스택을 top말고 0에서부터 검색하면 수행시간이 올라간다.
	    for(int i=0; i<top; i++){
	        if(stack[i]==start)
	            return true;
	    }
	    return false;
	}
}

//천재의풀이
for(int test_case = 0; test_case < T; test_case++) {
	int r= sc.nextInt();
	int nei= sc.nextInt();
	
	int x[]=new int[nei];
	int y[]=new int[nei];
	
	boolean check[]=new int[r+1];
	
	int result=1;
	Arrays.fill(check,false);
	for(int i=0; i<nei; i++){
		x[i]=sc.nextInt();
		y[i]=sc.nextInt();
		//crazy man
		//x를 방문하면 1이 되고, x의 인접점을 방문하게되면 인접점은 0이되서 ok
		//사실 잘 모르겠다.. 예제를 그림그려보면 기가막히게 되버림.
		check[y[i]]= !check[x[i]];
	}
	for(int i=0; i<nei; i++){
		//crazy 2
		
		if(check[x[i]]==check[y[i]]){
			result=0;
			break;
		}
	}
}
