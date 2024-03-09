package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.Mapper.EventMapper;
import com.crumbling.constants.DomainConstans;
import com.crumbling.domain.Event;
import com.crumbling.domain.ResponseResult;
import com.crumbling.dto.AddEventDto;
import com.crumbling.dto.EventDto;
import com.crumbling.enums.HttpEnum;
import com.crumbling.exception.SystemException;
import com.crumbling.service.EventService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.utils.SecurityUtils;
import com.crumbling.vo.EventDetailVo;
import com.crumbling.vo.EventListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.crumbling.constants.DomainConstans.*;

@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {
    //------------------分类列表--------------------
    @Override
    public ResponseResult eventList(Long type) {
        LambdaQueryWrapper<Event> wrapper = new LambdaQueryWrapper<>();
        //如果有输入type，则需要筛选
        wrapper.eq(Objects.nonNull(type) && type > 0, Event::getType, type);
        //要加个排序，主要是按照活动时间排序
        Page<Event> page = new Page<>(EVENT_STATUS_CURRENT, EVENT_STATUS_SIZE);
        page(page, wrapper);
        List<Event> events = page.getRecords();
        List<EventListVo> eventListVos = BeanCopyUtils.copyBeanList(events, EventListVo.class);
        return ResponseResult.okResult(eventListVos);
    }

    //-----------------详情------------------
    @Override
    public ResponseResult getEventDetail(Long id) {
        Event event = getById(id);
        EventDetailVo eventDetailVo = BeanCopyUtils.copyBean(event, EventDetailVo.class);
        return ResponseResult.okResult(eventDetailVo);
    }

    //--------------添加活动-------------
    @Autowired
    private EventService eventService;

    @Override
    public ResponseResult add(AddEventDto addEventDto) {
        Long id = SecurityUtils.getUserId();
        if (id!= ADMIN_ID){
            throw new SystemException(HttpEnum.ADMINUSER_ERROR);
        }
        Event event = BeanCopyUtils.copyBean(addEventDto, Event.class);
        event.setSubscribersCount(DomainConstans.EVENT_ADD_COUNT);
        eventService.save(event);
        return ResponseResult.okResult();
    }

    //-------------删除------------
    @Override
    public ResponseResult delete(Long id) {
        Long userId = SecurityUtils.getUserId();
        if (userId!= ADMIN_ID){
            throw new SystemException(HttpEnum.ADMINUSER_ERROR);
        }
        eventService.removeById(id);
        return ResponseResult.okResult();
    }

    //-------------修改--------------
    @Override
    public ResponseResult edit(EventDto eventDto) {
        Long id = SecurityUtils.getUserId();
        if (id!= ADMIN_ID){
            throw new SystemException(HttpEnum.ADMINUSER_ERROR);
        }
        Event event = BeanCopyUtils.copyBean(eventDto, Event.class);
        updateById(event);
        return ResponseResult.okResult();
    }
}
