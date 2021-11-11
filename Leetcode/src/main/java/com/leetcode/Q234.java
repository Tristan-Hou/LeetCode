package com.leetcode;

class Q234 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public void test() {
      ListNode a = new ListNode(1);
      ListNode b = new ListNode(2);
      a.next = b;
      isPalindrome(a);
  }
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        ListNode head2 = reverseList(second);

        ListNode l1 = head;
        ListNode l2 = head2;
        while(l1 != null && l2 != null) {
            if(l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null) {
            fast = fast.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
