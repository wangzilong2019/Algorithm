#include<stdio.h>
#include<math.h>
#define MAX 100001
int main () {
	int N, i, j, r;
	double A[MAX];
	double sum;
	double max;
	//输入完全二叉树节点数 
	scanf("%d",&N);
	//输入每个节点权值 
	for (i = 1; i <= N; i++) {
		scanf("%lf",&A[i]);
	}
	max = A[1];
	r = 1;
	//分别遍历每层节点 
	for (i = 1; i <= log(1+N)/log(2); i++) {
		//给累加值清零 
		sum = 0;
		//第i层做累加和 
		for (j = pow(2, i-1); j <= pow(2, i) - 1; j++) {
			sum += A[j];
		}
		//判断累加和的值
		if (sum > max) {
			max = sum;
			r = i;
		} 
		else {
			if (fabs(sum-max) < 1e-6) {
				//判断层大小
				if (r > i) {
					r = i;
				} 
			}
		}
	}
	printf("%d\n",r);
	return 0;
} 
