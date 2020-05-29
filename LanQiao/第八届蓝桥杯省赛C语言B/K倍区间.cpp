#include<stdio.h>
#define MAX 100000
int main () {
	int N, K, i, j;
	int a[MAX];
	int sum = 0;
	int count = 0;

	scanf("%d",&N);

	scanf("%d",&K);

	for (i = 0; i < N; i++) {
		scanf("%d",&a[i]);
	}
	for (i = 0; i < N; i++) {
		for (j = i; j < N; j++) {
			sum += a[j];
			if (sum % K == 0) {
				count++;
			}
		}
		sum = 0;
	}
	printf("%d",count);
	return 0;
}
