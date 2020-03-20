#include<stdio.h>
#define MAX 1000
int sum = 0;  //������¼������Ŀ
char map[MAX][MAX];
int n;
int count = 0;
void dfs(int x, int y) {
	int nextX, nextY;
	int  location[4][2] = {1, 0, 0, 1, -1, 0, 0, -1};
	//�ֱ����ĸ���������ж��Ƿ�Ϊ���� 
	for (int i = 0; i < 4; i++) {
		nextX = x + location[i][0];
		nextY = y + location[i][1];
		if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
			if (map[nextX][nextY] == '#') {
				count++;
			}
		}
		if (count == 4) {
			sum++;
		}
	}
	count = 0;
}
int main () {
	int i, j;
	scanf("%d",&n);
	//��ȡ�ַ����� 
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			scanf("%c",&map[i][j]);
		}
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			if (map[i][j] == '#') {
				dfs(i, j);
			}
		}
	}
	printf("%d\n",sum);
	return 0;
} 
