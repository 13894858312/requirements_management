package cn.edu.nju.rm.model;

import java.sql.Timestamp;
import java.util.Date;

public class Requirement {
    private Integer rid;

    private Integer pid;

    private String uid;

    private Date postTime;

    private Integer priority;

    private Integer selected;

    private Integer done;

    private String name;

    private String type;

    private String description;

    public Requirement(Integer pid, String uid, String name, String type, Integer priority, String description){
        this.pid = pid;
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.description = description;
    }


    public Requirement(Integer rid, Integer pid, String uid, String name, String type, Integer priority, String description){
        this(pid, uid, name, type, priority, description);
        this.rid = rid;
    }

    public Requirement(Integer rid, Integer pid, String uid, Timestamp postTime, String name,
                       String type, Integer priority, String description, Integer selected, Integer done){
        this(rid, pid, uid, name, type, priority, description);
        this.postTime = postTime;
        this.selected = selected;
        this.done = done;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}