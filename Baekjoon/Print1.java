//문제
//입력 받은 대로 출력하는 프로그램을 작성하시오.

//입력
//입력이 주어진다. 입력은 최대 100줄로 이루어져 있고, 알파벳 소문자, 대문자, 공백, 숫자로만 이루어져 있다. 
//각 줄은 100글자를 넘지 않으며, 빈 줄은 주어지지 않는다. 또, 각 줄은 공백으로 시작하지 않고, 공백으로 끝나지 않는다.

import java.util.*;

class Print1
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		String str="";
		
        while(scan.hasNextLine()){ //'scan.' right, no 'str.'
                                   //hasNextLine() returns 'true or false'
                                   //hasNextLine() is a method to "wait for inputting nextLine"
            str=scan.nextLine();
            if(str.length()>100 || (char)str.charAt(0)==' ' || (char)str.charAt(str.length()-1)==' ')
				break;
            System.out.println(str);
        }
	}
}
