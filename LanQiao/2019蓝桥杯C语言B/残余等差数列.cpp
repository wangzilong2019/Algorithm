#include<stdio.h>
#define MAX 100000
int main () {
	int n, i, j;
	int a[MAX];
	int max, min;
	int ctn;
	int d;
	//����������еĸ��� 
	scanf("%d",&n);
	//���������е�ֵ
	for (i = 1; i <= n; i++) {
		scanf("%d",&a[i]);
	} 
	max = a[1];
	min = a[1];
	//�������������ҵ������е������Сֵ
	for (i = 1; i <= n-1; i++) {
		for (j = 1; j <= n-i; j++) {
			if (a[j] > a[j+1]) {
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
		}
	} 
	min = a[1];
	max = a[n];
	d = a[2] - a[1];
	ctn = (max - min) / d + 1;
	printf("%d\n",ctn);
	return 0;
} 
