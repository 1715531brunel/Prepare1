package com.example.prepare;

import android.provider.BaseColumns;

public final class  AssessContract {
    private AssessContract (){}

    public static class QuestsTable implements BaseColumns {
        public static final String TAB_NAME = "assess_quest";
        public static final String COL_QUEST = "quest";
        public static final String COL_OPT1 = "opt1";
        public static final String COL_OPT2 = "opt2";
        public static final String COL_OPT3 = "opt3";
        public static final String COL_OPT4 = "opt4";
        public static final String COL_OPT5 = "opt5";
        public static final String COL_ANS_NUM = "ans_num";
    }

}

