
class ListNode {
     int val;
     ListNode next;

     ListNode(int val) {
          this.val = val;
          this.next = null;
     }
}

class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode l3 = new ListNode(0);
          ListNode current = l3;
          int carry = 0;
          while (l1 != null && l2 != null) {
               int value = (l1.val + l2.val + carry) % 10;
               l3.next = new ListNode(value);
               carry = ((l1.val + l2.val + carry) / 10);
               l3 = l3.next;
               l1 = l1.next;
               l2 = l2.next;
          }

          while (l1 != null) {
               int value = (l1.val + carry) % 10;
               l3.next = new ListNode(value);
               carry = ((l1.val + carry) / 10);
               l3 = l3.next;
               l1 = l1.next;
          }
          while (l2 != null) {
               int value = (l2.val + carry) % 10;
               l3.next = new ListNode(value);
               carry = (l2.val + carry) / 10;
               l3 = l3.next;
               l2 = l2.next;
          }
          while (carry > 0) {
               l3.next = new ListNode(carry % 10);
               carry = carry / 10;
               l3 = l3.next;
          }
          return current.next;

     }
}