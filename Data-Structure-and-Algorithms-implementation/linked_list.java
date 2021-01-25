/*********************************** Linked List **********************************/

public class linked_list {
    LinkedList.Node head;
    static class Node{
        int data;
        LinkedList.Node Next;
        Node(int d){
            this.data=d;
            Next=null;
        }
    }
    LinkedList.Node reverse(LinkedList.Node node) {
        LinkedList.Node prev = null;
        LinkedList.Node current = node;
        LinkedList.Node next = null;
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
        LinkedList.Node newNode=new LinkedList.Node(data);
        newNode.Next=null;
        if (list.head==null){
            list.head=newNode;
            newNode.Next=null;
        }else{
            LinkedList.Node last=list.head;
            while (last.Next !=null){
                last=last.Next;
            }
            last.Next=newNode;
        }
        return list;
    }
    public static void printList(LinkedList list){
        int count=0;
        LinkedList.Node currentNode=list.head;
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
        LinkedList.Node currentNode = list.head ,prev=null;
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
