
public class Solution
{
//    public static class ListNode
//    {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t = new ListNode(0);
        ListNode d = t;
        int rest = 0;
        while (l1 != null || l2 != null || rest != 0)
        {
            int sum = rest;

            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            d.next = new ListNode(sum % 10);
            rest = sum / 10;
            d = d.next;
        }
        return t.next;
    }

    public static void printList(ListNode node)
    {
        while(node != null)
        {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

        public static void main(String[] args)
        {
            Solution solution = new Solution();
            ListNode l1_1 = new ListNode(2, new ListNode(4, new ListNode(3)));
            ListNode l2_1 = new ListNode(5, new ListNode(6, new ListNode(4)));
            ListNode result_1 = solution.addTwoNumbers(l1_1, l2_1);

            System.out.print("Example 1: ");
            printList(l1_1);
            System.out.print(" + ");
            printList(l2_1);
            System.out.print(" = ");
            printList(result_1);

            // Example 2: Addition with carry-over
            ListNode l1_2 = new ListNode(9, new ListNode(9, null));
            ListNode l2_2 = new ListNode(1, null);
            ListNode result_2 = solution.addTwoNumbers(l1_2, l2_2);
            System.out.print("Example 2: ");
            printList(l1_2);
            System.out.print(" + ");
            printList(l2_2);
            System.out.print(" = ");
            printList(result_2);
            System.out.println();

            // Example 3: Lists with different lengths
            ListNode l1_3 = new ListNode(1, null);
            ListNode l2_3 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
            ListNode result_3 = solution.addTwoNumbers(l1_3, l2_3);
            System.out.print("Example 3: ");
            printList(l1_3);
            System.out.print(" + ");
            printList(l2_3);
            System.out.print(" = ");
            printList(result_3);
            System.out.println();

        }
}
