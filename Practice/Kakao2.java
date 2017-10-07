최대 10만줄의 문자열이 들어왔을때 길이가 짧은 단어 순서대로 문자열을 배치하고 아래 조건을 만족한다.

1) 단어별로 띄어쓰기가 이루어진다.
2) 맨앞 단어는 대문자다
3) 마지막 단어에는 정점(.)이 찍힌다.

ex)
Hello i am youngho jo.
I am jo hello youngho.

import java.util.*;

class Main
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		//전체를 소문자로 변환
		s=s.toLowerCase();
		//문자열 분해
		String temp[]=s.split(" ");
		//마지막 위치의 정점 떼기
		int len=temp.length;
		temp[len-1]=temp[len-1].substring(0,temp[len-1].length()-1);

		//문자 크기순으로 문자열 정렬		
		String empty="";
		for(int i=0; i<temp.length-1; i++){
			for(int j=0; j<temp.length-1-i; j++){
				if(temp[j].length()>temp[j+1].length()){
					empty=temp[j];
					temp[j]=temp[j+1];
					temp[j+1]=empty;
				}
			}
		}

		//출력
		for(int i=0; i<temp.length; i++){
			if(i==0){
				String first=(temp[0].substring(0,1)).toUpperCase();//맨앞을 대문자로
				System.out.print(first+temp[0].substring(1,temp[0].length())+" ");
			}
			else if(i==temp.length-1){
				//마지막에는 정점붙이기
				System.out.print(temp[temp.length-1]+".");
			}
			else
				System.out.print(temp[i]+" ");

		}

	}
}
