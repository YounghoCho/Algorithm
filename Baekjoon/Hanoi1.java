//세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로  옮기려 한다.

//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.(중간 과정 역시 그래야함)
////이 작업을 수행하는데 필요한 이동순서를 출력하는 프로그램을 작성하라

//입력
//3

//출력
//1 3
//1 2
//3 2
//1 3
//2 1
//2 3
//1 3
//7     //만약 count가 먼저 나와야된다고 하면, 프린트문 다 지우고 먼저 돌린다음 count를 구하고 hanoi_print를 만들어서 출력한다. 

import java.util.*;

class Main
{
	int count=0;
	//비밀이 있는데 원판이 n개면 총 이동 횟수는 (n-1번째의 이동횟수)*2+1이다.
	//n:1->1, n:2->3, n:3->7, n:4->15, n:5->31이다. 

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int n= scan.nextInt();
		Main m= new Main();
		
		System.out.println(m.hanoi(1,2,3, n));
		
		
	}
	
	public int hanoi(int first, int mid, int last, int n){
		if(n==1){
			count++;
			//2. 기본동작(first->last) //1을 1->2
			System.out.println(first+ " "+ last);
		}else{
			//1.처음에서 중간으로 보낸다.
			hanoi(first, last, mid, n-1);
			count++;
			//3. 기본동작 (위에서 중간으로 보냈고, 이번에는 마지막으로 보낸다)
			System.out.println(first+ " "+ last); //2를 1->3
			//4.중간에서 마지막으로 보낸다.
			hanoi(mid, first, last, n-1); //1을 1->3
		}
		return count;
	}
}
