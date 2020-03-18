#include<stdio.h>
#define MAX 100
int a[MAX];
int max,min;
int lmax, lmin, rmax, rmin;
void searchf(int i, int j, int m,int n) {
	//����������ֻ��һ����ʱ 
	if (i == j) {
		max = min = a[j];
	}
	else {
		//������������������ʱ 
		if (i == j-1) {
			if (a[i] > a[j]) {
				max = a[i];
				min = a[j];
			}
			else {
				max = a[j];
				min = a[i];
			}
		}
		//������������ڶ����ʱ 
		else {
			//�����仮��Ϊ������ 
			int mid = (i + j) / 2;
			//�ֱ����������������ֵ��Сֵ 
			searchf(i, mid, lmax, lmin);
			searchf(mid + 1, j, rmax, rmin);
			if (lmax > rmax) {
				max = lmax;
			}
			else {
				max = rmax;
			}
			if (lmin > rmin) {
				min = rmin;
			}
			else {
				min = lmin;
			}
		}
	}
}
int main () {
	int i, j;
	int n;
	scanf("%d",&n);  //ȡn����
	for  (i = 0; i < n; i++) {
		scanf("%d",&a[i]);
	}
	lmax = a[0];
	lmin = a[0];
	rmax = a[n-1];
	rmin = a[n-1];
	searchf(0, n-1, a[0], a[0]);
	printf("%d %d\n",max, min);
	return 0;
} 
