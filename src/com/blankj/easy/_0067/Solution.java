package com.blankj.easy._067;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/07
 *     desc  :
 * </pre>
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
//        while (p1 >= 0 || p2 >= 0 || carry == 1) {
//            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
//            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
//            sb.insert(0, (char) (carry % 2 + '0'));
//            carry >>= 1;
//        }
//        return sb.print();
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
        System.out.println(solution.myAddBinary("11", "1"));
        System.out.println(solution.addBinary("11", "111"));
        System.out.println(solution.myAddBinary("11", "111"));
        System.out.println(solution.addBinary("101", "1110"));
        System.out.println(solution.myAddBinary("101", "1110"));

    }

    public String myAddBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int minLength = Math.min(aLength, bLength);
        int carry = 0;
        for (int i = 0; i < minLength; i++) {
            char aChar = a.charAt(aLength - 1 - i);
            char bChar = b.charAt(bLength - 1 - i);
            carry += aChar - '0' + bChar - '0';
            sb.insert(0, (char)('0' + carry % 2));
            carry >>= 1;
        }
        String leftStr = a;
        if (aLength < bLength) {
            leftStr = b;
        }
        carry = addLeft(sb, leftStr, minLength, carry);
        if (carry != 0) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    private int addLeft(StringBuilder sb, String leftStr, int minLength, int carry) {
        for (int i = minLength; i < leftStr.length(); i++) {
            char aChar = leftStr.charAt(leftStr.length() - 1 - i);
            carry += aChar - '0';
            sb.insert(0, (char)('0' + carry % 2));
            carry >>= 1;
        }
        return carry;
    }
}
