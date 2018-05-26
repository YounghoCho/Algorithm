//소인수분해
package youngho;

public class Main{
	public static void divide(int n) {
		System.out.println(n + "의 소인수분해를 시작합니다 !");
		int q[] = new int[50];
		int index = 0;
		//Logic
		while(n > 1) { // n>0이면 안됩니다. 왜냐면, 8을 3번 나누면 1이기 때문이죠
			int i = 2;
			for (int j = i ; j < 50 ;j++) {
				if ( n % j == 0) {
					q[index] = j;
					index++;
					n = n/j;
					break;
				}
			}
		} 
		for(int i = 0 ; q[i] != 0; i++)	//효과적인 출력방법
			System.out.print(q[i] + ", ");
		System.out.println();
	}

	public static void main(String args[]) {
		//TC
		divide(8); //2.2.2
			divide(10); //2.5
			divide(14); //2.7
			divide(30); //2.3.5			
		}
}
