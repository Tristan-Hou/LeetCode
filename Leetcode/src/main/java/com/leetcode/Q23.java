package com.leetcode;

import java.util.Arrays;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        MixPriorityQueue queue = new MixPriorityQueue();
        for (ListNode node : lists) {
            if (node != null) {
                do {
                    queue.enQueue(node);
                    node = node.next;
                } while (node != null);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!queue.isEmpty()) {
            dummy.next = queue.deQueue();
            dummy = dummy.next;
        }
        dummy.next = null;
        return head.next;
    }

    class MixPriorityQueue {
        private ListNode[] queue = new ListNode[32];
        private int index;

        public void enQueue(ListNode node) {
            if (index >= queue.length) {
                resize();
            }
            queue[index++] = node;
            upAdjust();
        }

        public ListNode deQueue() {
            if (index <= 0) {
                return null;
            }
            ListNode node = queue[0];
            queue[0] = queue[--index];
            downAdjust(0, 1);
            return node;
        }

        public boolean isEmpty() {
            return index <= 0 ? true : false;
        }

        private void resize() {
            int newSize = (index << 1);
            this.queue = Arrays.copyOf(this.queue, newSize);
        }

        private void upAdjust() {
            int childIndex = index - 1;
            int parentIndex = ((childIndex - 1) >> 1);
            while (childIndex > 0 && queue[childIndex].val < queue[parentIndex].val) {
                int tmp = queue[childIndex].val;
                queue[childIndex].val = queue[parentIndex].val;
                queue[parentIndex].val = tmp;
                childIndex = parentIndex;
                parentIndex = (parentIndex >> 1);
            }
        }

        private void downAdjust(int p, int c) {
            int parentIndex = p;
            int childIndex = c;
            while (childIndex < index) {
                if (childIndex + 1 < index && queue[childIndex + 1].val == queue[childIndex].val) {
                    downAdjust(childIndex, childIndex * 2 + 1);
                    downAdjust(childIndex + 1, (childIndex + 1) * 2 + 1);
                }
                if (childIndex + 1 < index && queue[childIndex + 1].val < queue[childIndex].val) {
                    childIndex += 1;
                }
                if (queue[parentIndex].val <= queue[childIndex].val) {
                    break;
                }
                int tmp = queue[parentIndex].val;
                queue[parentIndex].val = queue[childIndex].val;
                queue[childIndex].val = tmp;
                parentIndex = childIndex;
                childIndex = (parentIndex << 1) + 1;
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
