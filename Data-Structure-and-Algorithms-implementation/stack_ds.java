/*********************************** Stack using array  *************************/
public class stack_ds {
    private  int Top;
    private final int Max;
    int[] arr;
    public stack_ds(int s){
        Top=-1;
        Max=s;
        arr=new int[Max];
    }
    public void Push(int value){
        arr[++Top]=value;
    }
    public int Pop(){
        return arr[Top--];
    }
    public int Peek(){
        return arr[Top];
    }
    public boolean isEmpty(){
        return (Top==-1);
    }
    public boolean isFull(){
        return (Top==Max-1);
    }
    public static void main(String[] args){
        stack stack=new stack(10);
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        stack.Push(4);
        stack.Push(5);
        stack.Push(6);
        stack.Push(7);
        stack.Push(8);
        stack.Push(9);
        stack.Push(10);
        while (!stack.isEmpty()){
            int value=stack.Pop();
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
