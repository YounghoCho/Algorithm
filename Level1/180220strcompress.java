/* UKOV
알파벳 문자열을 입력받고 같은 알파벳이 연속해서 나오면 
알파벳과 숫자로 결과를 나타내라

입력)aaabbbccd
출력)a3b3c2d1
*/

import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner scan= new Scanner(System.in);
		String str="";
		
		press(str= scan.nextLine());
		scan.close();
	}
	static void press(String str){
		int count=1;
//		char temp=''; //error
		char temp;
		int len= str.length();
		System.out.println(len);
		String result="";

		for(int i=0; i<len-1; i++){
			temp=str.charAt(i);
			if(temp==str.charAt(i+1)){
				count++;
				//다음 문자가 같을때, 한번 덜 도는것을 찍어낸다.
				if(i==len-2){
					result+=str.charAt(i);
					result+=count;
				}
			}
			else{
				result+=str.charAt(i);
				result+=count;
				count=1;
				//다음문자다 다를때, 한번 덜 도는것을 찍어낸다.
				if(i==len-2){
					result+=str.charAt(i+1);
					result+=count;
				}
			}
		}
		System.out.println("result:"+result);
	}
}
