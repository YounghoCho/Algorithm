//카카오 2018 공채 1번 문제
/*
입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 “공백”(“ “) 또는 “벽”(“#”) 두 종류로 이루어져 있다.
전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.
*/

package youngho;

public class Main{
	public static void main(String args[]) {
		int n = 5;
		int arr[] = {9, 20, 28, 18, 11};
		int arr2[] = {30, 1, 21, 17, 28};	
		treasure(n, arr, arr2);
	}
	public static void treasure(int n, int arr[], int arr2[]) {
		for (int i = 0; i < n; i++) {
			int temp = arr[i] | arr2[i];
			binary(temp);
			if (i + 1 < n)
				System.out.print(", ");
		}
	}
	public static void binary(int n) {
		String str = "";
		while (n > 0){
			if (n % 2 == 0) {
				str += " ";
			}else {
				str += "#";
			}
			n /= 2;
		}
		reverse(str);
	}
	public static void reverse(String str) {
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		System.out.print(result);
	}
}
