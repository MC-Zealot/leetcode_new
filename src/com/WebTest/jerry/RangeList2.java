package com.WebTest.jerry;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RangeList2 {
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
        }
        for(int i = 0; i < data.size(); i++){
            Pair<Integer, Integer> currRange = data.get(i);
            int dataLowerBound = currRange.getKey();
            int dataUpperBound = currRange.getValue();

            // input not overlap with curr but input is bigger -> insert after curr range
            if (inputLowerBound > dataUpperBound) {
                insertIndex = i + 1;
            }
            // input is strictly inside the current range -> expand input from both sides
            else if (inputLowerBound > dataLowerBound && inputUpperBound < dataUpperBound) {
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
            else if (inputLowerBound <= dataLowerBound &&
                    inputUpperBound >= dataLowerBound &&
                    inputUpperBound < dataUpperBound) {
                input[1] = dataUpperBound;
                if (removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                }
                else removeEndIndex = i;
            }
            // input overlaps with right of current range -> expand left of input
            else if (inputLowerBound > dataLowerBound &&
                    inputLowerBound <= dataUpperBound &&
                    inputUpperBound >= dataUpperBound) {
                input[0] = dataLowerBound;
                if (removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                }
                else removeEndIndex = i;
            }
            // input "wraps" the current range -> no change to input
            else if (inputLowerBound <= dataLowerBound &&
                    inputUpperBound >= dataUpperBound) {
                if (removeStartIndex == null) {
                    removeStartIndex = i;
                    removeEndIndex = i;
                }
                else removeEndIndex = i;
            }
        }

        // remove overlapped elements
        if (removeStartIndex != null && removeEndIndex != null){
//            data.splice(removeStartIndex, removeEndIndex - removeStartIndex + 1);
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for(int i = 0 ;i < removeStartIndex; i++){
                if(i == insertIndex){
                    list.add(new Pair(inputLowerBound, inputUpperBound));
                }
                list.add(data.get(i));
            }
            for(int i = removeStartIndex + removeEndIndex - removeStartIndex + 1; i < data.size(); i++){
                list.add(data.get(i));
            }
            data = new ArrayList<>(list);
        }

        // insert input
//        data.splice(insertIndex, 0, input);
    }

    public void remove(int[] input) {
        boolean inputIsValid = checkIfInputIsValid(input);
        if(inputIsValid == false){
            return;
        }
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        Integer inputLowerBound = input[0];
        Integer inputUpperBound = input[1];
        for (int i = 0; i < data.size(); i++) {
            Pair<Integer, Integer> currRange = data.get(i);
            int dataLowerBound = currRange.getKey();
            int dataUpperBound = currRange.getValue();

            // input is strictly inside the current range -> split range
            if (inputLowerBound > dataLowerBound &&
                    inputUpperBound < dataUpperBound) {
                result.add(new Pair<>(dataLowerBound, inputLowerBound));
                result.add(new Pair<>(inputUpperBound, dataUpperBound));
            }
            // input overlaps with left of current range -> remove left of range
            else if (inputLowerBound <= dataLowerBound &&
                    inputUpperBound > dataLowerBound &&
                    inputUpperBound < dataUpperBound) {
//                currRange[0] = inputUpperBound;

                result.add(new Pair<>(inputUpperBound, currRange.getValue()));
            }
            // input overlaps with right of current range -> remove right of range
            else if (inputLowerBound > dataLowerBound &&
                    inputLowerBound < dataUpperBound &&
                    inputUpperBound >= dataUpperBound) {
//                currRange[1] = inputLowerBound;
                result.add(new Pair<>(currRange.getKey(), inputLowerBound));
            }
            // no overlapping -> no need to change range
            else if (inputLowerBound >= dataUpperBound ||
                    inputUpperBound <= dataLowerBound) {
                result.add(currRange);
            }
        }

        this.data = new ArrayList<>(result);

    }


    public void print(){
        System.out.println(createOutputString());
    }

    public boolean checkIfInputIsValid(int[] range) {
        if(range.length != 2){
            return false;
        }else if(range[1] < range[0]){
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
}
