//숫자를 입력받아 이진수를 출력하고 그의 보수의 10진수를 구하시오.

import java.util.*;

class Main 
{
	public static void main(String[] args) 
	{
		//10진수입력
		Scanner scan=new Scanner(System.in);
		int n= Integer.parseInt(scan.nextLine());
		System.out.println("입력받은 수:"+n);
		
		//2진수변환
		int count=0;
		int arr[]=new int[32];
		for(int i=31;i>=0;i--){
			arr[i]=n%2;
			n/=2;
			count++;
			if(n==0){
				System.out.println("길이:"+count);
				break;
			}

		}
		System.out.print("2진수:");
		for(int i=32-count; i<32; i++)
			System.out.print(arr[i]);
		System.out.println();

		//1의보수
		int arr1[]=new int[32];
		for(int i=31;i>31-count;i--){
			if(arr[i]==1)
				arr[i]=0;
			else
				arr[i]=1;
			//bo1[J]=1-b[J]; 이렇게도 가능함.
		}
		System.out.print("1보수:");
		for(int i=32-count; i<32; i++)
			System.out.print(arr[i]);
		System.out.println();

		//10진수변환
		int b=1;
		int sum=0;
		for(int i=31; i>31-count; i--){
			sum+=arr[i]*b;
			b*=2;
		}
		System.out.println("10진수:"+sum);

	}
}
