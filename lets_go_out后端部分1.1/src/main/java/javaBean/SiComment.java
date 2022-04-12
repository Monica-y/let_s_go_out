package javaBean;

import java.util.Date;

public class SiComment {
    private int sCommentID;
    private int sightID;
    private int userID;
    private Date date;
    private String sComment;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getsCommentID() {
        return sCommentID;
    }

    public void setsCommentID(int sCommentID) {
        this.sCommentID = sCommentID;
    }

    public int getSightID() {
        return sightID;
    }

    public void setSightID(int sightID) {
        this.sightID = sightID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getsComment() {
        return sComment;
    }

    public void setsComment(String sComment) {
        this.sComment = sComment;
    }

    @Override
    public String toString() {
        return "SiComment{" +
                "sCommentID=" + sCommentID +
                ", sightID=" + sightID +
                ", userID=" + userID +
                ", date=" + date +
                ", sComment='" + sComment + '\'' +
                '}';
    }
}
