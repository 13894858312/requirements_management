package cn.edu.nju.rm.model;

public class LikeKey {
    private String uid;

    private Integer rid;

    public LikeKey(String uid, Integer rid){
        this.uid = uid;
        this.rid = rid;
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
}