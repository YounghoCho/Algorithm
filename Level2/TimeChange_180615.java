/* 카카오 공채 4번
http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
/*

/* package whatever; // don't place package name! */

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String arr[] = {"08:00", "08:01", "08:02", "08:03"};
		int minTable[] = new int[arr.length];
		int n=1, t=1, m=5;
		changeToMinute(arr, minTable);
		//정렬 추가
		sort(minTable);
		getLatestTime(minTable, n, t, m);
	}
	public static void getLatestTime(int arr[], int n, int t, int m){
		int start=540;
		//outer : i=start, n만큼 만복, start+=t.
		//inner : t분씩 증가하며 m만큼 반복하며 태운다.	
		
		//1. m보다 len이 작으면 뒤에 붙인다 / 540보다 작으면 540 크면 마지막+1
		//2. m보다 len이 같은데/전부 len[i]보다 크면 맨앞, 그게아니면 뒤에서부터비교해서 삽입
		//3. m보다 len이 크면, len에서 m만큼 이동하고 빠져나오면서 start증가
	}
	public static void sort(int arr){
		
	}
	public static void changeToMinute(String arr[], int minTable[]){
		int hour;
		int min;
		for(int i=0; i<arr.length; i++){
			hour = (arr[i].charAt(0)-'0')*10 + (arr[i].charAt(1)-'0');
			min = (arr[i].charAt(3)-'0')*10 + (arr[i].charAt(4)-'0');
			minTable[i] = hour*60 + min;
		}
	}
}
