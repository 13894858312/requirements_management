package cn.edu.nju.rm.model;

public class Like {
    private String uid;

    private Integer rid;

    private Integer pid;

    public Like(String uid, Integer rid, Integer pid){
        this.uid = uid;
        this.rid = rid;
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
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
}