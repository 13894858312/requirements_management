package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Project;

import java.util.List;

/**
 * @author wangxue
 * Created by wangxue on 2019/2/26.
 */
public class PostVO {
    /**
     * 项目信息
     */
    Project project;
    /**
     * 已征集到的需求数
     */
    Integer number;
    /**
     * 需求VO列表
     */
    List<RequirementVO> requirementVOList;

    @Override
    public String toString() {
        return super.toString();
    }
}
