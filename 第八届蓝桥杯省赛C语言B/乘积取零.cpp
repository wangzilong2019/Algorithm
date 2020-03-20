#include<stdio.h>
int main () {
	int i,n;
	int count;
	int ctn2 = 0;
	int ctn5 = 0; 
	
	/**1、因为10 == 2 * 5 
	      索引若要计算尾积为零则计算每个数能被2或5整数几次，取最小值即为尾部零的个数 
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
