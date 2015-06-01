public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass())
            return false;
        else {
            if(this.next == null && ((ListNode) obj).next == null)
                return this.val == ((ListNode) obj).val;
            else
                return this.val == ((ListNode) obj).val && this.next.equals(((ListNode) obj).next);
        }
    }
}

