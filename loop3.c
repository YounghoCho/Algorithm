#include<stdio.h>
int main()
{
	int i,j,k;
	int n;
	scanf("%d",&n);
	
	for(i=1; i<=n; i++) //n번 돌려 
	{	
		for(k=1; k<i; k++)
			printf(" ");
		for(j=2*n-1; j>=2*i-1; j--) //2n-1번씩 출력 
			printf("*");
		printf("\n"); 
	}
	for(i=1; i<n; i++)
	{
		for(k=1; k<n-i; k++)
			printf(" ");
		for(j=0; j<2*i+1 ; j++)
			printf("*");
		printf("\n");
	}
	return 0;
}
