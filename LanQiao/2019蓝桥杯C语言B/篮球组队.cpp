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
	//ѡһ��λ 
	for (i = 1; i <= 20; i++) {
		//ѡ����λ 
		for (j = 1; j <= 20; j++) {
			//һ��λ����λ��Ϊͬһ��
			if (i != j) {
				//ѡ����λ
				for (k = 1; k <= 20; k++) {
					//����λ��һ����λ��ͬ
					if (k != i && k != j) {
						//ѡ�ĺ�λ
						for (m = 1; m <= 20; m++) {
							//�ĺ�λ��һ������λ��ͬ
							if (m != i && m != j && m != k) {
								//ѡ5��λ
								for (l = 1; l <= 20; l++) {
									//5��λ��ǰ�涼��ͬ
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
