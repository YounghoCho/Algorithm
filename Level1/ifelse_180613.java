/* 카카오 공채 2번

다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수^1 , 점수^2 , 점수^3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
*/

//시간이 오래걸린 이유, 테스트케이스를 잘 살펴보고 원리를 파악했어야 하는데 대충 이해하고 짜려고했음.
//1.우선 TC를 통해 원리를 정확히 파악한다
//2.설계를 한다음 알고리즘을 짠다.

import java.util.*;

class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		dart("1S2D*3T");
		dart("1D2S#10S");
		dart("1D2S0T");
		dart("1S*2T*3S");
		dart("1D#2S*3S");
		dart("1T2D3D#");
		dart("1D2S3T*");
	}
	public static void dart(String str){
		int arr[] = new int[3];
		int index=0;
		int temp=0;
		for(int i=0; i<str.length(); i++){
			//case 1 : 숫자입력
			if(str.charAt(i)-'0' >= 0 && str.charAt(i)-'0' < 10){
				temp=str.charAt(i)-'0';
				//예외1 : 정수가 10일때
				if(temp == 1 && str.charAt(i+1)-'0'== 0){
					temp=10;
					i++;
				}
			//	System.out.println("숫자:"+temp);
				//저장
				arr[index]=temp;
				index++;
			}
			//case 2 : 배율입력
			else if(str.charAt(i) == 'S' || str.charAt(i) == 'D' || str.charAt(i) == 'T'){
				temp=arr[index-1];
				switch(str.charAt(i)){
					case 'S':
						temp = temp; break;
					case 'D':
						temp = temp * temp; break;
					case 'T':
						temp = temp * temp * temp; break;
				}
			//	System.out.println("곱해진값:"+temp);
				arr[index-1]=temp;
			//case 3 : 보너스
			}
			else{
			//	System.out.println("///보너스 적용///");
				if(str.charAt(i) == '#'){
					arr[index-1] *= -1;
				}
				else if(str.charAt(i) == '*'){
					if(i<=3){
 						arr[index-1] *= 2;
					}
 					else{
 						arr[index-1] *= 2;
						arr[index-2] *= 2;
 					}
				}
			}
			
		}
	System.out.println(arr[0]+arr[1]+arr[2]);
	}

}
