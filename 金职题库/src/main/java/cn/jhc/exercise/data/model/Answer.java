package cn.jhc.exercise.data.model;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by CLD1994 on 2016/5/27.
 */
@RealmClass
public class Answer implements RealmModel{

    String mAnswer;

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }
}
