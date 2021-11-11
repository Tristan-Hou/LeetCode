package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    List<Integer> list = new ArrayList<>();

    public void test() {

        list.add(1);
        list.add(50);
        list.add(4);
        list.add(2);
        list.add(70);
        list.add(3);
        list.add(1);
        list.add(10);
        list.add(60);
        list.add(30);
        list.add(40);
        list.add(20);

        Collections.sort(list.subList(0, 4), new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if ((integer >= 0 && integer < 10) && (t1 >= 0 && t1 < 10)) {
                    return integer - t1;
                }
                return 0;
            }
        });

        for (int i: list) {
            System.out.println(i);
        }
    }
}
