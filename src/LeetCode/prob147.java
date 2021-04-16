package LeetCode;

public class prob147 {
    public static ListNode insertionSortList(ListNode head) {
        //size = 1
        if (head.next == null) {
            return head;
        }
        //size = 2
        if (head.next.next == null) {
            if (head.val > head.next.val) {
                return new ListNode(head.next.val, new ListNode(head.val));
            } else {
                return head;
            }
        }
        //size = 3+
        ListNode select = head.next; //this needs to be less than...
        ListNode hop = head.next.next; //this
        ListNode next; //the next node, which is going down the list again to mark where select will be
        ListNode out = head;
        //go to the end of the List, this is where we will start
        while(hop.next != null) {
            select = select.next;
            hop = hop.next;
        }
        //1) put it at the end (requires a "deletion")
        //2) insert it
        //3) do nothing
        while(select != head) {
            /*
            4 2 1 3
            4 2 1 3 //nothing
            4 1 2 3 //insert 2, 1, 3
            1 2 3 4 //end 4
            */
            if (select.val > hop.val) {
                if (hop.next == null) {
                    out = end(out, select.val);
                    System.out.println("end: " + select.val);
                } else {
                    out.next = insert(select, hop, hop.next);
                    System.out.println("insert " + select.val + ", " + hop.val + ", " + hop.next.val);
                }
            }
            //move up
            next = head;
            while(next.next != null && next.next != select) {
                next = next.next;
            }
            select = next;
            hop = next.next;
            System.out.println(out);
        }
        //the last value is not counted in the loop, so put it at the end
        //(because the rest of the list is sorted at this point)
        if (select.val > hop.val) {
            out = end(out, select.val);
        }
        return out;
    }

    public static ListNode insert(ListNode i, ListNode a, ListNode b) {
        //return a List of size 3 that has i inserted between a and b (a, i, b)
        i.next = b;
        return new ListNode(a.val, i);
    }
    public static ListNode end(ListNode head, int i) {
        //given a whole List of size 3+, put element i at the end of it
        ListNode move = head; //the element that needs to be moved
        ListNode a = head;
        ListNode b = null;
        //connect a to b before moving move to the end
        while(a.next.next != null) {
            if(a.val == i) {
                b = a.next;
                move = a;
                move.next = null;
                a = null;
                break;
            }
            if(a.next.val == i) {
                b = a.next.next;
                move = a.next;
                move.next = null;
                break;
            }
            a = a.next;
        }
        if (a == null) {
            ListNode hop = b;
            while (hop.next != null) {
                hop = hop.next;
            }
            hop.next = move;
            return b;
        } else {
            a.next = b;
            ListNode end = head; //the end of the List, where move will be inserted
            while (end.next != null) {
                end = end.next;
            }
            end.next = move;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        System.out.println(l);
        //System.out.println(end(l, 5));
        System.out.println(insertionSortList(l));
    }

    /*
    if(next == head) {
                if(select.val > hop.val) {
        //once we move up, this will not always be true
        if(hop.next == null) {
            select.next = null; //2
            hop.next = select; //1 2
            next.next = hop; //3 1 2
            if (next.val < next.next.val) {
                return next;
            } else { //2 1 3
                next.next = hop.next;
                hop.next = next;
                return hop;
            }
        } else {

        }
    } else {
        if (hop.next == null) {
            next.next = null;
        } else {
            next.next = hop.next;
        }
        hop.next = next;
        return select;
    }
                if(next.val > select.val) {
        next.next = hop;
        select.next = next;
        return select;
    } else {

    }
} else {
        if(select.val > hop.val) {

        }
        }
    */


    /*
    while (select != null) {
            if (select.val > hop.val) {
                if (hop.next == null) {
                    if (prev == null) {
                        select.next = null;
                        hop.next = select;
                        return hop;
                    } else {
                        //2 1 3
                        //2 3
                        //1 2 3
                        select.next = prev.next;
                        prev.next = select;
                        return prev;
                    }
                }
                while (hop.next != null) {
                    prev = hop;
                    hop = hop.next;
                    if (select.val < hop.val) {
                        select.next = hop;
                        prev.next = select;
                        out = prev; //remove?
                    }
                }
            }
        }
     */
}
