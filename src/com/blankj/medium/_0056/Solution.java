package com.blankj.medium._056;

import com.blankj.structure.Interval;

import java.util.*;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/19
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o1.start > o2.start) return 1;
                return 0;
            }
        });
        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval.print(solution.merge(Interval.createTestData("[1,3],[2,6],[8,10],[15,18]")));
        Interval.print(solution.myMergeOverlap(Interval.createTestData("[1,3],[2,6],[8,10],[15,18]")));
        Interval.print(solution.merge(Interval.createTestData("[1,3],[2,6],[8,15],[15,18]")));
        Interval.print(solution.myMergeOverlap(Interval.createTestData("[1,3],[2,6],[8,15],[15,18]")));

    }
    public List<Interval> myMergeOverlap(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return null;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        LinkedList<Interval> res = new LinkedList<>();
        for (Interval interval : intervals) {
            if (res.isEmpty()) {
                res.add(interval);
            } else {
                Interval lastInterval = res.getLast();
                if (lastInterval.end >= interval.start) {
                    lastInterval.end = interval.end;
                } else {
                    res.add(interval);
                }
            }
        }

        return res;
    }
}
