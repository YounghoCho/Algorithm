import java.util.*;

class Main 
{
	static class Stack{
		private int MAX=1000;
		//int arr[MAX]; //error
		int arr[]=new int[MAX];
		int top=-1;
		public void push(int data){
			arr[++top]=data;
		}
		public void pop(){
			if(top==-1) System.out.println("empty");
			else
				System.out.println(arr[top--]);
		}
		public void top(){
			if(top==-1) System.out.println("empty");
			else
				System.out.println(arr[top]);
		}
		public void empty(){
			if(top==0)System.out.println("empty"); else System.out.println("not empty");}
		public void size(){
			System.out.println(top+1);}
	}
	public static void main(String []args){
		Stack stack=new Stack();
		
		//get n that is the number of repeat
		Scanner scan= new Scanner(System.in);
		int n= Integer.parseInt(scan.nextLine());
	
		for(int i=0; i<n; i++){
			//get String input that are ( push 1, push 2, pop, size ...)
			String s= scan.nextLine();
			String temp[]= s.split(" "); //not spilt, split. //not ' ' as String

			if(temp[0].equals("push")) //not ' ' as String
				stack.push(Integer.parseInt(temp[1])); //shold change datatype
			else if(temp[0].equals("pop"))
				stack.pop();
			else if(temp[0].equals("size"))
				stack.size();
			else if(temp[0].equals("empty"))
				stack.empty();
			else if(temp[0].equals("top"))
				stack.top();
		}
	}
}
