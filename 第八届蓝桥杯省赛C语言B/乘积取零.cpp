#include<stdio.h>
int main () {
	int i,n;
	int count;
	int ctn2 = 0;
	int ctn5 = 0; 
	
	/**1����Ϊ10 == 2 * 5 
	      ������Ҫ����β��Ϊ�������ÿ�����ܱ�2��5�������Σ�ȡ��Сֵ��Ϊβ����ĸ��� 
	*/ 
	for (i = 0; i < 100; i++) {
		scanf("%d",&n);
		while (n % 2 == 0) {
			n = n / 2;
			ctn2++;
		}
		while (n % 5 == 0) {
			n = n / 5;
			ctn5++;
		}
	}
	if (ctn2 > ctn5) {
		count = ctn5;
	}
	else {
		count = ctn2;
	}
	printf("%d",count);
	return 0;
}
