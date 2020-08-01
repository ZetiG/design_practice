package com.example.demo.behavior_type.strategy;

import com.example.demo.behavior_type.strategy.db.TaskDao;
import com.example.demo.behavior_type.strategy.db.UserCompleteTaskLogDao;
import com.example.demo.behavior_type.strategy.db.UserDao;
import com.example.demo.behavior_type.strategy.db.UserIntegralDetailsDao;
import com.example.demo.behavior_type.strategy.entity.Task;
import com.example.demo.behavior_type.strategy.entity.User;
import org.springframework.stereotype.Service;

/**
 * Description:  任务操作抽象类
 *
 * @author Zeti
 * @date 2020/8/1 10:45 上午
 */
@Service
public abstract class AbstractTaskOperate extends AbstractTask implements IntegralOperation {
    private static final long serialVersionUID = 8020659335426062538L;

    private static final TaskDao taskDao = new TaskDao();

    private static final UserCompleteTaskLogDao completeTaskLogDao = new UserCompleteTaskLogDao();

    private static final UserDao userDao = new UserDao();

    private static final UserIntegralDetailsDao userIntegralDetailsDao = new UserIntegralDetailsDao();

    private static final UserCompleteTaskLogDao userCompleteTaskLogDao = new UserCompleteTaskLogDao();


    @Override
    public Integer addIntegral(Long userId) {
        User user = userDao.selectById(userId);
        if (user == null) return 0;

        User user1 = new User();
        user1.setId(userId);
        int addIntegral = user1.getIntegral() + getTask().getAddIntegral();
        user1.setIntegral(addIntegral);
        userDao.update(user1);
        return addIntegral;
    }

    @Override
    public Integer reduceIntegral(Long userId) {
        return null;
    }


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
