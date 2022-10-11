package com.blankj.medium._0102;

import com.blankj.structure.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.levelOrderTraversal(TreeNode.createTestData("[1,9,20,null,null,15,7]")));
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode head) {
        if (head == null) {
            return Collections.emptyList();
        }
        TreeMap<Integer, List<Integer>> levelValuesMap = new TreeMap<>();
        levelValuesMap.put(0, List.of(head.val));
        travelOneTree(head.left, 1, levelValuesMap);
        travelOneTree(head.right, 1, levelValuesMap);
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> value : levelValuesMap.values()) {
            res.add(value);
        }
        return res;
    }

    private void travelOneTree(TreeNode node, int level, Map<Integer, List<Integer>> levelValuesMap) {
        if (node == null) {
            return;
        }
        List<Integer> values = levelValuesMap.get(level);
        if (values == null) {
            values = new ArrayList<>();
            levelValuesMap.put(level, values);
        }
        values.add(node.val);
        travelOneTree(node.left, level + 1, levelValuesMap);
        travelOneTree(node.right, level + 1, levelValuesMap);
    }


}
