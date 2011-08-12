package com.reflectedcircle.toxicity;

public class TestRunner {

    public static void main(String[] args) throws Exception {
        new MakeChart().checkThatStyle("src/test/java", "target/chart.png");
    }
}
