package com.example.rex.hw4_1;

/**
 * Created by REX on 2015/4/4.
 */
public class Bmi {
    private double height;
    private double weight;
    Bmi(double height,double weight){
        this.height=height;
        this.weight=weight;

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
