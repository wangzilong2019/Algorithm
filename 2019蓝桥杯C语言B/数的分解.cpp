#include<stdio.h>
int isTrue(int a, int b, int c) {
	//���־λ��ʼʱû�� 
	int flag = 0;
	//�ж�����a���Ƿ���2��4 
	while (a) {
		int temp = a % 10;
		if (temp == 2 || temp == 4) {
			flag = 1;
			break;
		}
		a = a / 10;
	}
	while (b) {
		int temp = b % 10;
		if (temp == 2 || temp == 4) {
			flag = 1;
			break;
		}
		b = b / 10;
	}
	while (c) {
		int temp = c % 10;
		if (temp == 2 || temp == 4) {
			flag = 1;
			break;
		}
		c = c / 10;
	}
	return flag;	
}
int main () {
	int i, j, k;
	int count = 0;
	for (i = 1; i <= 700; i++) {
		for (j = i + 1; j <= 1100; j++) {
			for (k = j + 1; k <= 2019; k++) {
				//�ж���������֮���Ƿ�Ϊ2019
				if (i + j + k == 2019) {
					//�ж��Ƿ�������2��4
					if ( !isTrue(i, j, k)) {
						count++;
					} 
				} 
			}
		}
	}
	printf("%d\n",count);
	return 0;
}
