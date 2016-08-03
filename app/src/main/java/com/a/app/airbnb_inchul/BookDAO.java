package com.a.app.airbnb_inchul;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BookDAO extends SQLiteOpenHelper {
    public static final String TABLE_NAME ="book";
    public static final String SEQ2 ="seq2";
    public static final String ADDRESS ="address";
    public static final String CHECK_IN ="check_in";
    public static final String CHECK_OUT ="check_out";
    public static final String COUNT ="count";
    public static final String ID ="ID";

    public BookDAO(Context context) {
        super(context, "hanbit", null, 1);
        Log.d("DB 생성 체크","======================여기가지 집입");
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB 테이블  생성 체크2", "======================여기가지 집입");
        String sql = "create table if not exists "
                + TABLE_NAME
                + "("
                + SEQ2 + " integer primary key autoincrement,"
                + ADDRESS + " text,"
                + CHECK_IN + " text,"
                + CHECK_OUT + " text,"
                + COUNT + " text,"
                + ID + " text );";
        db.execSQL(sql);
        Log.d("DB 테이블  생성 체크3", "================실행======여기가지 집입");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "drop table if exist" + TABLE_NAME;
    }

    public int book(BookBean bBean) {
        int result = 0;
        String sql = "insert into "
                +TABLE_NAME
                +"("
                +String.format("%s,%s,%s,%s,%s,%s) "
                ,SEQ2,ADDRESS, CHECK_IN, CHECK_OUT, COUNT, ID)
                +String.format("values('%s','%s','%s','%s','%s','%s');"
                ,"seq2.nextval"
                ,bBean.getAddress()
                ,bBean.getCheckIn()
                ,bBean.getCheckOut()
                ,bBean.getCount()
                ,bBean.getId()

        );
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }


    public int cancel(BookBean bBean) {
        int result = 0;
        String sql = "delete from "
                + TABLE_NAME
                + String.format(" where seq2=%s", bBean.getSeq2());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    public int update_book(BookBean bBean) {
        int result = 0;
            String sql = "update into "
                    +TABLE_NAME
                    +"set "
                    +String.format("CHECK_IN=%s, CHECK_OUT=%s, COUNT=%s where seq2 = %s;"
                    ,bBean.getCheckIn()
                    ,bBean.getCheckOut()
                    ,bBean.getCount()
                    ,bBean.getSeq2()

            );
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(sql);
            return result;
        }


}
