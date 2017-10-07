//입력이 push 1, push2, size, empty 같은 형태일때 동작하는 스택

import java.util.*;

class Main
{	//everyting is in Stack class
	static class Stack{ 
		private int size=0;
		private NODE top=null; //'NULL' is not //NODE user datatype can be here //top is a pointer

		private class NODE{
			int data; //data can be accessed from outside, so int.
			private NODE next; //next directs preNODE
		}
		public void push(int n){
			//create NODE
			NODE node=new NODE();
			//NODE set
			node.data=n;
			node.next=top; //first:next->top(null), Since second:next->top(pre node)
			//top set
			top=node; //top&node is NODE type
			//size up
			size++;
		}
		public void pop(){
			//if empty
			if(size==0) System.out.println(-1);
			else{
				//pointer.data
				System.out.println(top.data);
				//move pointer
				top=top.next;
				//size down
				size--;
			}
		}
		public void size(){System.out.println(size);}
		public void empty(){if(size==0)System.out.println(1);else System.out.println(0);}
		public void top(){if(top==null)System.out.println(-1);else System.out.println(top.data);}

	}
	public static void main(String[] args) 
	{
		Stack stack=new Stack();

		Scanner scan=new Scanner(System.in);
		int n=Integer.parseInt(scan.nextLine()); //how many times to repeat, n
		
		for(int i=0; i<n; i++){
			String s=scan.nextLine();
			//★ This is crazy
			//can split sentence with space
			String[] temp = s.split(" "); //not ' ' for String
	//			System.out.println(temp[0]+" "+temp[1]);
	
			//s=="input" is flase
			//★ s.equals("input") is true 

			if(temp[0].equals("push")){ //not ' ' for String
				//change cause tmpe[] is String
				stack.push(Integer.parseInt(temp[1]));
			}else if(s.equals("pop")){
				stack.pop();
			}else if(s.equals("size")){
				stack.size();
			}else if(s.equals("empty")){
				stack.empty();
			}else if(s.equals("top")){
				stack.top();			
			}

		}
		scan.close();
	}
}
