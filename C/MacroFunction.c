#include<stdio.h>
#define square(x) (x)*(x) //the reason why i use ( ) is if you input a parameter '(3+1)', result will be 7 ( 1+3*1+3 ) 
#define cube(x) x*x*x
int main(){
	int a,b;
	scanf("%d %d",&a,&b);
	printf("(%d - %d) ^ 2 = %d\n",a,b,square(a-b));
	printf("(%d + %d) ^ 3 = %d\n",a,b,cube(a+b));
	return 0;
}
