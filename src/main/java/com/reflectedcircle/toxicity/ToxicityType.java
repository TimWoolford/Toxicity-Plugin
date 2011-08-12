package com.reflectedcircle.toxicity;

@SuppressWarnings({"UnusedDeclaration"})
enum ToxicityType {
    METHOD_LENGTH("maxLen.method", "Method Length") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    FILE_LENGTH("maxLen.file", "File Length") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    TOO_MANY_PARAMETERS("maxParam", "Too may Parameters") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    CLASS_DATA_ABSTRACTION_COUPLING("classDataAbstractionCoupling", "Class data abstraction coupling") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    CLASS_FAN_OUT_COMPLEXITY("classFanOutComplexity", "Class fan out complexity") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    MISSING_SWITCH_DEFAULT("missing.switch.default", "Missing Switch Default") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    NESTED_ID_DEPTH("nested.if.depth", "Nested If Depth") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    BOOLEAN_EXPRESSION_COMPLEXITY("booleanExpressionComplexity", "Boolean Expression Complexity") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    },
    UNCATEGORISED("whatever", "Uncategorised") {
        @Override
        public Integer getMagnitude() {
            return 1;
        }
    };

    private final String checkStyleKey;
    private final String outputName;

    private ToxicityType(String checkStyleKey, String outputName) {
        this.checkStyleKey = checkStyleKey;
        this.outputName = outputName;
    }

    public static ToxicityType forKey(String key) {
        for (ToxicityType toxicityType : values()) {
            if (toxicityType.checkStyleKey.equals(key)) {
                return toxicityType;
            }
        }
        System.out.println("key = " + key);
        return UNCATEGORISED;
    }

    public abstract Integer getMagnitude();

    public String fieldName() {
        return outputName;
    }
}