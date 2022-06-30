package com.nowcoder.community.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class DiscussPost {  //对应帖子表discuss_post
    private int id;   //帖子id
    private int userId;  //用户id
    private String title; //帖子标题
    private String content; //帖子内容
    private int postType; //帖子类型0-普通;1-置顶
    private int postStatus; //帖子状态0-正常;1-精华;2-拉黑
    private Date createTime; //帖子创建日期
    private int commentCount; //评论数量
    private double score; //帖子分数，决定帖子的前后顺序

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public int getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(int postStatus) {
        this.postStatus = postStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DiscussPost{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", postType=" + postType +
                ", postStatus=" + postStatus +
                ", createTime=" + createTime +
                ", commentCount=" + commentCount +
                ", score=" + score +
                '}';
    }
}
