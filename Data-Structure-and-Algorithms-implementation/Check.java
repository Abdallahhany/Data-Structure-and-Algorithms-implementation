import java.util.Arrays;
import static java.lang.System.exit;
import java.util.Stack;

/**************************** 12 - Arithmetic Expression  ***************************/
class EvaluateString {
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i] == ' ') continue;
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Integer.parseInt(sbuf.toString()));
                i--;
            }
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    return 0;
                return a / b;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        System.out.println(EvaluateString.
                evaluate("10 + 2 * 6"));
        System.out.println(EvaluateString.
                evaluate("100 * 2 + 12"));
        System.out.println(EvaluateString.
                evaluate("100 * ( 2 + 12 )"));
        System.out.println(EvaluateString.
                evaluate("100 * ( 2 + 12 ) / 14"));
    }
}

/*********************** 11 implementation stack using linked list ******************/
class StackUsingLinkedlist {
    private class Node {

        int data;
        Node link;
    }
    Node top;
    StackUsingLinkedlist()
    {
        this.top = null;
    }
    public void push(int x) {
        Node temp = new Node();
        if (temp == null) {
            System.out.print("\nStack is full");
            return;
        }
        temp.data = x;
        temp.link = top;
        top = temp;
    }
    public boolean isEmpty()
    {
        return top == null;
    }
    public int peek() {
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    public void pop() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
        top = top.link;
    }

    public void display()
    {
        if (top == null) {
            System.out.print("\nStack Underflow");
            exit(1);
        }
        else {
            Node temp = top;
            while (temp != null) {
                System.out.printf("%d->", temp.data);
                temp = temp.link;
            }
        }
    }
}
class SUL {
    public static void main(String[] args)
    {
        StackUsingLinkedlist obj = new StackUsingLinkedlist();
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
        obj.display();
        System.out.printf("\nTop element is %d\n", obj.peek());
        obj.pop();
        obj.pop();
        obj.display();
        System.out.printf("\nTop element is %d\n", obj.peek());
    }
}

/*********************** 9- doubly ended linked list ********************************/
class Link
{
    public double dData;
    public Link next;
    public Link(double d)
    { dData = d; }

    public void displayLink()
    { System.out.print(dData + " "); }

}

