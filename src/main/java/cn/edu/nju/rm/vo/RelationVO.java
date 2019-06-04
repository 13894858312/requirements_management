package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Requirement;

/**
 * Created by makewei on 2019/5/31.
 */
public class RelationVO {

    private Integer id;

    private String atype;

    private String aname;

    private String adescription;

    private String btype;

    private String bname;

    private String bdescription;

    public RelationVO(Integer id, String atype, String aname, String adescription, String btype, String bname, String bdescription){

        this.id=id;

        this.atype=atype;

        this.aname=aname;

        this.adescription=adescription;

        this.btype=btype;

        this.bname=bname;

        this.bdescription=bdescription;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdescription() {
        return adescription;
    }

    public void setAdescription(String adescription) {
        this.adescription = adescription;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getBdescription() {
        return bdescription;
    }

    public void setBdescription(String bdescription) {
        this.bdescription = bdescription;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

}
