// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
         // initialise count of 0 1 and 2 as 0
       int count[] = {0, 0, 0};
        
       Node ptr = head;
        
       /* count total number of '0', '1' and '2'
        * count[0] will store total number of '0's
        * count[1] will store total number of '1's
        * count[2] will store total number of '2's  */
       while (ptr != null)
       {
            count[ptr.data]++;
            ptr = ptr.next;
       }
 
       int i = 0;
       ptr = head;
 
       /* Let say count[0] = n1, count[1] = n2 and count[2] = n3
        * now start traversing list from head node,
        * 1) fill the list with 0, till n1 > 0
        * 2) fill the list with 1, till n2 > 0
        * 3) fill the list with 2, till n3 > 0  */
        while (ptr != null)
        {
            if (count[i] == 0)
                i++;
            else
            {
               ptr.data= i;
               --count[i];
               ptr = ptr.next;
            }
         }
         return head;
    }
}


