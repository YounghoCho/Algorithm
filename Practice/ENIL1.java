//지금까지 받은 점수의 평균이 9.5점이 넘어야 한다. 
//지금 까지 받은 점수의 횟수를 n 이라 하고, 앞으로 매분기 10점씩 받는다고 할때. 
//평균이 9.5이상이 되기 위해서 필요한 최수 분기 수를 구해라.

//ex) 입력이
//2
//8 9
//면, 결과는 4

import java.util.*;

class Main{
	static void result(int arr[]){
		double sum=0;
		int count=0;

		for(int i=0; i<arr.length; i++){
			sum+=arr[i];
		}
		//System.out.println(sum/(arr.length+count));
		while(sum/(arr.length+count)<9.5){
			sum+=10;
			count++;
		//	System.out.println("sum:"+sum+"count:"+count+"result:"+sum/(arr.length+count));
		}
		System.out.println(count);
	}
	public static void main(String []args){
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		int temp[]=new int[n];
		for(int i=0; i<n; i++)
			temp[i]=scan.nextInt();
		result(temp);
	}
}
