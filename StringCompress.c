#include<stdio.h>
#include<string.h> //strlen
#include<stdlib.h> //malloc

int main()
{
	int count=1;
	int temp,i;
	char *str= (char*)malloc(sizeof(char)); //포인터생성
	gets(str); //문자열입력
	for(i=0; i<strlen(str); i++)
	{
		if(str[i]==str[i+1])
		{
			count++;
			temp=i;
		}
		else if(str[i]!=str[i+1])
		{
			temp=i;
			printf("%c%d",str[temp],count);
			count=1;
		}
	}
return 0;
}
