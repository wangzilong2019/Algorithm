#include<stdio.h>
#define MAX 30
double num[MAX][MAX];  //用来存放数字
int main () {
	int i, j;
	//读取矩阵中的数字
	for (i = 0; i < MAX-1; i++) {
		for (j = 0; j <= i; j++) {
			scanf("%lf",&num[i][j]);
		}
	} 
	//计算重量
	for (i = 1; i < MAX; i++) {
		//计算第一列 
		num[i][0] += (double)num[i-1][0]/2;
		
		//计算其它
		for (j = 1; j < i; j++) {
			num[i][j] += (double)(num[i-1][j-1]/2+num[i-1][j]/2);
		}
		//计算斜行
		num[i][i] += (double)num[i-1][i-1]/2;
	}
	//计算最大值最小值
	int max = 0;
	int min = 0;
	for (i = 1; i < MAX; i++) {
		if (num[MAX-1][i] > num[MAX-1][max]) {
			max = i;
		}
		if (num[MAX-1][i] < num[MAX-1][min]) {
			min = i;
		}
	} 
	printf("%lf\n",num[MAX-1][min]);
	printf("%lf\n",num[MAX-1][max]*2086458231/num[MAX-1][min]);
	return 0;
} 
