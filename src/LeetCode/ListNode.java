package LeetCode;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {

     }
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
     }

     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("[");
         sb.append(this.val);
         ListNode hop;
         hop = this.next;
         while(hop != null) {
             //System.out.println(hop.val);
             sb.append(", ").append(hop.val);
             hop = hop.next;
         }
         sb.append("]");
         return sb.toString();
     }
}
