//소문자알파벳 문자열 최대 10만줄을입력받고 아래규칙처럼 문자열을 변환하시오
//aacc->abcd
//aaa->abc
//yzz->yab

//미제이유:z abc까지는 잘되지만 z abc~xzabc~ (중간에 y가 생략되버린다)

import java.util.*;
import java.io.*;

public class Solution {
		static String s="";		
		static int count[]=new int[26];//a-z(26)만큼의 배열선언(카운트용)
    public static void main(String args[] ) throws Exception {

		
		//Test number input
		Scanner scan=new Scanner(System.in);
		int T= Integer.parseInt(scan.nextLine());

		//T만큼 반복
		for(int i=0; i<T; i++){
			resetCount();
			//k(문자길이)
			int k=Integer.parseInt(scan.nextLine());
			//문자열입력
			s=scan.nextLine();
			//k만큼 돌면서 문자열입력(단, 알아서k길이만큼들어옴)
			for(int j=0; j<k; j++){
				//문자열 한개씩 읽고, 인덱스화
				int x = s.charAt(j)-'a';
//				System.out.println(x);
				//카운트 한개씩증가
				count[x]++;
			}
			//문자열복사
			//메인아이디어 : 뒤에서부터 옮긴다.
			StringBuilder q=new StringBuilder();
			//s를 q에 한개씩 넣는다
			for(int j=k-1; j>=0; j--){
				//s를 한개씩 불러오고
				int x = s.charAt(j)-'a';
				//이녀석이 카운팅배열에서 1이면 그대로 옮김
				if(count[x]==1){
					//문자로변환
					char y=(char)(x+97);
					q.append(y);
				}
				//1보다 크면
				//카운트-1 높여서 붙이고
				//카운트를 줄인다.
				else{
					char yx=(char)(x+97+count[x]-1);
					//오버플로우 예외처리
					//a가 0인데 카운트가 2이야 그럼 b(1)출력
					//a가 0인데 카운트가 26이야 그러면 z출력
					//(0+26)-26=0이니까 z
					//그럼 a가0인데 카운트가 27이면 0+27-26=1이니까 a(0)
					//그럼 z가25인데 카운트가 4이면 25+4-26=3이니까 c(0)

					//문제는 이게 한번만 돈다는거야
					if(x+count[x]-26>0)
						yx=(char)(x+count[x]%26-26-1+97);
				
					q.append(yx);
					//카운트 감소
					count[x]--;
				}					
			}
			//문자열뒤집기
			for(int p=k-1;p>=0; p--){
				System.out.print(q.charAt(p));
			}
			System.out.println();
		}

    }
	static public void resetCount(){
		for(int i=0; i<26; i++){
			count[i]=0;
		}
	}
}
