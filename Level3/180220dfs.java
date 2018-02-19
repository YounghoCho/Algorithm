/* 코드그라운드

김씨만 행복한 세상
김씨는 영토가 있는데 , A, B 가문 사람들을 관리자로 삼는다. 근데 인접영토를 같은 가문에서 관리할수는 없다. 
테스트케이스 T, 지역개수N(<=200), 인접지역 수M(<=1000), M번만큼 두 지역의 번호 a,b가 입력된다. 
이때 인접한 두지역에 같은 가문의 사람을 배정하지 않고 관리가 가능하면 1 아니면 0을 출력하라.

입력  출력
2     Case #1
5     1
4     Case #2
1 2   0
2 3
2 4
4 5
5
5
1 2
2 3
2 4
2 5
4 5
*/

import java.util.*;

class Main{
	static int N;//지역수<=200
	static int M;//인접지역수<=1000
	static boolean ad[][];//인접여부
	static boolean visited[];
	static int flag=1;

	/////조건, 완전그래프면 안된다.
	static void DFS(int start){
		if(visited[start]==false) visited[start]=true;
		//2. 인접점이 이미 방문한 점이면 완전그래프
		else if(visited[start]==true){
			flag=0;
		    return; //return이 없으면 재귀가 끝나지 않으므로 에러가 발생합니다.
		            //Exception in thread "main" java.lang.StackOverflowError
		}
		for(int i=1; i<N+1; i++){
			//1. 인접하면 계속 가
			if(ad[start][i]==true){
				DFS(i);
			}
		}
	}
	
	////관리여부 1,0 출력
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		int test= scan.nextInt();

		//input
		for(int i=0; i<test; i++){
			N= scan.nextInt();
			M= scan.nextInt();
			ad=new boolean[N+1][N+1];
			visited=new boolean[N+1];
			for(int j=0; j<M; j++){
				int x= scan.nextInt();
				int y= scan.nextInt();
				ad[x][y]=true;
			}
			//logic
			DFS(1);
			System.out.println("Case #"+(i+1));
			System.out.println(flag);
			flag=1;
			print_ad();
		}
		scan.close();
	}
	//ad print
	static void print_ad(){
		for(int i=0; i<N+1; i++){
			for(int j=0; j<N+1; j++)
				System.out.print(ad[i][j]+" ");
			System.out.println();
		}
	}
}

///// best case/////
/*
for (test_case = 1; test_case <= TC; test_case++) {
        result = 1;
        scanf("%d %d", &N, &M);
		//모든 지역의 관리자를 0으로 초기화한다.
        for (i = 0; i < 201; i++) {
            num[i] = 0;
        }
		//0=!1 이고 1=!0이라는 계산을 사용한다.
		//예를들어, 1과2, 2와3이 인접하게 되면
		//기본적으로 1,2,3은 0번일 것이고
		//1과2가 인접했을때, 2는 1의 역수값(!0)으로 1이된다.
		//자연스럽게 2와3이 인접할때, 3은 2의 역수값(!1)으로 0이된다.
        for (i = 0; i < M; i++) {
            scanf("%d %d", &start[i],&end[i]);
            num[end[i]] = !num[start[i]];
        }
		//인접점이 같으면 안된다.
		for (i = 0; i < M; i++) {
            if (num[start[i]] == num[end[i]]) {
                result = 0;
                break;
            }
        }
        printf("Case #%d\n", test_case);
        printf("%d\n", result);
 
    }
*/
