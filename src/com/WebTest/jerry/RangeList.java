package com.WebTest.jerry;

// Task: Implement a class named 'RangeList' // A pair of integers define a range, for example: [1, 5). This range includes integers: 1, 2, 3, and 4.

// A range list is an aggregate of these ranges: [1, 5), [10, 11), [100, 201)

/**

 * * NOTE: Feel free to add any extra member variables/functions you like. */

/**
 * 题目没有指明range范围，也许会很大
 * 范围没有指明是否有负数，也许会有.
 *
 */

class RangeList {

    /**
     *  Adds a range to the list * @param {Array<number>} range - Array of two integers that specify beginning and end of range.
     */
    public void add(int[] range) {
        // TODO: implement this
    }
    /** *
     * Removes a range from the list * @param {Array<number>} range - Array of two integers that specify beginning and end of range.
     * 没有说是否需要返回
     * */
    public void remove(int[] range) {
        // TODO: implement this
    }

/** * Prints out the list of ranges in the range list */
     public void print() {
         // TODO: implement this
     }

    public static void main(String[] args) {
        // Example run
        RangeList rl = new RangeList();
        rl.add(new int[]{1,5});
        rl.print(); // Should display: [1, 5)
        rl.add(new int[]{10, 20});
        rl.print(); // Should display: [1, 5) [10, 20)

        rl.add(new int[]{20, 20});
        rl.print(); // Should display: [1, 5) [10, 20)

        rl.add(new int[]{20, 21});
        rl.print(); // Should display: [1, 5) [10, 21)

        rl.add(new int[]{2, 4});
        rl.print(); // Should display: [1, 5) [10, 21)

        rl.add(new int[]{3, 8});
        rl.print(); // Should display: [1, 8) [10, 21)
    }
 }
