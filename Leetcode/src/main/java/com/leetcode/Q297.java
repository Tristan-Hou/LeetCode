package com.leetcode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q297 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = s(root, "");
        return res.substring(0, res.length()-1);
    }

    private String s(TreeNode root, String str) {
        if(root == null) {
            str += "None,";
        } else {
            str += String.valueOf(root.val) + ",";
            str += s(root.left, str);
            str += s(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(data_array));
        return d(list);
    }

    private TreeNode d(List<String> list) {
        if(list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = d(list);
        root.right = d(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



