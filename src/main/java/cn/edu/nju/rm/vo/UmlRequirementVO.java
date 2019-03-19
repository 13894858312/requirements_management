package cn.edu.nju.rm.vo;

import cn.edu.nju.rm.model.Requirement;

import java.sql.Timestamp;

/**
 * @author wangxue
 * Created by wangxue on 2019/3/19.
 */
public class UmlRequirementVO {

    Requirement requirement;
    Integer related;

    UmlRequirementVO(Integer rid, Integer pid, String uid, Timestamp postTime, String name,
                     String type, Integer priority, String description, Integer selected, Integer done
                    , Integer related){
        requirement = new Requirement(rid, pid, uid, postTime, name, type , priority, description, selected, done);
        related = related;
    }
    //todo 关联/取消关联


    @Override
    public String toString(){
        return super.toString();
    }
}
