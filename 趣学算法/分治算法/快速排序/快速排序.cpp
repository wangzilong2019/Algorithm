//快排的基本思想是将一组带排序元素分解成俩个独立的部分，通过递归函数对其进行排序，使整个数据变成有序序列
//排序时分解难，但是合并简单
//基准元素选取第一个最后一个或是中间一个或是第一个与最后一个随机数，无特别说明选取第一个 
#include<stdio.h>
#define MAX 100
int Partition(int a[],int low,int high){  //划分函数 
	int i=low;
	int j=high;
	int pivot=a[low];  //基准元素 
	int temp;
	while(i<j){
		while(i<j && pivot<a[j]){  //向左扫描 
			j--;
		}
		if(i<j){  //交换元素后 i 右移一位 
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			i++;
		}
		while(i<j && pivot>a[i]){  //向又扫描 
			i++;
		}
		if(i<j){  //交换元素后 j 向左移一位 
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			j--;
		}
	}
	return i;  //返回最终划分按成后基准元素所在位置 
} 
void QuickSort(int a[],int low,int high){  //快速排序递归算法 
	int mid;
	if(low<high){
		mid=Partition(a,low,high);  //基准位置 
		QuickSort(a,low,mid-1);  //左区间递归快速排序 
		QuickSort(a,mid+1,high);  //又区间递归快速排序 
	}
}
int main(){
	int r[MAX];
	int i,n;
	printf("请输入要排序元素的个数：\n");
	scanf("%d",&n);
	printf("请输入要排序的元素：\n");
	for(i=0;i<n;i++){
		scanf("%d",&r[i]);
	} 
	QuickSort(r,0,n-1);
	printf("排序后的序列为：\n");
	for(i=0;i<n;i++){
		printf("%d ",r[i]);
	}
	return 0;
} 
