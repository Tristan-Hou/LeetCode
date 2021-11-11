package com.leetcode;

public class Main {
    public static void main(String[] args) {
//        doQ33();
//        doQ300();
//        doQ695();
//        doQ1160();
//        doM40();
//        doM289();
//        doQ13();
//        doQ151();
//        doQ23();
//        doQ200();
//        doQ1248();
//        doQ45();
//        doQ30();
//        doQ221();
//        doTest();
//        doQ29();
//        doQ739();
//        doQ42();
//        Q297();
//        Q394();
//        Q125();
//        Q785();
//        Q97();
//        Q0803();
//        sortTest();
//        Q304();
//        Q331();
//        Q54();
//        Q47();
//        Q190();
//        Q74();
//        Q7();
//        Q1006();
//        Q80();
//        Q81();
//        Q85();
//        Q224();
//        Q316();
//        Q215();
//        Q234();
//        Q179();
//        Q334();
//        code12();
//        offer19();
//        offer21();
        offer25();
    }

    private static void doQ33() {
        /*int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;*/
        /*int[] nums = new int[]{1,3};
        int target = 0;*/
        /*int[] nums = new int[]{3,1};
        int target = 0;*/
        int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        int target = 8;
        Q33 q33 = new Q33();
        int result = q33.search(nums, target);
        System.out.println("LeetCode NO.33 : ");
        System.out.println(result);
    }

    private static void doQ300() {
        int[] nums = new int[]{-2, -1};
        Q300 q300 = new Q300();
        q300.lengthOfLIS(nums);
    }

    private static void doQ695() {
        int[][] nums = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        new Q695().maxAreaOfIsland(nums);
    }

    private static void doQ1160() {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        Q1160 q1160 = new Q1160();
        q1160.countCharacters(words, chars);
    }

    private static void doM40() {
        int[] arr = new int[]{0, 1, 2, 1};
        int k = 1;
        M40 m40 = new M40();
        m40.getLeastNumbers(arr, k);
    }

    private static void doM289() {
        int[][] arr = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        Q289 m40 = new Q289();
        m40.gameOfLife(arr);
    }

    private static void doQ13() {
        Q13 m40 = new Q13();
        m40.movingCount(1, 2, 1);
    }

    private static void doQ151() {
        String s = "the sky is blue";
        Q151 m4151 = new Q151();
        m4151.reverseWords(s);
    }

    private static void doQ23() {
        int[][] lists = new int[][]{{-3, 2, 2},
                {-9},
                {-10, -5, -4, -2, -1, 1, 3, 4},
                {-10, -9, -8, 3, 4},
                {-5, -3, 3, 4},
                {-9, -8, -5, -4, -2, -1, 3}};
        Q23.ListNode[] data = new Q23.ListNode[lists.length];
        for (int index = 0; index < lists.length; index++) {
            int[] list = lists[index];
            Q23.ListNode head = new Q23.ListNode(0);
            Q23.ListNode p = head;
            for (int i : list) {
                if (i != 0) {
                    Q23.ListNode node = new Q23.ListNode(i);
                    p.next = node;
                    p = node;
                }
            }
            p = head.next;
            if (p != null) {
                data[index] = p;
            }
        }

        Q23 q23 = new Q23();
        q23.mergeKLists(data);
    }

    private static void doQ200() {
        char[][] grid = new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        Q200 q200 = new Q200();
        q200.numIslands(grid);
    }

    private static void doQ1248() {
        int[] grid = new int[]{1,1,2,1,2,2};
        Q1248 q1248 = new Q1248();
        q1248.numberOfSubarrays(grid, 3);
    }

    private static void doQ45() {
        int[] grid = new int[]{1,1,3};
        Q45 q45 = new Q45();
        q45.jump(grid);
    }
    private static void doQ30() {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Q30 q30 = new Q30();
        q30.findSubstring(s, words);
    }

    private static void doQ221() {
        char[][] grid = new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
//        char[][] grid = new char[][]{{'1'}};
        Q221 q221 = new Q221();
        q221.maximalSquare(grid);
    }

