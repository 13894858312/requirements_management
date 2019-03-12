package cn.edu.nju.rm.task;

import cn.edu.nju.rm.dao.ProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wangxue
 * 定时任务
 * Created by wangxue on 2019/2/26.
 */
@Slf4j
@Component
public class Quartz {

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 每天0点1秒检查到达截止日期的项目并更新项目状态
     */
    @Scheduled(cron = "1 0 0 * * ?")
    public void checkProjectState() {
        projectMapper.endExpiredCollection();
    }
}
