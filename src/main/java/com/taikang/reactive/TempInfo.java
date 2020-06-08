package com.taikang.reactive;

import java.util.Random;

public class TempInfo {

    private static  final Random random = new Random();

    private final  String twon;

    private final int temp;


    public TempInfo(String twon, int temp) {
        this.twon = twon;
        this.temp = temp;
    }

    public static Random getRandom() {
        return random;
    }

    public String getTwon() {
        return twon;
    }

    public int getTemp() {
        return temp;
    }

    public static  TempInfo fetch(String town){
      /*  if(random.nextInt(10)==0){
            throw  new RuntimeException("Error!");
        }*/
        return new TempInfo(town,random.nextInt(100));
    }
    @Override
    public String toString() {
        return "TempInfo{" +
                "twon='" + twon + '\'' +
                ", temp=" + temp +
                '}';
    }
}
