import java.util.Arrays;
/********************************* Selection Sort ******************************/
public class selection_sort {
    public static void main(String[]args){
        int []list=new int []{7,2,4,9,6,3,8,1,5};
        int minElement , minvalue,temp;
        for (int i=0;i<list.length;i++){
            minvalue=list[i];
            minElement=i;
            for(int j=i;j< list.length;j++){
                if(list[j]<minvalue){
                    minvalue=list[j];
                    minElement=j;
                }
            }
            if(minvalue<list[i]){
                temp=list[i];
                list[i]=list[minElement];
                list[minElement]=temp;
            }
        }
        System.out.print(Arrays.toString(list));
    }
}
