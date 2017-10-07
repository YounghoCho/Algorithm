//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

import java.util.*;

class Main{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		int n=Integer.parseInt(scan.nextLine());
		Q q=new Q();

		while(n-->0){
			String s=scan.nextLine();
			String temp[]=s.split(" ");

			if(temp[0].equals("push"))
				q.push(Integer.parseInt(temp[1]));
			if(s.equals("pop"))
				q.pop();
			if(s.equals("size"))
				q.size();
			if(s.equals("empty"))
				q.empty();
			if(s.equals("front"))
				q.front();
			if(s.equals("back"))
				q.back();
		}
	}
  //큐 클래스 시작
	static class Q{
		private int size; //front,rear이 포인터라서, 크기 저장이 필요함
		private NODE front=null; //pointer
		private NODE rear=null;

		class NODE{ //class
			int data;
			NODE next; //NODE타입 pointer
		}
    //Enqueue
    //메소드들은 public이 붙어야한다. //not static
		public void push(int n){
			NODE node=new NODE();
			node.data=n;
      //main idea: 큐가 비었는지 판단하는 기준은 front==null인지 여부이다.
			if(front==null){ //중요
				front=node;
				rear=node;
			}else{
        //포인터 이동
				rear.next=node; //wow 정확한구조를 알아야함
 				rear=node;
			}
      //사이즈 저장
			size++;
		}
    //Dequeue
		public void pop(){
      //큐가 비었으면
			if(front==null)
				System.out.println(-1);
			else{
				System.out.println(front.data);
        //포인터 이동
				front=front.next;
				size--;
			}
		}
		public void front(){
      //앞이 빈경우==큐가비었다
			if(front==null)System.out.println(-1);
			else System.out.println(front.data);
		}
		public void back(){	
			//뒤가 빈경우==큐가비었다
      if(rear==null)System.out.println(-1);
			else System.out.println(rear.data);
		}
		public void size(){System.out.println(size);}
		public void empty(){if(front==null)System.out.println(1); else System.out.println(0);}
	}
}
