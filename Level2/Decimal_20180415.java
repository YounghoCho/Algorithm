//에라토스테스체(수정) : 180526
package youngho;

public class Main{

	public static void prime(int n) {
		System.out.println(n + "까지의 소수를 구합니다 !");
		int arr[] = new int[n];
		init(arr);

		for(int i = 2; i < Math.sqrt(n); i++) { //검사 범위(1 ~ n), 수학적으로 정확한 계산은 루트값
			if(arr[i] == 0)	//이미 소수가 아닌것은 거른다.
				continue;
			for(int j = i + i; j < n; j += i) { //검사하는 숫자의 배수들을 칠한다, 처음 시작하는 수는 2,3일 필요가없다.
				arr[j] = 0;
			}
		}
		print_prime(arr);
	}
	public static void init(int arr[]) {
		for(int i = 2; i<arr.length; i++)
			arr[i] = i;
	}
	public static void print_prime(int arr[]) {
		for(int i = 2; i<arr.length; i++)
			if(arr[i]!=0)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String args[]) {
		//TC
		prime(50);
		prime(100);
		prime(150);
	}
}
