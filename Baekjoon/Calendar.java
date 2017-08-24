//문제
//오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.

//입력
//첫째 줄에 빈 칸을 사이에 두고 x(1≤x≤12)와 y(1≤y≤31)이 주어진다. 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.

//출력
//첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.

import java.util.*;

class Calendar
{
		public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
	  int m=scan.nextInt();
	  int d=scan.nextInt();
		int total=0;
		int result=0;
    
    //중요! 입력된 해당 월의 총날짜수는 합치면 안되기 때문에 <=대신 <로 한번 덜 돌도록 제한.
		for(int i=1; i<m; i++){
			switch(i){
				case 1:case 3:case 5:case 7:case 8:case 10:case 12:
					total=31;
					break;
				case 4:case 6:case 9:case 11:
					total=30;
					break;
				case 2:
					total=28;
					break;
			}
      //add months
			result+=total;
		}
    //add days
		result+=d;

		switch(result%7){
			case 1:
				System.out.print("MON");break;
			case 2:
				System.out.print("TUE");break;
			case 3:
				System.out.print("WED");break;
			case 4:
				System.out.print("THU");break;
			case 5:
				System.out.print("FRI");break;
			case 6:
				System.out.print("SAT");break;
			case 0:
				System.out.print("SUN");break;
		}

	}
}
