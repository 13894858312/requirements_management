package cn.edu.nju.rm.model;

public class Relation {
    private Integer id;

    private Integer pid;

    private Integer atype;

    private Integer aid;

    private Integer btype;

    private Integer bid;

    public Relation(Integer id , Integer pid , Integer atype , Integer aid , Integer btype , Integer bid){
        this.id=id;
        this.pid=pid;
        this.atype=atype;
        this.aid=aid;
        this.btype=btype;
        this.bid=bid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}