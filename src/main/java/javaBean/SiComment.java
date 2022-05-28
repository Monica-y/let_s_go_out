package javaBean;

import org.json.JSONObject;

import java.util.Date;

public class SiComment {
    private int commentID;
    private int sightID;
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

    public int getCommentID() {
        return commentID;
    }

    public String getComment() {
        return comment;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return new JSONObject(this).toString();
    }
}
