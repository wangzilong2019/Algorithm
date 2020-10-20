package bit.algorithm.sort;

public class JZ35InversePairs {
    int cnt = 0;
    public int InversePairs(int [] array) {
        mergeSort(array);
        return cnt;
    }

    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        //当区间只有一个元素时返回
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        //分别排序左右区间
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        //合并
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        //创建一个临时数组
        int[] temp = new int[r - mid + 1];
        int i = l;
        int j = mid + 1;
        int idx = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
                cnt = (cnt + mid - i + 1) % 1000000007;
            }
        }

        while (i <= mid) {
            temp[idx++] = arr[i++];
        }
        while (j <= r) {
            temp[idx++] = arr[j++];
        }

        int k ;
        for (k = 0, i = l; i <= r; i++, k++) {
            arr[i] = temp[k];
        }
    }
}
