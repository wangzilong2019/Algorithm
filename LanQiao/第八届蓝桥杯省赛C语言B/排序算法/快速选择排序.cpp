/** 1��˼·�����ȴ�n��Ԫ�����ҳ����ֵ����¼�±�ţ������һ��Ԫ�ؽ���
    2��n-1��Ԫ�����ҳ����ֵ�͵����ڶ���Ԫ�ؽ���
	3������ֱ��ֻ��һ��Ԫ�� 

*/
#include<stdio.h>
#define MAX 100
void selectSort(int a[], int n) {
	int i, j, index, max, temp;
	for (i = 0; i < n - 1; i++) {
		index = 0;
		max = a[0];
		for (j = 1; j < n-i; j++) {
			if (a[j] > max) {
				index = j;
				max = a[j];
			}
		}
		temp = a[n-1-i];
		a[n-1-i] = a[index];
		a[index] = temp;
	}
}
int main () {
	int i, j, index, max, n;
	int a[MAX];
	//����������Ԫ�ظ��� 
	scanf("%d",&n);
	for (i = 0; i < n; i++) {
		scanf("%d",&a[i]);
	}
	
	//����ֱ��ѡ�����򷽷�����������
	selectSort(a, n);
	//���������Ԫ��
	for (i = 0; i < n; i++) {
		printf("%d ",a[i]);
	} 
	return 0;
}
