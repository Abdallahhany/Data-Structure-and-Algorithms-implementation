/*********************** doubly ended linked list ********************************/

public class doubly_ended_linked_list {
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
class link
{
    public double dData;
    public Link next;
    public link(double d)
    { dData = d; }

    public void displayLink()
    { System.out.print(dData + " "); }

}

class firstLastList {
    private Link first;
    private Link last;

    public firstLastList() {
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
