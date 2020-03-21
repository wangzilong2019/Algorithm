#include<stdio.h>
int main () {
	int i, j, k, m, l;
	int max = 0;
	int sum;
	int a[21][6];
	for (i = 1; i <= 20; i++) {
		for (j = 1; j <= 5; j++) {
			scanf("%d",&a[i][j]);
		}
	}
	//选一号位 
	for (i = 1; i <= 20; i++) {
		//选二号位 
		for (j = 1; j <= 20; j++) {
			//一号位二号位不为同一人
			if (i != j) {
				//选三号位
				for (k = 1; k <= 20; k++) {
					//三号位与一二号位不同
					if (k != i && k != j) {
						//选四号位
						for (m = 1; m <= 20; m++) {
							//四号位与一二三号位不同
							if (m != i && m != j && m != k) {
								//选5号位
								for (l = 1; l <= 20; l++) {
									//5号位与前面都不同
									if (l != i && l != j && l != k && l != m) {
										sum = a[i][1] + a[j][2] + a[k][3] + a[m][4] + a[l][5];
										if (sum > max) {
											max = sum;
										}
									} 
								} 
							} 
						} 
					} 
				} 
			}
		}
	}
	printf("%d\n",sum);
	return 0;
} 
