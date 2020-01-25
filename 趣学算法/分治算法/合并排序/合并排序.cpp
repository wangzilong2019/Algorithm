//合并算法三步骤：
//分解：将待排序数列分解成俩个子序列 
//治理：将子序列进行排序 
//合并：将子序列合并成一个有序的数列 
#include<stdio.h>
#define MAX 100
void Merge(int a[],int low,int mid,int high){
	int i,j,k;
	int b[MAX];
	i=low;
	j=mid+1;
	k=0;
	while(i<=mid && j<=high){
		if(a[i]<a[j]){
			b[k++]=a[i++];
		}
		else{
			b[k++]=a[j++];
		}
	}
	while(i<=mid){
		b[k++]=a[i++];
	}
	while(j<=high){
		b[k++]=a[j++];
	}
	for(i=low,k=0;i<=high;i++,k++){
		a[i]=b[k];
	}
}
void MergeSort(int a[],int low,int high){
	if(low<high){
		int mid=(low+high)/2;  //取中点 
		MergeSort(a,low,mid);  //对前半部分进行排序 
		MergeSort(a,mid+1,high);  //对后半部分进行排序 
		Merge(a,low,mid,high);  //进行合并排序 
	}
}
int main(){  
	int n,i;
	int r[MAX];
	printf("请输入数列中元素的个数：\n");
	scanf("%d",&n);
	printf("请依次输入数列中的元素：\n");
	for(i=0;i<n;i++){
		scanf("%d",&r[i]);
	}
	MergeSort(r,0,n-1);
	printf("合并排序的结果是：\n");
	for(i=0;i<n;i++){
		printf("%d ",r[i]);
	}
	return 0;
} 
