// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node l1, Node l2){
        Node reversedL1 = reverse(l1);
        Node reversedL2 = reverse(l2);
        Node head = new Node(0);
        Node current = head;
        int carry = 0;
        while (reversedL1 != null || reversedL2 != null){
            int a = (reversedL1 != null) ? reversedL1.data : 0;
            int b = (reversedL2 != null) ? reversedL2.data: 0;
            int sum = a + b + carry;
            carry = sum / 10;
            int lastDigit = sum % 10;
            current.next = new Node(lastDigit);
            if (reversedL1 != null)
                reversedL1 = reversedL1.next;
            if (reversedL2 != null)
                reversedL2 = reversedL2.next;
            current = current.next;
        }
        if (carry > 0){
            current.next = new Node(carry);
            current = current.next;
        }
        Node finalResult = reverse(head.next);
        return finalResult;
    }
    public static Node reverse(Node head){
       Node prev=null;
       Node curr=head;
       Node n;
       while(curr!=null){
           n=curr.next;
           curr.next=prev;
            prev=curr;
           curr=n;
          
       }
       return prev;
   }
}