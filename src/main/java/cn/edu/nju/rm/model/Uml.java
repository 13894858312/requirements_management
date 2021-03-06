package cn.edu.nju.rm.model;

public class Uml {
    private Integer umlid;

    private Integer pid;

    private String title;

    private String content;

    public Uml(Integer pid, String title){
        this.pid = pid;
        this.title = title;
    }

    public Uml(Integer umlid, Integer pid, String title, String content){
        this(pid, title);
        this.content = content;
        this.umlid = umlid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUmlid() {
        return umlid;
    }

    public void setUmlid(Integer umlid) {
        this.umlid = umlid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}