package com.example.demo.behavior_type.strategy;

import com.example.demo.behavior_type.strategy.db.TaskDao;
import com.example.demo.behavior_type.strategy.db.UserCompleteTaskLogDao;
import org.springframework.stereotype.Service;

/**
 * Description:  任务操作抽象类
 *
 * @author Zeti
 * @date 2020/8/1 10:45 上午
 */
@Service
public abstract class AbstractTaskOperate extends Task {
    private static final long serialVersionUID = 8020659335426062538L;

    private static final TaskDao taskDao = new TaskDao();

    private static final UserCompleteTaskLogDao completeTaskLogDao = new UserCompleteTaskLogDao();


    /**
     * 任务是否启用
     *
     * @return
     */
    public boolean isEnable() {
        Integer isSelect = getTask().getIsSelect();
        if (isSelect == null) {
            return false;
        }
        return isSelect == 1;
    }

    /**
     * 查询当前任务增加的积分值
     *
     * @return
     */
    public Integer getTaskIntegral() {
        return getTask().getAddIntegral();
    }

    /**
     * 任务是否完成
     *
     * @return
     */
    public boolean isCompleteTask() {
        Integer integer = completeTaskLogDao.selectCompleteLogByType(this.getTaskType().getCode());
        return getTaskTotalFrequency() >= integer;
    }

    /**
     * 查询任务可执行总次数
     *
     * @return
     */
    public Integer getTaskTotalFrequency() {
        return getTask().getUpperLimit();
    }

    /**
     * 查询该任务信息
     *
     * @return
     */
    private Task getTask() {
        return taskDao.selectByType(super.getTaskType().getCode());
    }


}
