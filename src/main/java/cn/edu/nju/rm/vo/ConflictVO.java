package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Requirement;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/19 19:36
 */
public class ConflictVO {

    private String frequirementName;
    private List<Requirement> crequirementList;

    public ConflictVO(String frequirementName, List<Requirement> crequirementList){
        this.frequirementName = frequirementName;
        this.crequirementList=crequirementList;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getFrequirementName() {
        return frequirementName;
    }

    public void setFrequirementName(String frequirementName) {
        this.frequirementName = frequirementName;
    }

    public List<Requirement> getCrequirementList() {
        return crequirementList;
    }

    public void setCrequirementList(List<Requirement> crequirementList) {
        this.crequirementList = crequirementList;
    }
}
