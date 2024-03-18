package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.mapper.EventRegisterMapper;
import com.crumbling.constants.DomainConstans;
import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;
import com.crumbling.domain.Register;
import com.crumbling.enums.HttpEnum;
import com.crumbling.exception.SystemException;
import com.crumbling.service.EventRegisterService;
import com.crumbling.service.EventService;
import com.crumbling.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventRegisterServiceImpl extends ServiceImpl<EventRegisterMapper, Register> implements EventRegisterService {
    //---------活动报名----------
    @Autowired
    private EventService eventService;
    @Override
    public ResponseResult register(Long eventid) {
        Long userId = SecurityUtils.getUserId();
        Register register = getOne(new QueryWrapper<Register>().lambda().
                eq(Register::getEventid,eventid).
                eq(Register::getUserid,userId));
        if(register!=null){
            throw new SystemException(HttpEnum.REGISTER_EXIST);
        }
        Register newregister = new Register();
        newregister.setEventid(eventid);
        newregister.setUserid(userId);
        save(newregister);
        //注入service通过调用mybatisplus相关方法进行数据更新（save只能Register类）
        Event event = eventService.getById(eventid);
        event.setSubscribersCount(event.getSubscribersCount()+ DomainConstans.EVENT_REGISTER_ADD);
        eventService.updateById(event);
        //在Register表里检查是否已经选取
        //已选取则报错
        //未选取需要在Event里更新报名人数，在Register里添加报名记录
        return ResponseResult.okResult();
    }
}
