//문제
//알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
//한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.

//입력
//첫째 줄에 단어가 주어진다. 단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다. 길이가 0인 단어는 주어지지 않는다.

//출력
//입력으로 주어진 단어를 열 개씩 끊어서 한 줄에 하나씩 출력한다. 
//단어의 길이가 10의 배수가 아닌 경우에는 마지막 줄에는 10개 이하의 글자만 출력할 수도 있다.

import java.util.*;

class Loop2
{
		public static void main(String[] args) 
	{

		Scanner scan=new Scanner(System.in);
		String str = scan.nextLine();

    int ten=10;
    int n=str.length()/10;		
		
    //예를들어, 문자가 11개인 경우
    //n은 1이니까 한번 더돌아야해
		for(int i=0; i<n+1; i++){
      //마지막줄 출력인 경우
 			if(i==n) 
        ten = str.length()%10;
      //두번째반복부터 시작값을어떻게줄까 : +(i*10)
      //마지막 줄 출력인데, ten(10)이 조건식에있으면 참조범위에러발생
			for (int j=0+(i*10); j<ten+(i*10); j++)
			{	
				System.out.print(str.charAt(j));
			}
			System.out.println();
		}

	}
}
