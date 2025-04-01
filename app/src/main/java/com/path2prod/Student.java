package com.path2prod;

public record Student(String name, Integer score) {
    public Student{
        if (score<0 || score>99){
            throw new IllegalArgumentException(String.format("invalid score %d for student %s", score,name));
        }
    }
}
