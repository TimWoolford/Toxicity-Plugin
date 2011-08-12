package com.reflectedcircle.toxicity;

public class DodgyClass {
    public void aLongLongMethod(){
































    }

    public void aLongMethod(){


































    }

    public void aMethodWithManyParams(String p1,String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,String p11 ) {

    }

    public int aMethodWithSwitchStatement(int i) {
        switch (i) {
            case 1:
                return 8;
            case 2:
                break;
        }
        return 0;
    }

    public int aMethodWithNestedIf(boolean fact, boolean fiction, boolean fantasy, boolean sciFi) {
        if (fact) {
            if (fiction) {
                if(fantasy){
                    if (sciFi){
                        return 2;
                    } else {
                        return 4;
                    }
                } else if (sciFi) {
                    return 7;
                }
            } else if (fantasy){
                return 8;
            }
        } else if (fiction) {
            return 9;
        }
        return 0;
    }

    public boolean aMethodWithComplexBooleanStatement(String statement) {
        return statement != null
                && (statement.startsWith("I") || statement.contains("can") || statement.contains("haz") || statement.endsWith("cheezburger"));
    }
}
