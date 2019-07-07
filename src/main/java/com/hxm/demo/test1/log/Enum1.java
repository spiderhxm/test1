package com.hxm.demo.test1.log;

public enum Enum1 {
    MON(1,"monday"),TUE(2,"tuesday"),WES(3,"wedsday");

    Enum1(int v1, String v2){
        this.v1 =v1;
        this.v2 =v2;

    }

    public int getV1() {
        return v1;
    }

    public String getV2() {
        return v2;
    }

    private int v1;

    private String v2;


}