class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(double dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(double dd) {
        Link newLink = new Link(dd);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public void deleteFirst() {
        double temp = first.dData;
        if (first.next == null)
            last = null;
        first = first.next;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class FirstLastApp {
    public static void main(String[] args)
    {
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList();
        theList.deleteFirst();
        theList.deleteFirst();
        theList.displayList();
    }
}

/******************************* 4- MaxElement ***************************************/
class MaxElement{
    public static int getMaxValue(int[] Array){
        int maxValue = Array[0];
        for(int i=1;i < Array.length;i++){
            if(Array[i] > maxValue){
                maxValue = Array[i];
            }
        }
        return maxValue;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{5,6,2,0,1,7,9};
        System.out.println(getMaxValue(arr));
    }
}

/****************************** 3- Linear Search *************************************/
class LinearSearch{
    public static int search(int[] arr, int x)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = { 2, 3, 4, 10, 40 };
        int x = 40;
        if (search(arr, x) == -1)
            System.out.print("Element is not in array");
        else
            System.out.print("Element is at index " + search(arr, x));
    }
}

/************************ 2- Handle input data in simple array ***********************/
class SimpleArray {
    private static int[] arr;
    private static int nElems;
    SimpleArray(int size){
        arr = new int[size];
        nElems = 0;
    }
    public static void main(String[] arg) {
        new SimpleArray(100);
        arr[0] = 53;
        arr[1] = 5;
        arr[2] = 34;
        arr[3] = 68;
        arr[4] = 45;
        arr[5] = 35;
        arr[6] = 22;
        arr[7] = 0;
        arr[8] = 24;
        arr[9] = 35;
        arr[10] = 20;
        nElems = 11;
        display();
        Search(50);
        Delete(20);
        display();
    }

    public static void display() {
        // display items from array
        int j;
        for (j = 0; j < nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println();
    }

    public static void Search(int searchKey) {
        // Search about item
        int j;
        for (j = 0; j < nElems; j++)
            if (arr[j] == searchKey)
                break;
        if (j == nElems)
            System.out.println("Can't find " + searchKey);
        else
            System.out.println("Found " + searchKey);
    }

    public static void Delete(int deleteKey) {
        // delete item from array
        int j;
        for (j = 0; j < nElems; j++)
            if (arr[j] == deleteKey)
                break;
        for (int k = j; k < nElems; k++)
            arr[k] = arr[k + 1];
        nElems--;
    }
}

/*********************************** 8- Linked List **********************************/
class LinkedList{
    Node head;
    static class Node{
        int data;
        Node Next;
        Node(int d){
            this.data=d;
            Next=null;
        }
    }
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.Next;
            current.Next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    public static LinkedList insert(LinkedList list,int data){
        Node newNode=new Node(data);
        newNode.Next=null;
        if (list.head==null){
            list.head=newNode;
            newNode.Next=null;
        }else{
            Node last=list.head;
            while (last.Next !=null){
                last=last.Next;
            }
            last.Next=newNode;
        }
        return list;
    }
    public static void printList(LinkedList list){
        int count=0;
        Node currentNode=list.head;
        System.out.println("LinkedList: ");
        while (currentNode !=null){
            System.out.print(currentNode.data+" ");
            currentNode=currentNode.Next;
            count++;
        }
        System.out.println();
        System.out.println(count);
    }
    public static LinkedList deleteByKey(LinkedList list,int Key){
        Node currentNode = list.head ,prev=null;
        if(currentNode !=null&&currentNode.data==Key){
            list.head=currentNode.Next;
            System.out.println(Key + " found and deleted");
            return list;
        }
        while (currentNode !=null&&currentNode.data !=Key){
            prev=currentNode;
            currentNode=currentNode.Next;
        }
        if(currentNode !=null){
            prev.Next=currentNode.Next;
            System.out.println(Key + " found and deleted");
        }
        if (currentNode == null) {
            System.out.println(Key + " not found");
        }
        return list;
    }
    public static void main(String[] args){
        LinkedList list=new LinkedList();
        insert(list, 1);//insert in the beginning
        insert(list,2);
        insert(list,3);
        insert(list,4);
        insert(list,5);
        insert(list,6);
        insert(list,7);
        insert(list,8);//insert at the end
        printList(list);//print items in linked list and number of nodes
        list.head= list.reverse(list.head);//reverse
        printList(list);
    }
}

/*********************************** 13- circular Queue ******************************/
class Queue{
    private int Max;
    private int Arr[];
    private int nElments;
    private int Rear;
    private int Front;
    public Queue(int M){
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

/***********************************  10- Stack using array  *************************/
class stack{
    private  int Top;
    private final int Max;
    int[] arr;
    public stack(int s){
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
/********************************* 16- Reverse string using stack  *******************/
class Main
{
    public static void reverse(StringBuffer str)
    {
        int n = str.length();
        stack obj = new stack(n);

        int i;
        for (i = 0; i < n; i++)
            obj.Push(str.charAt(i));
        for (i = 0; i < n; i++)
        {
            char ch = (char) obj.Pop();
            str.setCharAt(i,ch);
        }
    }

    public static void main(String args[])
    {
        StringBuffer s= new StringBuffer("ABDALLAH");
        reverse(s);
        System.out.println("Reversed string is " + s);
    }
}
/*********************************** Shell Sort **************************************/
class shellSort{
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

/***********************************  Heap Sort  *************************************/
class HeapSorting{
    public static void main(String[] args){
        int []list=new int []{7,2,4,9,6,3,8,10,1,5};
        HeapSort(list,list.length);
        Print(list,list.length);
    }
    private static void Swap(int index1,int index2){
        int temp=index1;
        index1=index2;
        index2=temp;
    }
    private static void Heapify(int[] array,int size,int i){
        int L = 2 * i + 1;
        int R = 2 * i + 2;
        int Max =i;
        if(L < size && array[L] > array[Max] ) Max = L;
        if(R < size && array[R] > array[Max] ) Max = R;
        if(array[Max] !=array[i]){
            Swap(array[i],array[Max]);
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
            Swap(array[0],array[i]);
            Heapify(array,i , 0);
        }
    }
    private static void Print(int[] array,int size){
        for (int i = 0; i <= size ; i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
}

/********************* merging two arrays into third on ******************************/
class MergingTwoArrays{
    public static void main(String[]args){
        int[] arrayA={23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[10];
        MergeSort(arrayA,arrayA.length,arrayB,arrayB.length,arrayC);
        display(arrayC,arrayC.length);
    }
    private static void MergeSort(int[] arrayA,int lengthA,int[] arrayB,int lengthB,int[] arrayC){
        int A=0,B=0,C=0;
        while (A<lengthA&&B<lengthB){
            if(arrayA[A]<arrayB[B]){
                arrayC[C++]=arrayA[A++];// op++ (perform the operation then increment to the next place)
            }else{
                arrayC[C++]=arrayB[B++];
            }
            while (A<lengthA){//Array B is Empty
                arrayC[C++]=arrayA[A++];
            }
            while (B<lengthB){//Array A is Empty
                arrayC[C++]=arrayB[B++];
            }
        }
    }
    private static void display(int []array,int length){
        for (int i=0;i<length;i++){
            System.out.println(array[i]);
        }
    }
}

/********************************* merge Sort ****************************************/
class MergeSort {
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

/********************************* 5- b- Insertion Sort ******************************/
class InsertionSort {
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

/********************************* 5- a- Bubble Sort *********************************/
class BubbleSort {
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

/********************************* 5- c- Selection Sort ******************************/
class selectionSort {
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