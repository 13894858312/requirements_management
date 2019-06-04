package cn.edu.nju.rm.model;

public class Code {
    private Integer id;

    private Integer pid;

    private String name;

    private String location;

    public Code(Integer pid,String name,String location){
        this.pid=pid;
        this.name=name;
        this.location=location;
    }

    public Code(Integer id,Integer pid,String name,String location){
        this(pid,name,location);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}