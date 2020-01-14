 //本题是在有限的时间内开更多的会议
//先对结束时间由早到晚排序找初不相容的即为 
#include<stdio.h>
#define MAX 1000
typedef struct{
	int beg;
	int end;
	int num;
}MEETING_TYPE;
int main(){
	MEETING_TYPE meet[MAX];
	int last,n,i,j,k,temp,count=1;
	scanf("%d",&n);
	for(i=0;i<n;i++){
		scanf("%d %d",&meet[i].beg,&meet[i].end);
		meet[i].num=i+1;
	}
	//对会议结束时间进行排序 
	for(i=0;i<n;i++){
		k=i;
		for(j=i+1;j<n;j++){
			if(meet[j].end<meet[k].end){
				k=j;
			}
		}
		temp=meet[i].beg;
		meet[i].beg=meet[k].beg;
		meet[k].beg=temp;
		temp=meet[i].end;
		meet[i].end=meet[k].end;
		meet[k].end=temp;
		temp=meet[i].num;
		meet[i].num=meet[k].num;
		meet[k].num=temp;
	}
	//输出排序号的时间
	printf("会议的排序时间如下：\n");
	printf("  会议编号   开始时间   结束时间\n");
	for(i=0;i<n;i++){
		printf("  %d   %d   %d\n",meet[i].num,meet[i].beg,meet[i].end);
	} 
	printf("所选择的会议过程\n");
	last=meet[0].end;
	printf("  选择第%d个会议\n",meet[0].num); 
	for(i=0;i<n;i++){
		if(meet[i].beg>=last){
			count++;
			last=meet[i].end;
			printf("  选择第%d个会议\n",meet[i].num);
		}
	}
	printf("总共可选择%d个会议",count);
	return 0;
}
