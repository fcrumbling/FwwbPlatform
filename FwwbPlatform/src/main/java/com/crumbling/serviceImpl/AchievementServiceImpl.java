package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.mapper.AchievementMapper;
import com.crumbling.domain.Achievement;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.AchievementService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.vo.AchievementListVo;
import com.crumbling.vo.AchievementSourceVo;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.crumbling.constants.DomainConstans.ACHIEVEMENT_STATUS_CURRENT;
import static com.crumbling.constants.DomainConstans.ACHIEVEMENT_STATUS_SIZE;

@Service
public class AchievementServiceImpl extends ServiceImpl<AchievementMapper, Achievement> implements AchievementService {
    @Override
    public ResponseResult achievementList() {
        LambdaQueryWrapper<Achievement> wrapper = new LambdaQueryWrapper<>();
        Page<Achievement> page= new Page<>(ACHIEVEMENT_STATUS_CURRENT,ACHIEVEMENT_STATUS_SIZE);
        page(page,wrapper);
        List<Achievement> achievement = page.getRecords();
        List<AchievementListVo> achievementListVos = BeanCopyUtils.copyBeanList(achievement, AchievementListVo.class);
        return ResponseResult.okResult(achievementListVos);
    }

    @Override
    public ResponseResult achievementDownload(Long id) {
        Achievement achievement = getById(id);
        AchievementSourceVo achievementSourceVo = BeanCopyUtils.copyBean(achievement, AchievementSourceVo.class);
        return ResponseResult.okResult(achievementSourceVo);
    }
}
