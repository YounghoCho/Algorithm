//문제 1874
//1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
//이 때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
//임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
//이를 계산하는 프로그램을 작성하라.

//입력
//첫 줄에 n(1≤n≤100,000)이 주어진다. 
//둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

//출력
//입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. 
//push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

/*
예제 입력
8
4
3
6
8
7
5
2
1

예제 출력 
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-
*/

//very hard
import java.io.*;

class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Scanner는 100만개 기준 2.5초 BufferedReader는 0.4초
		//차이가 나는 이유는, Scanner와 달리 BufferedReader는 입력들을 한줄로 읽어들이기 떄문에 빠르다
		int i,k;
		int max=0,index=0;
		int n=Integer.parseInt(in.readLine());
		//stack간소화
		int stack[]=new int[n];
		//String클래스를 상속받은 StringBuilder는 append()메소드를 제공한다.
		//String은 기본적으로 s+s를 했을때 정수계산이 되지않고 연결되서 붙어버린다.
		//이과정을 간소화하고 빠르게 제공한다.
		//완전 똑같은 방식의 StringBuffer()도 있는다.
		//이건 멀티쓰레드 환경에서 동기화할때 사용한다. 
		//고로 조금 느리다.
		StringBuilder sb=new StringBuilder();
		
		while(n-- > 0){//wow
			//정수 입력
			k=Integer.parseInt(in.nextLine());
			//main idea: k와 max간에 재귀관계가 형성되야한다
			if(k>max)
				for(i=max; i<k; i++){
					//main idea2: 1씩 증가, 순차정렬이라는 문제의 조건을 이용
					//1부터 입력받은 k까지 스택에 저장된다.
					stack[index++]=i+1; 
					//문자열저장
					sb.append("+\n");
				}
			else
				//top이 수열로 만들어야하는 값이 아니면
				//그아래에서 꺼내야한다는 말인데, 다시 꺼냈다가 넣었다가 넣을수가 없음->종료
				if(stack[index-1] != k)
					{System.out.println("NO");return;}
			
			//스택에 k까지 넣었다가, k를 꺼내서 수열에 넣는 과정
			index--;
			sb.append("-\n");
			//main idea3: 잘생각해보면 5를뺸다음 4,3을 빼려면 max값이 변하면 안된다.
			//max가 안변하면 push하지않고 뺴기만 반복하면된다.
			//그러나 5를 뺐는데 그다음 더 큰수를 빼고자 하면
			//위의 for문에 i=max로 초기화되기떄문에 여기서 max값을 바꿔줘야한다.
			//안바꾸면 중복된 값이(이미 빠진값) 또 스택에 쌓인다.
			if(k>max)
		}
		//StringBuilder를 출력한다
		System.out.println(sb);

	}
}

//from
https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220812563361&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
