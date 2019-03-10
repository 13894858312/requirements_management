package cn.edu.nju.rm.model;

import java.sql.Timestamp;
import java.util.Date;


public class Project {
    private Integer pid;

    private String publisher;

    private Date createdTime;

    private Date closedTime;

    private Integer state;

    private String name;

    private String field;

    private String language;

    private String description;

    public Project(String publisher, String name, String language, String field, Date closedTime, String description){
        this.publisher = publisher;
        this.name = name;
        this.language = language;
        this.field = field;
        this.closedTime = closedTime;
        this.description = description;
    }

    public Project(Integer pid, String publisher, String name, String language, String field, Date closedTime, String description){
        this(publisher, name, language, field, closedTime, description);
        this.pid = pid;
    }

    public Project(Integer pid, String publisher, Timestamp createdTime, java.sql.Date closedTime,
                   String name, String field, String language, String description, Integer state){
        this(pid, publisher, name, language, field, closedTime, description);
        this.createdTime = createdTime;
        this.state = state;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}