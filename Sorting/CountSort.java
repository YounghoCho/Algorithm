//계수정렬(CountSort)
//정말 레알 빠른 방식이다. 무려 O(n)

//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

//출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

    /*
    ===================Counting Sort===================
    int size=배열길이;
    int count[]=new int[숫자범위+1];
    int temp;
    //카운팅
		for (int i=0; i<size; i++){
			temp=Integer.parseInt(br.readLine());
			count[temp]++;
	  }
    //출력
    for(int i=0; i<=10000; i++)
			for(int j=0; j<count[i]; j++)
				os.write((i+"\n").getBytes());    
    ===================================================
    */

//입출력을 사용하기 위한 패키지
import java.io.*;

public class CountSort {
	//입출력은 예외가 발생하므로 항상 예외처리를 한다.
	public static void main(String[] args) throws Exception{
		//Scanner를 쓰면 실제로 느리다고 한다(주의)
    //입력
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//출력
		OutputStream os = new BufferedOutputStream(System.out);
		//받아오는 문법도 Scanner와는 다르다
		int size=Integer.parseInt(br.readLine());
		//맥시멈 사이즈에 1을 더해준다
		//count는 입력받는 숫자를 바로 해당 숫자 위치에 카운팅하는 배열이다.
		int count[]=new int[10001];
		//배열을 대신하여 간단하게 변수만 사용한다.
		int temp;
		for (int i=0; i<size; i++){
			//입력받는즉시
			temp=Integer.parseInt(br.readLine());
			//카운팅
			count[temp]++;
		}
		//0~10000 사이의 숫자중에서
		for(int i=0; i<=10000; i++)
			//입력받은 숫자들만, 작은수부터 반복 출력한다
			//예를들어 4 4 2 1을 입력받은경우
			//count는 0 1 1 0 2 이된다.
			for(int j=0; j<count[i]; j++)
				//count[0]=0이므로 안찍히고
				//count[1]=1이므로 i=1를 한번찍는다.
				//count[4]=2이므로 i=4를 두번찍는다

				//출력문법
				//InputStream과 OutputStream은 바이트단위로 데이터를 처리한다★
				//그래서 위에서는 Integer.parseInt()를 사용했고
				//여기서는 바이트단위로 사용하기 위해 getBytes()가 있어야 에러나지않음
				//String s=""인 경우에는, os.write(s.getBytes());라 해야 출력된다.
				os.write((i+"\n").getBytes());
		os.flush();
	}
}
