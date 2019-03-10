package cn.edu.nju.rm.service.impl.paragraph;

import cn.edu.nju.rm.dao.ParagraphMapper;
import cn.edu.nju.rm.model.Paragraph;
import cn.edu.nju.rm.service.paragraph.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: nananer7
 * @Description:
 * @Date: 2019/3/10 16:44
 */
@Transactional(rollbackFor = Exception.class)
@Service("ParagraphService")
public class ParagraphServiceImpl implements ParagraphService {

    @Autowired
    ParagraphMapper paragraphMapper;

    /**
     *
     * @param paragraph 段落信息
     * @return
     */
    @Override
    public String addParagraph(Paragraph paragraph) {
        return null;
    }

    /**
     *
     * @param paragraph 段落信息
     * @return
     */

    @Override
    public String modifyParagraph(Paragraph paragraph) {
        return null;
    }

    /**
     *
     * @param pid 项目id
     * @return
     */
    @Override
    public List<Paragraph> findParagraphByPid(int pid) {
        return null;
    }

    /**
     *
     * @param id 段落id
     * @return
     */
    @Override
    public Paragraph findParagraphById(int id) {
        return null;
    }

    /**
     *
     * @param id 段落id
     * @return
     */
    @Override
    public String deleteParagraph(int id) {
        return null;
    }
}
