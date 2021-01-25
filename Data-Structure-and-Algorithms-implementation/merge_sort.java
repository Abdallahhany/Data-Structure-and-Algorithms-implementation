
/********************************* merge Sort ****************************************/
public class merge_sort {
    public static void main(String[]args){
        int []list=new int []{7,2,4,9,6,3,8,10,1,5};
        mergeSort(list,0,list.length-1);
        for (int j : list) System.out.println(j);
    }
    private static void mergeSort(int[]arr,int b,int e){
        if(b==e)return;
        else{
            int mid=(b+e)/2;
            mergeSort(arr,b,mid);
            mergeSort(arr,mid+1,e);
            merge(arr,b,mid,mid+1,e);
        }
    }
    private static void merge(int[]arr,int arr1B,int arr1E,int arr2B,int arr2E){
        int i, j, k;
        int[] temp=new int[arr.length];
        i=arr1B;
        j=arr2B;
        k=0;
        while (i<=arr1E&&j<=arr2E){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while (i<=arr1E){
            temp[k++]=arr[i++];
        }
        while (j<=arr2E){
            temp[k++]=arr[j++];
        }
        for (i=arr1B,j=0;i<=arr2E;i++,j++){
            arr[i]=temp[j];
        }
    }
}
