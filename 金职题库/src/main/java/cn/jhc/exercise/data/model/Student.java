package cn.jhc.exercise.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by CLD1994 on 2016/5/24.
 * 学生类
 */
public class Student extends RealmObject{

    //兼容网络响应
    private String status;

    private String msg;

    //系统属性
    @PrimaryKey
    @Required
    private String objectId;

    private String createdAt;

    private String updatedAt;

    private String sessionToken;

    private String authData;

    @Required
    private String username;

    private String password;

    private String mobilePhoneNumber;

    private String mobilePhoneVerified;

    private String email;

    private String emailVerified;

    //以下为自定义属性
    @Required
    private String StudentId;

    private String nickname;

    private String realName;

    private String avatorUrl;

    private String rank;

    private String killCount;

    private String major;

    private String classNo;

    private String teacher;

    //private RealmList<Question> Questions;

    //private RealmList<ExaminationPaper> examinationPapers;

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

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getAuthData() {
        return authData;
    }

    public void setAuthData(String authData) {
        this.authData = authData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getMobilePhoneVerified() {
        return mobilePhoneVerified;
    }

    public void setMobilePhoneVerified(String mobilePhoneVerified) {
        this.mobilePhoneVerified = mobilePhoneVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAvatorUrl() {
        return avatorUrl;
    }

    public void setAvatorUrl(String avatorUrl) {
        this.avatorUrl = avatorUrl;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getKillCount() {
        return killCount;
    }

    public void setKillCount(String killCount) {
        this.killCount = killCount;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /*
    public RealmList<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(RealmList<Question> questions) {
        Questions = questions;
    }

    public RealmList<ExaminationPaper> getExaminationPapers() {
        return examinationPapers;
    }

    public void setExaminationPapers(RealmList<ExaminationPaper> examinationPapers) {
        this.examinationPapers = examinationPapers;
    }
    */

    @Override
    public String toString() {
        return "Student{" +
                "objectId='" + objectId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", authData='" + authData + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", mobilePhoneVerified='" + mobilePhoneVerified + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified='" + emailVerified + '\'' +
                ", StudentId='" + StudentId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", realName='" + realName + '\'' +
                ", avatorUrl='" + avatorUrl + '\'' +
                ", rank='" + rank + '\'' +
                ", killCount='" + killCount + '\'' +
                ", major='" + major + '\'' +
                ", classNo='" + classNo + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
