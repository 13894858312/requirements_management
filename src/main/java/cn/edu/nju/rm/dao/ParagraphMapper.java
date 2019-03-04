package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Paragraph;

public interface ParagraphMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Paragraph record);

    int insertSelective(Paragraph record);

    Paragraph selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Paragraph record);

    int updateByPrimaryKey(Paragraph record);
}