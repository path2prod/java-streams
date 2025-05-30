package com.path2prod.section12.complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LongestSequence {
    private Integer previousValue;
    private List<Integer> currentSequence;
    private List<Integer> longestSequence;
    private boolean resetSeq;

    public LongestSequence(){
        previousValue = null;
        currentSequence = new ArrayList<>();
        longestSequence = new ArrayList<>();
        resetSeq = false;
    }



    void accumulator(Integer currentValue){
        if (Objects.isNull(previousValue) || currentValue == previousValue + 1){
            if(resetSeq){
                resetSeq = false;
                
                if (longestSequence.size() < currentSequence.size()){
                    longestSequence.clear();
                    longestSequence.addAll(currentSequence);
                }

                currentSequence.clear();
                currentSequence.add(previousValue);
                currentSequence.add(currentValue);
                previousValue = currentValue;
            }else{
                previousValue = currentValue;
                currentSequence.add(currentValue);
            }
        } else{
            //to allow same number sequencially 
            if (!Objects.equals(previousValue, currentValue)){
                previousValue = currentValue;
                resetSeq = true;
            }
        }
    }

    LongestSequence combiner(LongestSequence item){
        //Collector must be parallel-safe. This scenario is sequential
        throw new IllegalThreadStateException("this is not optimal for parallel");
    }

    public List<Integer> finisher(){
        return this.currentSequence.size() >= this.longestSequence.size() ? this.currentSequence : this.longestSequence;
    }

}
