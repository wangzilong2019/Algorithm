#include<stdio.h>
#define N 10000
int cnt = 0;  // 用来记录满足条件素数个数
int a[N] = {0};   //a[i]用来记录i是否为素数
int p[N] ;  //用来记录素数
//此函数用来记录素数 
void init() {
	for (int i = 2; i <= N; i++) {
		//判断i是否为素数 
		if ( !a[i] ) {
			//i为素数存储到p数组中
			p[++cnt] = i;
			for (int j = i+i; j <= N; j += i) {
				a[j] = 1;
			} 
		}
	}
}
int main() {
	int i, j;
	//初始化记录素数
	init();
	//搜索函数
	//外层循环为公差
	for (int d = 1; d <= N; d++) {
		int count = 0; 
		//遍历素数 
		for (int i = 1; i <= cnt; i++) {
			count = 0; 
			for (int j = p[i]; j <= N; j += d) {
				//判断j是否为素数 
				if (a[j]) {
					count = 0;
					break;
				} 
				count++;
				if (count == 10) {
					printf("%d\n",d);
				}
			}
		}
	} 
	return 0;
} 
