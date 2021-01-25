/*********************************** Queue ******************************/

public class queue_ds {
    private int Max;
    private int Arr[];
    private int nElments;
    private int Rear;
    private int Front;
    public queue_ds(int M){
        Max=M;
        Arr=new int[Max];
        nElments=0;
        Front=0;
        Rear=-1;
    }
    public void EnQueue(int Value){
        if (Rear==Max-1)Rear=-1;
        Arr[++Rear]=Value;
        nElments++;
    }
    public int deQueue(){
        int temp=Arr[Front++];
        if(Front==Max)
            Front=0;
        nElments--;
        return temp;
    }
    public int Peek(){
        return Arr[Front];
    }
    public boolean isEmpty(){
        return (nElments==0);
    }
    public boolean isFull(){
        return (nElments==Max);
    }
    public int Size(){
        return nElments;
    }
    public static void main(String[] args){
        Queue queue=new Queue(10);
        queue.EnQueue(1);
        queue.EnQueue(2);
        queue.EnQueue(3);
        queue.EnQueue(4);
        queue.EnQueue(5);
        queue.EnQueue(6);
        queue.EnQueue(7);
        queue.EnQueue(8);
        queue.EnQueue(9);
        queue.EnQueue(10);
        while (!queue.isEmpty()){
            int value=queue.deQueue();
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
