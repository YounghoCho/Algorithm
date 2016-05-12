#include<stdio.h>
int main()
{
	int i,j;
	int n;
	scanf("%d",&n);
	
	for(i=1; i<=n; i++) //n번 돌려 
	{	
		for(j=2*n-1; j>=i*2; j--)
			printf(" ");
		for(j=0; j<2*i-1; j++)
			printf("*");
		printf("\n");
	}
	return 0;
}
