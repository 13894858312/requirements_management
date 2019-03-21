package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Requirement;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/19 19:36
 */
public class DuplicationVO {

    private Requirement frequirement;
    private List<Requirement> drequirementList;

    public DuplicationVO(Requirement frequirement, List<Requirement> drequirementList){
        this.frequirement = frequirement;
        this.drequirementList=drequirementList;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public Requirement getFrequirement() {
        return frequirement;
    }

    public void setFrequirement(Requirement frequirement) {
        this.frequirement = frequirement;
    }

    public List<Requirement> getDrequirementList() {
        return drequirementList;
    }

    public void setDrequirementList(List<Requirement> drequirementList) {
        this.drequirementList = drequirementList;
    }
}
