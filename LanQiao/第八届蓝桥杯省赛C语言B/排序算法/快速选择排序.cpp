/** 1、思路：首先从n个元素中找出最大值并记录下标号，与最后一个元素交换
    2、n-1个元素中找出最大值和倒数第二个元素交换
	3、依次直至只有一个元素 

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
	//输入待排序的元素个数 
	scanf("%d",&n);
	for (i = 0; i < n; i++) {
		scanf("%d",&a[i]);
	}
	
	//调用直接选择排序方法对数组排序
	selectSort(a, n);
	//输出排序后的元素
	for (i = 0; i < n; i++) {
		printf("%d ",a[i]);
	} 
	return 0;
}
