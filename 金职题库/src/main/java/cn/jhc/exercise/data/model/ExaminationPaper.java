package cn.jhc.exercise.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by CLD1994 on 2016/5/26.
 * 试卷类
 */

public class ExaminationPaper extends RealmObject{

    //兼容网络响应
    private String status;
    private String msg;

    //系统属性
    private String objectId;
    private String createdAt;
    private String updatedAt;

    private String title;
    private String detail;
    private String courses;
    private Integer type;
    private String author;

    private RealmList<Question> questions;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public RealmList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(RealmList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ExaminationPaper{" +
                "objectId='" + objectId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", courses='" + courses + '\'' +
                ", type=" + type +
                ", author='" + author + '\'' +
                '}';
    }
}
