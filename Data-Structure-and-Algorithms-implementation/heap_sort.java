import java.util.Arrays;

/***********************************  Heap Sort  *************************************/
public class heap_sort {
    public static void main(String[] args){
        int []list=new int []{7,2,4,9,6,3,8,10,1,5};
        HeapSort(list,list.length);
        System.out.print(Arrays.toString(list));
    }
    private static void Heapify(int[] array,int size,int i){
        int L = 2 * i + 1;
        int R = 2 * i + 2;
        int Max =i;
        if(L < size && array[L] > array[Max] ) Max = L;
        if(R < size && array[R] > array[Max] ) Max = R;
        if(Max !=i){
            int temp = array[i];
            array[i]=array[Max];
            array[Max]=temp;
            Heapify(array,size,Max);
        }
    }
    private static void buildHeap(int[] array,int size){
        for (int i = size / 2 - 1 ; i >= 0 ; i--){
            Heapify(array ,size ,i);
        }
    }
    private static void HeapSort(int[] array,int size){
        buildHeap(array,size);
        for(int i = size -1  ; i >= 0 ; i--){
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            Heapify(array,i , 0);
        }
    }
}
