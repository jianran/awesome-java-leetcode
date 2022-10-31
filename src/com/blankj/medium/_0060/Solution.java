package com.blankj.medium._060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permutationSequence(4, 9));
    }

    public String permutationSequence(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }

        List<String> elements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            elements.add(String.valueOf(i));
        }
        List<String> res = dfsPermutation(elements);
        if (k > res.size()) {
            throw new IllegalArgumentException("k is bigger than permutation list size");
        }

        return res.get(k);
    }

    public List<String> dfsPermutation(List<String> elements) {
        List<String> res = new ArrayList<>();
        if (elements.size() == 1) {
            res.add(elements.get(0));
        } else {
            for (String e : elements) {
                List<String> left = new ArrayList<>();
                for (String l : elements) {
                    if (l != e) {
                        left.add(l);
                    }
                }
                List<String> subsequences = dfsPermutation(left);
                for (String sub : subsequences) {
                    res.add(e + sub);
                }
            }
        }

        return res;
    }


}
