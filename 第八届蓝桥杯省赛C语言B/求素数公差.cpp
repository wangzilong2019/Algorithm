#include<stdio.h>
#define N 10000
int cnt = 0;  // ������¼����������������
int a[N] = {0};   //a[i]������¼i�Ƿ�Ϊ����
int p[N] ;  //������¼����
//�˺���������¼���� 
void init() {
	for (int i = 2; i <= N; i++) {
		//�ж�i�Ƿ�Ϊ���� 
		if ( !a[i] ) {
			//iΪ�����洢��p������
			p[++cnt] = i;
			for (int j = i+i; j <= N; j += i) {
				a[j] = 1;
			} 
		}
	}
}
int main() {
	int i, j;
	//��ʼ����¼����
	init();
	//��������
	//���ѭ��Ϊ����
	for (int d = 1; d <= N; d++) {
		int count = 0; 
		//�������� 
		for (int i = 1; i <= cnt; i++) {
			count = 0; 
			for (int j = p[i]; j <= N; j += d) {
				//�ж�j�Ƿ�Ϊ���� 
				if (a[j]) {
					count = 0;
					break;
				} 
				count++;
				if (count == 10) {
					printf("%d\n",d);
				}
			}
		}
	} 
	return 0;
} 
