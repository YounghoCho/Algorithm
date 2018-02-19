/*매일프로그래밍

정수 배열이 주어지면 가장 긴 커지는 원소들의 집합의 길이를 구하시오.
예1) 10, 9, 0, 7, 2, 5
결1) 3 //0,2,5
예2) 0 8 12 2 6 14 9 5 13 3 11 7 15
결2) 6 //0,2,6,9,11,15
*/
import java.util.*;

class Main{
	static boolean visited[];
	static int N;
	static int max=0;

	static void DFS(int arr[], int start){
		if(visited[start]==false) 
			visited[start]=true;
	//	for(int i=1; i<N; i++){ //3번째점인데 N을 더하면 범위초과
		for(int i=1; i<N-start; i++){
			if(visited[start+i]==false && arr[start]<arr[start+i]){
				DFS(arr, start+i);
			}
		}
/*test code
		System.out.print(arr[start]+"|");
		print_visited();
		System.out.println("|"+now);
*/
		//전체 visit을 초기화하면 안되고, start점을 제외한 다음 점들의 visit을 false로 되돌린다.
		init_visited(start);
		//now++를 하지않고, true의 개수를 세는것이 편하다.
		max= max<count_true()? count_true(): max;
	}
	
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		N= scan.nextInt();
		int arr[]=new int[N];
		visited=new boolean[N];

		//input
		for(int i=0; i<N; i++)
			arr[i]= scan.nextInt();
		scan.close();
		//DFS(각 점에서 출발한다)
		for(int i=0; i<N; i++){
			DFS(arr, i);
		}
		//result
		System.out.println(max);
		
//		print_visited();
	}
	
	static void init_visited(int start){
		for(int i=start; i<N; i++)
			visited[i]=false;	
	}
	static void print_visited(){
		for(int i=0; i<N; i++)
			System.out.print(visited[i]+" ");
		System.out.println();
	}
	static int count_true(){
		int count=1;
		for(int i=0; i<N; i++)
			if(visited[i]==true)
				count++;
//		System.out.println("count:"+count);
		return count;
	}
}
