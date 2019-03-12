package cn.edu.nju.rm.model;

public class Code {
    private Integer id;

    private Integer pid;

    private String location;

    public Code(Integer pid,String location){
        this.pid=pid;
        this.location=location;
    }

    public Code(Integer id,Integer pid,String location){
        this(pid,location);
        this.id=id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}