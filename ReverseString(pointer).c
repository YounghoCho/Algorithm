//포인터를 사용해 문자열 역순으로 찍기
#include <stdio.h>

int main(void) {
	char str[]="youngho";
	int size=sizeof(str)/sizeof(str[0])-1;//문자열 맨끝에는 null이 포함되므로
	char *str1[size];
    
	int i=0;
	for(i=0; i<size; i++){
		str1[i]=&str[size-i-1];//*str1[i]에다가 문자을 대입하면 에러가납니다. //꼭 1을 빼줘야해요
	}
	for(i=0; i<size; i++){
		printf("%c",*str1[i]);
	}
	
	return 0;
}
