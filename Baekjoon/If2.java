//입력
//첫째 줄에는 테스트케이스 C가 주어진다.
//둘째 줄부터 각 테스트케이스 마다 첫 수로 정수 N(1 <= N <= 1000)명의 학생이 주어지고 그 다음으로 N명의 0부터 100 사이의 점수가 이어서 주어진다.

//출력
//각 케이스마다 한줄씩 평균을 넘는 학생들의 비율을 소수점 넷째자리에서 반올림하여 출력한다.

//예제 입력
//5
//5 50 50 70 80 100
//7 100 95 90 80 70 60 50

//예제 출력
//40.000%
//57.143%

import java.util.*;

class If2
{
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);

		int n=scan.nextInt();
		double result=0;

		for (int i=0; i<n; i++){
			int count=0;
			int sum=0;
			int n2=scan.nextInt();
			int arr[]=new int[n2]; //이것땜에 에러가 많네..필요한곳에 선언하자.
			
			for(int j=0; j<n2; j++){
				arr[j]=scan.nextInt();
				sum+=arr[j];
			}
			result=(double)sum/n2;
			
			for (int j=0; j<n2; j++){
				if(arr[j]>result)
					count++;
			}
			result=(double)count/n2*100;
			System.out.printf("%.3f",result);
			System.out.println("%");
		}
			
						
	}
}
