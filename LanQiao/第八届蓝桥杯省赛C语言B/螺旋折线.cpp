#include<stdio.h>
#include<math.h>
#define MAX 1000
int len(int x,int y,int n) {
	int length;
	if (-x == fabs(x)) {
		length = n + y;
	}
	if (x == fabs(x)) {
		length = 5*n - y;
	}
	if (y == fabs(y)) {
		length = 3*n + x;
	}
	if (-y == fabs(y)) {
		length = 7*n - x;
	}
	return length;
	
}
int main () {
	int x, y, n;
	int dic;
	scanf("%d %d",&x,&y);
	if (fabs(x) > fabs(y)) {
		n = x;
	}
	else {
		n = y;
	}
	dic = 4*(n-1) + len(x, y, n);
	printf("%d\n",dic);
	return 0;
} 
