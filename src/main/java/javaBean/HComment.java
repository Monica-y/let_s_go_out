package javaBean;

import java.util.Date;

public class HComment {
    private int commentID;
    private int houseID;
    private int userID;
    private Date date;
    private String comment;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCommentID() {
        return commentID;
    }

    @Override
    public String toString() {
        return "HComment{" +
                       "commentID=" + commentID +
                       ", houseID=" + houseID +
                       ", userID=" + userID +
                       ", date=" + date +
                       ", comment='" + comment + '\'' +
                       ", userName='" + userName + '\'' +
                       '}';
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
