import java.util.HashMap;
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


class CopyListWithRandomPointer {

    HashMap <Node,Node> visited = new HashMap <> ();

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null; 
        }

        if(this.visited.containsKey(head)) {  //check if node is already visited
            return this.visited.get(head);    //if already visited return the same copied node in hashmap instead of creating a new one
        }

        Node node = new Node(head.val, null, null);
        this.visited.put(head,node);
        node.next = copyRandomList(head.next);   //return's a copy of head's next
        node.random = copyRandomList(head.random);  //return's a copy of head's random

        return node;  //returning next node as head
    }
}