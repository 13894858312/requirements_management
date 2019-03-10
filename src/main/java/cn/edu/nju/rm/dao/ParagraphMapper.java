package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Paragraph;

import java.util.List;

public interface ParagraphMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paragraph record);

    int insertSelective(Paragraph record);

    Paragraph selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paragraph record);

    int updateByPrimaryKey(Paragraph record);

    /**
     * 根据项目id查询所有段落信息
     * @param pid 项目id
     * @return 所有相关段落id列表
     */
    List<Paragraph> selectByPid(int pid);
}