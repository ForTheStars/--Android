package cn.jhc.exercise.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by CLD1994 on 2016/5/26.
 * 题目类
 */

public class Question extends RealmObject{

    //兼容网络响应
    private String status;
    private String msg;

    //系统属性
    private String objectId;
    private String createdAt;
    private String updatedAt;

    private String topic;
    private Integer type;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private RealmList<Answer> answer;
    private String analyze;
    private Integer score;
    private String imageUrl;

    private ExaminationPaper examinationPaper;

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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getF() {
        return F;
    }

    public void setF(String f) {
        F = f;
    }

    public RealmList<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(RealmList<Answer> answer) {
        this.answer = answer;
    }

    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ExaminationPaper getExaminationPaper() {
        return examinationPaper;
    }

    public void setExaminationPaper(ExaminationPaper examinationPaper) {
        this.examinationPaper = examinationPaper;
    }

    @Override
    public String toString() {
        return "Question{" +
                ", objectId='" + objectId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", topic='" + topic + '\'' +
                ", type=" + type +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", E='" + E + '\'' +
                ", F='" + F + '\'' +
                ", answer=" + answer +
                ", analyze='" + analyze + '\'' +
                ", score=" + score +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
