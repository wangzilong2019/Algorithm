#include<stdio.h>
#define MAX 30
double num[MAX][MAX];  //�����������
int main () {
	int i, j;
	//��ȡ�����е�����
	for (i = 0; i < MAX-1; i++) {
		for (j = 0; j <= i; j++) {
			scanf("%lf",&num[i][j]);
		}
	} 
	//��������
	for (i = 1; i < MAX; i++) {
		//�����һ�� 
		num[i][0] += (double)num[i-1][0]/2;
		
		//��������
		for (j = 1; j < i; j++) {
			num[i][j] += (double)(num[i-1][j-1]/2+num[i-1][j]/2);
		}
		//����б��
		num[i][i] += (double)num[i-1][i-1]/2;
	}
	//�������ֵ��Сֵ
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
