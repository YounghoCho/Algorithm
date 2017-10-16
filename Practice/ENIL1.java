//만약에 100m^2의 공간을 구매했다고 치자(n). 
//이때 n이 될 수 있는 두 수의 조합이 궁금하다. 
//각각 가로 세로가 될 수 있는 모든 경우의 수를 구해라. 
//시간제한 있음.

//for(i++){
// for(j--)
//}
//이렇게 짰는데, n=100000만 되도 엄청 부하가 걸린다. 하지만 아래처럼 하면 1.2초

import java.util.*;

class Main 
{
	static long start= System.currentTimeMillis();  //시작시간
  //간단하게 스택구현
  static int stack[];
	static int top=0;
  //약수구하기
	static void factor(int stack[], int n){
		for(int i=1; i<=n; i++)
			if(n%i==0){
				stack[top]=i;
				top++;
			}
	}
	static void print(int arr[]){
		for(int i=0; i<arr.length; i++) System.out.print(arr[i]+" ");
	}
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int n= scan.nextInt();
		int stack[]=new int[n];
    int count=0;
		factor(stack, n);
	//print(stack);

		for(int i=0; i<top; i++){
			for(int j=top-1; j>=0; j--){
				if(stack[i]*stack[j]==n)
					//System.out.println("find:"+stack[i]+" "+stack[j]);
          count++;
			}
		}
    System.out.println(count);
		long end= System.currentTimeMillis(); //프로그램 종료시간
	//System.out.println("실행시간:"+((end-start)/1000.0));
	}
}
