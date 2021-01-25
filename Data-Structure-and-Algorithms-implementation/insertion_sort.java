import java.util.Arrays;

/********************************* Insertion Sort ******************************/
public class insertion_sort {
    public static void main(String[]args){
        int []list=new int []{7,2,4,9,6,3,8,1,5};
        int i, j, temp,Key;
        for (i=1;i<list.length;i++){
            Key=list[i];
            j=i-1;
            while (j>=0&&Key<list[j]){
                temp=list[j];
                list[j]=list[j+1];
                list[j+1]=temp;
                j--;
            }
        }
        System.out.print(Arrays.toString(list));
    }
}