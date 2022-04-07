package javaBean;

import java.util.Date;

public class HComment {
    private int hCommentID;
    private int houseID;
    private int userID;
    private Date date;
    private String hComment;

    public int gethCommentID() {
        return hCommentID;
    }

    public void sethCommentID(int hCommentID) {
        this.hCommentID = hCommentID;
    }

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
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

    public void setData(Date date) {
        this.date = date;
    }

    public String gethComment() {
        return hComment;
    }

    public void sethComment(String hComment) {
        this.hComment = hComment;
    }

    @Override
    public String toString() {
        return "HComment{" +
                "hCommentID=" + hCommentID +
                ", houseID=" + houseID +
                ", userID=" + userID +
                ", date=" + date +
                ", hComment='" + hComment + '\'' +
                '}';
    }
}
