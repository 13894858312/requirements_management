package cn.edu.nju.rm.service.paragraph;

import cn.edu.nju.rm.model.Paragraph;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 16:34
 */
public interface ParagraphService {

    /**
     * 添加文档段落
     * @param paragraph 段落信息
     * @return 添加结果
     */
    String addParagraph(Paragraph paragraph);

    /**
     * 修改段落信息
     * @param paragraph 段落信息
     * @return 修改结果
     */
    String modifyParagraph(Paragraph paragraph);

    /**
     * 根据项目id查询项目文档段落列表
     * @param pid 项目id
     * @return 返回项目相关所有段落id列表
     */
    List<Paragraph> findParagraphByPid(int pid);

    /**
     * 根据段落id查询段落信息
     * @param id 段落id
     * @return 段落信息
     */
    Paragraph findParagraphById(int id);

    /**
     * 删除多余段落
     * @param id 段落id
     * @return 返回删除结果
     */
    String deleteParagraph(int id);
}
