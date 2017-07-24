#include<stdio.h>
#include<string.h> //strlen
#include<stdlib.h> //malloc

int main()
{
	int count=1;
	int temp,i;
	char *str= (char*)malloc(sizeof(char)); //포인터생성
	//malloc으로 동적할당을 하는이유는 하나이상의 포인터가 필요하기 때문
	//malloc으로 heap영역의 메모리를 할당한다.(calloc, realoc 존재)
	
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
	//heap영역의 포인터메모리를 해제한다.
	free(str);
	return 0;
}
