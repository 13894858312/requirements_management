package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Requirement;
import cn.edu.nju.rm.model.Uml;

/**
 * Created by makewei on 2019/6/2.
 */
public class UmlRelationVO {

    private Uml uml;

    private Boolean ustate;

    public UmlRelationVO(Uml uml, Boolean ustate){
        this.uml=uml;
        this.ustate=ustate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Uml getUml() {
        return uml;
    }

    public void setUml(Uml uml) {
        this.uml = uml;
    }

    public Boolean getUstate() {
        return ustate;
    }

    public void setUstate(Boolean ustate) {
        this.ustate = ustate;
    }
}
