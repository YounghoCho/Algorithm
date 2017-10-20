//오늘부터 N+1일째 되는날 퇴사를 한다
//하루에 하나씩 서로 다른 사람의 상담을 하고
//각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
//N = 7인 경우에 다음과 같은 상담 일정표를 보자.
//  	1일	2일	3일	4일	5일	6일	7일
//Ti	3	   5	  1	  1	   2	  4	   2
//Pi	10	 20	  10	20	 15	  40	 200

//1일에 잡혀있는 상담은 총 3일이 걸리며, 상담했을 때 받을 수 있는 금액은 10이다. 
//5일에 잡혀있는 상담은 총 2일이 걸리며, 받을 수 있는 금액은 15이다.

//상담을 하는데 필요한 기간은 1일보다 클 수 있기 때문에, 모든 상담을 할 수는 없다. 
//예를 들어서 1일에 상담을 하게 되면, 2일, 3일에 있는 상담은 할 수 없게 된다. 
//2일에 있는 상담을 하게 되면, 3, 4, 5, 6일에 잡혀있는 상담은 할 수 없다.
//또한, N+1일 째에는 회사에 없기 때문에, 6, 7일에 있는 상담을 할 수 없다.

//퇴사 전에 할 수 있는 상담의 최대 이익은 1일, 4일, 5일에 있는 상담을 하는 것이며, 이 때의 이익은 10+20+15=45이다.
//상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
//첫째 줄에 N (1 ≤ N ≤ 15)이 주어진다.
//둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)
//출력의 첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.

//입력                                                 //출력
//7                                                      45
//3 10 5 20 1 10 1 20 2 15 4 40 2 200  

//10                                                     55
//1 1 1 2 1 3 1 4 1 5 1 6 1 7 1 8 1 9 1 10  

//10                                                     90
//5 50 4 40 3 30 2 20 1 10 1 10 2 20 3 30 4 40 5 50 

import java.util.*;

class Main
{
	static int max=0;

	public static void main(String[] args) 
	{
		Scanner scan= new Scanner(System.in);
		int N=scan.nextInt();
		int T[]=new int[N];
		int P[]=new int[N];
		for(int i=0; i<N; i++){
			T[i]=scan.nextInt();
			P[i]=scan.nextInt();
		}
	//	print(T);
	//	print(P);
		int sum=0;
		for(int i=0; i<N; i++){
			func(T, P, i, sum);
			sum=0;
//1			System.out.println("---------");
		}
		System.out.println(max);
	}

	static void func(int T[], int P[], int index, int sum){

		//예외1, 마지막 작업의 길이가 배열의 크기를 넘어갈때.
		if(index+T[index]>T.length){
		//	max= max<sum? sum: max;
			return;
		}
		//방문
		sum+=P[index];
		max= max<sum? sum: max;
//2		System.out.println(sum);

		//예외2, 다음 인덱스가 배열의 크기를 넘어갈때.
		//next가 마지막 원소일때 T배열의 길이보다 1이 작은것을 명심하자. 배열은 0번지부터 시작하니까.
		int next= index + T[index];
		if(next>=T.length){//not next > T.length
		//	max= max<sum? sum: max;
			return; //not break;
		}

		//예외3, 백트래킹이 가능한 구조. 바로 정해진 인덱스로 가는게 아니라 능동적으로 한칸씩 더 갈 수있음. 최고의 덧셈 결과를 얻어야하므로.
		for(int i=next; i<T.length; i++){
			func(T, P, i, sum);
		}
	}

	static void print(int arr[]){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
