package com.blankj.easy._071;

import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a/b/c/"));
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        if (path == null || path == "") {
            return "";
        }
        String[] dirs = path.split("/");
        LinkedList<String> simplifyDirs = new LinkedList<>();
        for (String dir : dirs) {
            if ("..".equals(dir)) {
                if (!simplifyDirs.isEmpty()) {
                    simplifyDirs.removeLast();
                }
            } else if (!"".equals(dir) && !".".equals(dir)) {
                simplifyDirs.add(dir);
            }
        }
        StringBuilder res = new StringBuilder("");
        for (String dir : simplifyDirs) {
            res.append("/");
            res.append(dir);
        }

        return res.toString();
    }
}
