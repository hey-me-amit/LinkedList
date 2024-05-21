import java.util.*;


public class Solution {
    private static Node<Integer> mergeSortLL(Node<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> mid = findMiddle(head);
        Node<Integer> half1 = head;
        Node<Integer> half2 = mid.next;
        mid.next = null;

        half1 = mergeSortLL(half1);
        half2 = mergeSortLL(half2);

        Node<Integer> finalHead = merge(half1,half2);
        return finalHead;

    }

    private static Node<Integer> findMiddle(Node<Integer> head) {
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node<Integer> merge(Node<Integer> head1,Node<Integer> head2){
        if(head1 == null){
            return head1;
        }
        if(head2 == null){
            return head2;
        }
        Node<Integer> newHead = null,newTail = null;
        if(head1.data<head2.data){
            newHead = head1;
            newTail = head1;
            head1 = head1.next;
        }else{
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                newTail.next = head1;
                newTail = newTail.next;
                head1 = head1.next;
            }else{
                newTail.next = head2;
                newTail = newTail.next;
                head2 = head2.next;
            }
        }
        if(head1!=null){
            newTail.next = head1;
        }
        if(head2!=null){
            newTail.next = head2;
        }
        return newHead;
    }
    public static void printLL(Node<Integer> head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while(data!=-1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void main(String[] args) {
//        Node<Integer> head1 = takeInput();
//        Node<Integer> head2 = takeInput();
//        Node<Integer> head3 = merge(head1,head2);
//        printLL(head3);
        Node<Integer> head = takeInput();
        Node<Integer> sortedHead = mergeSortLL(head);
        printLL(sortedHead);

    }
}
