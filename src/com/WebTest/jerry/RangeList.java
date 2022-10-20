package com.WebTest.jerry;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RangeList {
    List<Pair<Integer, Integer>> data = new ArrayList<>();
    public void add(int[] input) {
        boolean inputIsValid = checkIfInputIsValid(input);
        if(inputIsValid == false){
            return;
        }
        int inputLowerBound = input[0];
        int inputUpperBound = input[1];
        Integer removeStartIndex = null;
        Integer removeEndIndex = null;
        int insertIndex = 0;
        if(data.size() == 0){
            data.add(new Pair(inputLowerBound, inputUpperBound));
            return;
        }
        for(int i = 0; i < data.size(); i++) {
            Pair<Integer, Integer> currRange = data.get(i);
            int dataLowerBound = currRange.getKey();
            int dataUpperBound = currRange.getValue();

            // input not overlap with curr but input is bigger -> insert after curr range
            if(inputLowerBound > dataUpperBound) {
                insertIndex = i + 1;
            }
            // input is strictly inside the current range -> expand input from both sides
            else if(inputLowerBound > dataLowerBound && inputUpperBound < dataUpperBound) {
                input[0] = dataLowerBound;
                input[1] = dataUpperBound;
                if (removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                } else {
                    removeEndIndex = i;
                }
            }
            // input overlaps with left of current range -> expand right of input
            else if(inputLowerBound <= dataLowerBound &&
                    inputUpperBound >= dataLowerBound &&
                    inputUpperBound < dataUpperBound) {
                input[1] = dataUpperBound;
                if(removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                } else removeEndIndex = i;
            }
            // input overlaps with right of current range -> expand left of input
            else if(inputLowerBound > dataLowerBound &&
                    inputLowerBound <= dataUpperBound &&
                    inputUpperBound >= dataUpperBound) {
                input[0] = dataLowerBound;
                if(removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                } else removeEndIndex = i;
            }
            // input "wraps" the current range -> no change to input
            else if(inputLowerBound <= dataLowerBound &&
                    inputUpperBound >= dataUpperBound) {
                if (removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                } else removeEndIndex = i;
            }
        }

        // remove overlapped elements
        if(removeStartIndex != null && removeEndIndex != null){
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for(int i = 0 ; i < removeStartIndex; i++){
                list.add(data.get(i));
            }
            for(int i = removeStartIndex + removeEndIndex - removeStartIndex + 1; i < data.size(); i++){
                list.add(data.get(i));
            }
            data = new ArrayList<>(list);
        }

        // insert input
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(int i = 0; i < insertIndex; i++){
            list.add(data.get(i));
        }
        list.add(new Pair(input[0], input[1]));
        for(int i = insertIndex; i < data.size(); i++){
            list.add(data.get(i));
        }
        data = new ArrayList<>(list);
    }

    public void remove(int[] input) {
        boolean inputIsValid = checkIfInputIsValid(input);
        if(inputIsValid == false){
            return;
        }
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        Integer inputLowerBound = input[0];
        Integer inputUpperBound = input[1];
        for(int i = 0; i < data.size(); i++) {
            Pair<Integer, Integer> currRange = data.get(i);
            int dataLowerBound = currRange.getKey();
            int dataUpperBound = currRange.getValue();

            // input is strictly inside the current range -> split range
            if(inputLowerBound > dataLowerBound &&
                    inputUpperBound < dataUpperBound) {
                result.add(new Pair<>(dataLowerBound, inputLowerBound));
                result.add(new Pair<>(inputUpperBound, dataUpperBound));
            }
            // input overlaps with left of current range -> remove left of range
            else if(inputLowerBound <= dataLowerBound &&
                    inputUpperBound > dataLowerBound &&
                    inputUpperBound < dataUpperBound) {
//                currRange[0] = inputUpperBound;

                result.add(new Pair<>(inputUpperBound, currRange.getValue()));
            }
            // input overlaps with right of current range -> remove right of range
            else if(inputLowerBound > dataLowerBound &&
                    inputLowerBound < dataUpperBound &&
                    inputUpperBound >= dataUpperBound) {
//                currRange[1] = inputLowerBound;
                result.add(new Pair<>(currRange.getKey(), inputLowerBound));
            }
            // no overlapping -> no need to change range
            else if(inputLowerBound >= dataUpperBound ||
                    inputUpperBound <= dataLowerBound) {
                result.add(currRange);
            }
        }

        this.data = new ArrayList<>(result);

    }


    public String print(){
        String ret = createOutputString();
        System.out.println(ret);
        return ret;
    }

    public boolean checkIfInputIsValid(int[] range) {
        if(range.length != 2){
            return false;
        }else if(range[1] <= range[0]){
            return false;
        }
        return true;
    }
    public String createOutputString(){
        String outputString = "";
        for(int i = 0; i < data.size(); i++){
            Pair<Integer, Integer> currRange = data.get(i);
            int dataLowerBound = currRange.getKey();
            int dataUpperBound = currRange.getValue();
            String str = "[" + dataLowerBound +", " + dataUpperBound+")";
            outputString += (i != data.size() - 1) ? str + " " : str;
        }
        return outputString;
    }

    public void test1(){
        RangeList rl = new RangeList();
        rl.add(new int[]{1, 5});
        rl.print();
        rl.add(new int[]{10, 20});
        String ret = rl.print(); // Should display: [1, 5) [10, 20)

        rl.add(new int[]{20, 20});
        ret = rl.print(); // Should display: [1, 5) [10, 20)

        rl.add(new int[]{20, 21});
        ret = rl.print(); // Should display: [1, 5) [10, 21)

        rl.add(new int[]{2, 4});
        ret = rl.print(); // Should display: [1, 5) [10, 21)

        rl.add(new int[]{3, 8});
        ret = rl.print(); // Should display: [1, 8) [10, 21)

        rl.remove(new int[]{10, 10});
        ret = rl.print(); // Should display: [1, 8) [10, 21)

        rl.remove(new int[]{10, 11});
        ret = rl.print(); // Should display: [1, 8) [11, 21)

        rl.remove(new int[]{15, 17});
        ret = rl.print(); // Should display: [1, 8) [11, 15) [17, 21)

        rl.remove(new int[]{3, 19});
        ret = rl.print(); // Should display: [1, 3) [19, 21)
    }

    public void test2(){
        RangeList rl = new RangeList();
        rl.add(new int[]{20, 25});
        rl.add(new int[]{15, 20});
        rl.print(); // Should display: [15, 25)
        rl.add(new int[]{10, 20});
        rl.print(); // Should display: [10, 25)
    }

    public void test3(){
        RangeList rl = new RangeList();
        rl.add(new int[]{20, 25});
        rl.add(new int[]{25, 30});
        rl.print(); // Should display: [20, 30)
        rl.add(new int[]{20, 30});
        rl.print(); // Should display: [20, 30)
        rl.add(new int[]{25, 35});
        rl.print(); // Should display: [20, 35)
    }

    public void test4(){
        RangeList rl = new RangeList();
        rl.add(new int[]{20, 25});
        rl.add(new int[]{27, 30});
        rl.add(new int[]{32, 35});
        rl.add(new int[]{38, 40});
        rl.add(new int[]{20, 40});
        rl.print(); // Should display: [20, 40)

        rl.add(new int[]{20, 25});
        rl.add(new int[]{23, 30});
        rl.add(new int[]{33, 40});
        rl.add(new int[]{10, 50});
        rl.print(); // Should display: [10, 50)
    }
    public void test5(){
        RangeList rl = new RangeList();
        rl.add(new int[]{0, 100});
        rl.add(new int[]{0, 10});
        rl.print(); // Should display: [0, 100)

        rl.add(new int[]{50, 70});
        rl.print(); // Should display: [0, 100)
    }
    public void test6(){
        RangeList rl = new RangeList();
        rl.add(new int[]{0, 10});
        rl.add(new int[]{-5, 100});
        rl.print(); // Should display: [-5, 100)

        rl.add(new int[]{-20, 200});
        rl.print(); // Should display: [-20, 200)
    }
    public void test7(){
        RangeList rl = new RangeList();
        rl.add(new int[]{0, 100});
        rl.remove(new int[]{50, 51});
        rl.print(); // Should display: [0, 50) [51, 100)

        rl.remove(new int[]{10, 20});
        rl.remove(new int[]{70, 80});
        rl.print(); // Should display: [0, 10) [20, 50) [51, 70) [80, 100)
    }
    public void test8(){
        RangeList rl = new RangeList();
        rl.add(new int[]{0, 100});
        rl.remove(new int[]{80, 100});
        rl.print(); // Should display: [0, 80)

        rl.remove(new int[]{60, 100});
        rl.print(); // Should display: [0, 60)
    }
    public void test9(){
        RangeList rl = new RangeList();
        rl.add(new int[]{0, 100});
        rl.remove(new int[]{0, 20});
        rl.print(); // Should display: [20, 100)

        rl.remove(new int[]{-20, 50});
        rl.print(); // Should display: [50, 100)
    }

    public void test10(){
        RangeList rl = new RangeList();
        rl.add(new int[]{10, 15});
        rl.add(new int[]{20, 25});
        rl.add(new int[]{30, 50});
        rl.add(new int[]{60, 80});
        rl.add(new int[]{90, 100});
        rl.remove(new int[]{35, 65});
        rl.print(); // Should display: [10, 15) [20, 25) [30, 35) [65, 80) [90, 100)

        rl.remove(new int[]{12, 32});
        rl.print(); // Should display: [10, 12) [32, 35) [65, 80) [90, 100)
        rl.remove(new int[]{35, 70});
        rl.print(); // Should display: [10, 12) [32, 35) [70, 80) [90, 100)
    }

    public void test11(){
        RangeList rl = new RangeList();
        rl.add(new int[]{10, 15});
        rl.add(new int[]{20, 25});
        rl.add(new int[]{30, 35});
        rl.add(new int[]{40, 45});
        rl.remove(new int[]{10, 44});
        rl.print(); // Should display: [44, 45)

        rl.remove(new int[]{44, 45});
        rl.print(); // Should display:
    }
    public static void main(String[] args) {
        RangeList rl = new RangeList();
        // test cases
        rl.test1();
//        rl.test2();
//        rl.test3();
//        rl.test4();
//        rl.test5();
//        rl.test6();
//        rl.test7();
//        rl.test8();
//        rl.test9();
//        rl.test10();
//        rl.test11();

    }
}
