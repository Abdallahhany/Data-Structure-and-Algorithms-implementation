import java.util.Arrays;

/********************************* Bubble Sort *********************************/
public class bubble_sort {
    public static void main(String[]args){
        int []list=new int []{7,2,4,9,6,3,8,1,5};
        int i, j, temp;
        for(i=0;i<list.length-1;i++){
            for(j=0;j<list.length-1-i;j++){
                if(list[j]>list[j+1]){
                    temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(list));
    }
}
