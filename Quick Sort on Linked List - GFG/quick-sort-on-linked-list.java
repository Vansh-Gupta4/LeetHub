// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    static Node quickSort(Node node) {
Node last = node;
Node first = node;
while (last.next != null) {
last = last.next;
}

Node h = quickS(first, last);
return h;
}

static Node partition(Node first, Node last) {

Node front = first;
Node pivot = first;
int temp = 0;

while (front != null && front != last) {
if (front.data < last.data) {
pivot = first;
temp = first.data;
first.data = front.data;
front.data = temp;
first = first.next;
}
front = front.next;
}

temp = first.data;
first.data = last.data;
last.data = temp;

return pivot;
}

static Node quickS(Node first, Node last) {

if (first == last) {
return first;
}
Node pivot = partition(first, last);

if (pivot != null && pivot.next != null) {
quickS(pivot.next, last);
}
if (pivot != null && first != pivot) {
quickS(first, pivot);
}
return first;
}
}