#include<stdio.h>
int main () {
	int i;
	int num[40];
	int a[8] = {0};
	int count = 0;
	for (int j = 0; j < 10; j++) {
		for (int m = 0; m < 32; m++) {
			scanf("%d",&num[m]);
		}
		for (int m = 0; m < 32; m++) {
			count++;
			i = 7;
			//清空二进制数组
			for (int f = 0; f < 8; f++) {
				a[f] = 0;
			} 
			if (num[m] < 0) {
				a[0] = 1;
				num[m] = -num[m];
			}
			while (num[m]) {
				a[i] = num[m] % 2;
				num[m] = num[m] / 2;
				i--;
			}
			for (i = 0; i < 8; i++) {
				if (a[i])
					printf("#");
				else
				    printf(" "); 
			}
			if (count % 2 == 0) {
				printf("\n");
			}
		}
	}
 	return 0;
}