    private static void doTest() {
        int[][] grid = new int[][]{{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        Test test = new Test();
        test.test(grid);
    }

    private static void doQ29() {
        int[][] grid = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        Q29 test = new Q29();
        test.spiralOrder(grid);
    }

    private static void doQ739() {
        int[] grid = new int[]{73,74,75,71,69,72,76,73};
        Q739 test = new Q739();
        test.dailyTemperatures(grid);
    }

    private static void doQ42() {
        int[] grid = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        Q42 test = new Q42();
        test.trap(grid);
    }

    private static void Q297() {
        String grid = "1,2,3,None,None,4,5";
        Q297 test = new Q297();
        test.deserialize(grid);
    }

    private static void Q394() {
//        String grid = "3[a]2[bc]";
//        String grid = "3[a2[c]]";
//        String grid = "2[abc]3[cd]ef";
        String grid = "100[leetcode]";
        Q394 test = new Q394();
        test.decodeString(grid);
    }

    private static void Q125() {
//        String grid = "Ac";
//        String grid = "A man, a plan, a canal: Panama";
//        String grid = "AcA";
        String grid = ".,";
        Q125 test = new Q125();
        test.isPalindrome(grid);
    }

    private static void Q785() {
//        int[][] grid = new int[][]{{1,3}, {0,2}, {1,3},{0,2}};
        int[][] grid = new int[][]{{3}, {2,4}, {1},{0,4},{1,3}};
        Q785 test = new Q785();
        test.isBipartite(grid);
    }

    private static void Q97() {
//        int[][] grid = new int[][]{{1,3}, {0,2}, {1,3},{0,2}};
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Q97 test = new Q97();
        test.isInterleave(s1, s2, s3);
    }

    private static void Q0803() {
//        int[] a = new int[]{0, 2, 3, 4, 5};
        int[] a = new int[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        Q0803 test = new Q0803();
        test.findMagicIndex(a);
    }

    private static void sortTest() {
        SortTest sortTest = new SortTest();
        sortTest.test();
    }

    private static void Q304() {
//        int[] a = new int[]{0, 2, 3, 4, 5};
        int[][] a = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        Q304 test = new Q304(a);
        test.sumRegion(2, 1, 4, 3);
    }

    private static void Q331() {
String a = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Q331 test = new Q331();
        test.isValidSerialization(a);
    }

    private static void Q54() {
//        int[][] a = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        int[][] a = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] a = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        Q54 test = new Q54();
        test.spiralOrder(a);
    }

    private static void Q47() {
//        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums = new int[]{1, 1, 3};
        Q47 test = new Q47();
        test.permuteUnique(nums);
    }

    private static void Q190() {
        int i = 0b10000000000000000000000000000000;
        Q190 test = new Q190();
        test.reverseBits(i);
    }

    private static void Q74() {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};  // 3
//        int[][] matrix = {{1,3}}; // 2
//        int[][] matrix = {{1},{3}}; // 2
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};  // 5
        Q74 test = new Q74();
        test.searchMatrix(matrix, 5);
    }

    private static void Q7() {
        Q7 test = new Q7();
        test.reverse(120);
    }

    private static void Q1006() {
        Q1006 test = new Q1006();
        test.clumsy(10);
    }

    private static void Q80() {
        int[] a = new int[]{1,1,1,1,1,1,1,2,2,3,4,4,4,4,4};
        Q80 test = new Q80();
        test.removeDuplicates(a);
    }

    private static void Q81() {
//        int[] a = new int[]{1,1,1,1,1,1,1,2,2,3,4,4,4,4,4};
//        int[] a = new int[]{2,5,6,0,0,1,2};
//        int[] a = new int[]{2,5,6,0,0,1,2};
        int[] a = new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        Q81 test = new Q81();
        test.search(a, 13);
    }

    private static void Q85() {
//        int[] a = new int[]{1,1,1,1,1,1,1,2,2,3,4,4,4,4,4};
//        int[] a = new int[]{2,5,6,0,0,1,2};
//        int[] a = new int[]{2,5,6,0,0,1,2};
        char[][] a = {{'1','0'},{'1','0'}};
        Q85 test = new Q85();
        test.maximalRectangle(a);
    }

    private static void Q224() {
String a = "(1+(4+5+2)-3)+(6+8)";
        Q224 test = new Q224();
        test.calculate(a);
    }

    private static void Q316() {
//        String a = "czbacdcbc";
        String a = "bddbccd";
        Q316 test = new Q316();
        test.removeDuplicateLetters(a);
    }

    private static void Q215() {
        int[] a = new int[]{3,1,2,4};
        Q215 test = new Q215();
        test.findKthLargest(a, 2);
    }

    private static void Q234() {
        Q234 test = new Q234();
        test.test();
    }

    private static void Q179() {
        Q179 test = new Q179();
//        int[] a = new int[]{10,2,9,39,17};
        int[] a = new int[]{0,0};
        test.largestNumber(a);
    }

    private static void Q334() {
        Q334 test = new Q334();
        int[] a = new int[]{20,100,10,12};
        test.increasingTriplet(a);
    }

    private static void code12() {
        code12 test = new code12();
        char[][] a = new char[][]{{'a','a'}};
        test.exist(a, "aaa");
    }

    private static void offer19() {
        offer19 test = new offer19();
        char[][] a = new char[][]{{'a','a'}};
        test.isMatch("ab", ".*");
    }

    private static void offer21() {
        offer21 test = new offer21();
        int[] a = new int[]{1,2,3,4};
        test.exchange(a);
    }

    private static void offer25() {
        offer25 test = new offer25();
        /*offer25.ListNode a1 = new offer25.ListNode(1);
        offer25.ListNode a2 = new offer25.ListNode(2);
        offer25.ListNode a4 = new offer25.ListNode(4);
        a1.next = a2;
        a2.next = a4;

        offer25.ListNode b1 = new offer25.ListNode(1);
        offer25.ListNode b3 = new offer25.ListNode(3);
        offer25.ListNode b4 = new offer25.ListNode(4);
        b1.next = b3;
        b3.next = b4;*/

        offer25.ListNode a9 = new offer25.ListNode(-9);
        offer25.ListNode a3 = new offer25.ListNode(3);
        a9.next = a3;

        offer25.ListNode b5 = new offer25.ListNode(5);
        offer25.ListNode b7 = new offer25.ListNode(7);
        b5.next = b7;
        test.mergeTwoLists(a9, b5);
    }
}
