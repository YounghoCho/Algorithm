/*
싱글톤 패턴이란?
인스턴스간의 간섭을 피하기 위해, 인스턴스를 오직 하나만 만든다.
*/

//singletone의 기본형 : 멤버변수는 static, 생성자는 private/protected
import java.util.*;

class Main
{
	static class Singletone
	{	
		//여기서 Singletone이라는 하나의 인스턴스만 생성된다.
		private static Singletone s= new Singletone();

		protected Singletone(){
			System.out.println("made singletone");
		}
		public static Singletone getInstance(){
			return s;
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("Singletone Patten start");
		Singletone s1= new Singletone();
		Singletone s2= new Singletone();

		//둘의 결과는 완벽하게 일치한다.
		System.out.println(s1.getInstance());
		System.out.println(s2.getInstance());
	}
}
