package com.jmxtestbuilder.toy;

public class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;

        for (int i : ingredient) {
            stack[sp++] = i;
        }
    }
}
