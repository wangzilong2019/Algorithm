//���ŵĻ���˼���ǽ�һ�������Ԫ�طֽ�����������Ĳ��֣�ͨ���ݹ麯�������������ʹ�������ݱ����������
//����ʱ�ֽ��ѣ����Ǻϲ���
//��׼Ԫ��ѡȡ��һ�����һ�������м�һ�����ǵ�һ�������һ������������ر�˵��ѡȡ��һ�� 
#include<stdio.h>
#define MAX 100
int Partition(int a[],int low,int high){  //���ֺ��� 
	int i=low;
	int j=high;
	int pivot=a[low];  //��׼Ԫ�� 
	int temp;
	while(i<j){
		while(i<j && pivot<a[j]){  //����ɨ�� 
			j--;
		}
		if(i<j){  //����Ԫ�غ� i ����һλ 
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;
		}
		while(i<j && pivot>a[i]){  //����ɨ�� 
			i++;
		}
		if(i<j){  //����Ԫ�غ� j ������һλ 
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			j--;
		}
	}
	return i;  //�������ջ��ְ��ɺ��׼Ԫ������λ�� 
} 
void QuickSort(int a[],int low,int high){  //��������ݹ��㷨 
	int mid;
	if(low<high){
		mid=Partition(a,low,high);  //��׼λ�� 
		QuickSort(a,low,mid-1);  //������ݹ�������� 
		QuickSort(a,mid+1,high);  //������ݹ�������� 
	}
}
int main(){
	int r[MAX];
	int i,n;
	printf("������Ҫ����Ԫ�صĸ�����\n");
	scanf("%d",&n);
	printf("������Ҫ�����Ԫ�أ�\n");
	for(i=0;i<n;i++){
		scanf("%d",&r[i]);
	} 
	QuickSort(r,0,n-1);
	printf("����������Ϊ��\n");
	for(i=0;i<n;i++){
		printf("%d ",r[i]);
	}
	return 0;
} 
