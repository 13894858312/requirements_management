package cn.edu.nju.rm.model;

import java.sql.Timestamp;
import java.util.Date;

public class Comment {
    private Integer cid;

    private Integer rid;

    private String uid;

    private Date commentTime;

    private String content;

    public Comment(Integer rid, String uid, String content){
        this.rid = rid;
        this.uid = uid;
        this.content = content;
    }

    public Comment(Integer cid, Integer rid, String uid, Timestamp commentTime, String content){
        this(rid, uid, content);
        this.cid = cid;
        this.commentTime  = commentTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}