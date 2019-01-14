package cn.edu.nju.rm.dao;

import cn.edu.nju.rm.model.Paragraph;
import cn.edu.nju.rm.model.ParagraphWithBLOBs;

public interface ParagraphMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParagraphWithBLOBs record);

    int insertSelective(ParagraphWithBLOBs record);

    ParagraphWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParagraphWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ParagraphWithBLOBs record);

    int updateByPrimaryKey(Paragraph record);
}