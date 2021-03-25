package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class prob21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode hop = null;
        ArrayList<Integer> a = new ArrayList<>();
        if (l1 != null) {
            a.add(l1.val);
            hop = l1.next;
            while (hop != null) {
                a.add(hop.val);
                hop = hop.next;
            }
        }
        if (l2 != null) {
            a.add(l2.val);
            hop = l2.next;
            while (hop != null) {
                a.add(hop.val);
                hop = hop.next;
            }
        }
        Collections.sort(a);

        if (a.size() >= 1) {
            output.val = a.get(0);
        }
        if (a.size() > 1) {
            hop = new ListNode(a.get(1));
            output.next = hop;
        }
        if (a.size() > 2) {
            for (int i = 2; i < a.size(); i++) {
                hop.next = new ListNode(a.get(i));
                hop = hop.next;
            }
        }

        /*
        //populate the output List
        if (a1.size() == a2.size() && a1.size() > 0) {
            if (a1.get(0) < a2.get(0)) {
                output.val = a1.get(0);
                hop = new ListNode(a2.get(0));
            } else {
                output.val = a2.get(0);
                hop = new ListNode(a1.get(0));
            }
            output.next = hop;
            for (int i = 1; i < a1.size(); i++) {
                if (a1.get(i) < a2.get(i)) {
                    hop.next = new ListNode(a1.get(i));
                    hop = hop.next;
                    hop.next = new ListNode(a2.get(i));
                } else {
                    hop.next = new ListNode(a2.get(i));
                    hop = hop.next;
                    hop.next = new ListNode(a1.get(i));
                }
                hop = hop.next;
            }
        } else if (a1.size() > a2.size() && a2.size() > 0) {
            if (a1.get(0) < a2.get(0)) {
                output.val = a1.get(0);
                hop = new ListNode(a2.get(0));
            } else {
                output.val = a2.get(0);
                hop = new ListNode(a1.get(0));
            }
            output.next = hop;
            int count = 1;
            for (int i = 1; i < a2.size(); i++) {
                if (a1.get(i) < a2.get(i)) {
                    hop.next = new ListNode(a1.get(i));
                    hop = hop.next;
                    hop.next = new ListNode(a2.get(i));
                } else {
                    hop.next = new ListNode(a2.get(i));
                    hop = hop.next;
                    hop.next = new ListNode(a1.get(i));
                }
                hop = hop.next;
                count++;
            }
            for (int i = count; i < a1.size(); i++) {
                hop.next = new ListNode(a1.get(i));
                hop = hop.next;
            }
        } else {
            if (a1.get(0) < a2.get(0)) {
                output.val = a1.get(0);
                hop = new ListNode(a2.get(0));
            } else {
                output.val = a2.get(0);
                hop = new ListNode(a1.get(0));
            }
            output.next = hop;
            int count = 1;
            for (int i = 1; i < a1.size(); i++) {
                if (a1.get(i) < a2.get(i)) {
                    hop.next = new ListNode(a1.get(i));
                    hop = hop.next;
                    hop.next = new ListNode(a2.get(i));
                } else {
                    hop.next = new ListNode(a2.get(i));
                    hop = hop.next;
                    hop.next = new ListNode(a1.get(i));
                }
                hop = hop.next;
                count++;
            }
            for (int i = count; i < a2.size(); i++) {
                hop.next = new ListNode(a2.get(i));
                hop = hop.next;
            }
        }
        */
        return output;
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        output(mergeTwoLists(l1, l2));
    }

    public static void output(ListNode l) {
        System.out.print("[");
        System.out.print(l.val);
        ListNode hop;
        hop = l.next;
        while(hop != null) {
            System.out.print(", " + hop.val);
            hop = hop.next;
        }
        System.out.println("]");
    }
}
