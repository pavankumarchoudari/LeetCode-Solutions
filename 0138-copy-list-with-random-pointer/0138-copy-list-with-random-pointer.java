/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         Node temp=head;
        while(temp!=null){
            Node copynode = new Node(temp.val);
            copynode.next=temp.next;
            temp.next= copynode;
            temp=temp.next.next;
        }
        temp=head;
     while(temp!=null){
       Node  copynode=temp.next;
        if(temp.random!=null){
            copynode.random=temp.random.next;
        }
        temp=temp.next.next;
     }
     Node dummynode=new Node(-1);
     Node res=dummynode;
      Node tem=head;
      while(tem!=null){
        res.next=tem.next;
        tem.next=tem.next.next;
        res=res.next;
        tem=tem.next;


      }
      return dummynode.next;
        
    }
}