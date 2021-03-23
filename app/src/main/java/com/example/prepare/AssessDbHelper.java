package com.example.prepare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.prepare.AssessContract.*;

import java.util.ArrayList;
import java.util.List;


public class AssessDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Pp.db";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;


    public AssessDbHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUEST_TAB = "CREATE TABLE " +
                QuestsTable.TAB_NAME + " ( " +
                QuestsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestsTable.COL_QUEST + " TEXT, " +
                QuestsTable.COL_OPT1 + " TEXT, " +
                QuestsTable.COL_OPT2 + " TEXT, " +
                QuestsTable.COL_OPT3 + " TEXT, " +
                QuestsTable.COL_OPT4 + " TEXT, " +
                QuestsTable.COL_OPT5 + " TEXT, " +
                QuestsTable.COL_ANS_NUM + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUEST_TAB);
        fllQuesTab();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestsTable.TAB_NAME);
        onCreate(db);
    }

    private void fllQuesTab() {
        Quest q1 = new Quest("The closer I am to a major exam, the harder it is for me to concentrate on the material",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q1);
        Quest q2 = new Quest("When I study, I worry that I will not remember the material on the exam.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q2);
        Quest q3 = new Quest("During important exams, I think that I am doing awful or that I may fail.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q3);
        Quest q4 = new Quest("I lose focus on important exams, and I cannot remember material that I knew before the exam.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q4);
        Quest q5 = new Quest("I finally remember the answer to exam questions after the exam is already over.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q5);
        Quest q6 = new Quest("I worry so much before a major exam that I am too worn out to do my best on the exam.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q6);
        Quest q7 = new Quest("I feel out of sorts or not really myself when I take important exams.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q7);
        Quest q8 = new Quest("I find that my mind sometimes wanders when I am taking important exams.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q8);
        Quest q9 = new Quest("After an exam, I worry about whether I did well enough.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q9);
        Quest q10 = new Quest("I struggle with writing assignments, or avoid them as long as I can. I feel that whatever I do will not be good enough.",
                "5.extremely or always true", "4.highly or usually true", "3.moderately or sometimes true",
                "2.slightly or seldom true", "1.not at all or never true", 1);
        addQuest(q10);

    }
    private void addQuest(Quest quest) {
        ContentValues cv = new ContentValues();
        cv.put(QuestsTable.COL_QUEST, quest.getQuest());
        cv.put(QuestsTable.COL_OPT1, quest.getOpt1());
        cv.put(QuestsTable.COL_OPT2, quest.getOpt2());
        cv.put(QuestsTable.COL_OPT3, quest.getOpt3());
        cv.put(QuestsTable.COL_OPT4, quest.getOpt4());
        cv.put(QuestsTable.COL_OPT5, quest.getOpt5());
        cv.put(QuestsTable.COL_ANS_NUM, quest.getAnsNum());
        db.insert(QuestsTable.TAB_NAME, null, cv);

    }
    public List<Quest> getAllQuests() {
        List<Quest> questList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestsTable.TAB_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Quest quest = new Quest();
                quest.setQuest(cursor.getString(cursor.getColumnIndex(QuestsTable.COL_QUEST)));
                quest.setOpt1(cursor.getString(cursor.getColumnIndex(QuestsTable.COL_OPT1)));
                quest.setOpt2(cursor.getString(cursor.getColumnIndex(QuestsTable.COL_OPT2)));
                quest.setOpt3(cursor.getString(cursor.getColumnIndex(QuestsTable.COL_OPT3)));
                quest.setOpt4(cursor.getString(cursor.getColumnIndex(QuestsTable.COL_OPT4)));
                quest.setOpt5(cursor.getString(cursor.getColumnIndex(QuestsTable.COL_OPT5)));
                quest.setAnsNum(cursor.getInt(cursor.getColumnIndex(QuestsTable.COL_ANS_NUM)));
                questList.add(quest);

            } while (cursor.moveToNext());
        }
        cursor.close();
        return questList;
    }




}
