#include<stdio.h>
#include<math.h>
#define MAX 100001
int main () {
	int N, i, j, r;
	double A[MAX];
	double sum;
	double max;
	//������ȫ�������ڵ��� 
	scanf("%d",&N);
	//����ÿ���ڵ�Ȩֵ 
	for (i = 1; i <= N; i++) {
		scanf("%lf",&A[i]);
	}
	max = A[1];
	r = 1;
	//�ֱ����ÿ��ڵ� 
	for (i = 1; i <= log(1+N)/log(2); i++) {
		//���ۼ�ֵ���� 
		sum = 0;
		//��i�����ۼӺ� 
		for (j = pow(2, i-1); j <= pow(2, i) - 1; j++) {
			sum += A[j];
		}
		//�ж��ۼӺ͵�ֵ
		if (sum > max) {
			max = sum;
			r = i;
		} 
		else {
			if (fabs(sum-max) < 1e-6) {
				//�жϲ��С
				if (r > i) {
					r = i;
				} 
			}
		}
	}
	printf("%d\n",r);
	return 0;
} 
