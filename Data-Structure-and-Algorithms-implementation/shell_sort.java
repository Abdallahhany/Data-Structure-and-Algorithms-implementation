import java.util.Arrays;

/*********************************** Shell Sort **************************************/
public class shell_sort {
    public static void main(String[] args){
        int []list=new int []{7,2,4,9,6,3,8,10,1,5};
        ShellSort(list,list.length);
        System.out.println(Arrays.toString(list));
    }
    public static void ShellSort(int[]arr,int n){
        for(int gap=n/2;gap>=1;gap/=2){
            for (int j=gap;j<n;j++){
                for(int i=j-gap;i>=0;i -=gap){
                    if(arr[i]>arr[i+gap]){
                        int temp=arr[i];
                        arr[i]=arr[i+gap];
                        arr[i+gap]=temp;
                    }
                }
            }
        }
    }
}
