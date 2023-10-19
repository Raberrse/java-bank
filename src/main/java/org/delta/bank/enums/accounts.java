package org.delta.bank.enums;

public enum accounts { ;
    public  enum   Savings{ ;
        public static final double BASE_FEE = 50;
        public static final double PERCENT_FEE_LIMIT = 500;
        public static final double PERCENT_FEE = PERCENT_FEE_LIMIT / 100 * 5;
        public static final double savings_fee = 1.08;
    }
    public enum Students{ ;
        public static final double BASE_FEE = 0;
        public static final double PERCENT_FEELIMIT = 0;
        public static final double PERCENT_FEE = 0;
        public static final double savings_fee = 1.01;
    }
    public enum   Base{ ;
        public static final double BASE_FEE = 5;
        public static final double PERCENT_FEE_LIMIT = 1000;
        public static final double PERCENT_FEE = PERCENT_FEE_LIMIT / 100 * 1;
    }
}
