package com.crumbling.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crumbling.mapper.ExhibitorMapper;
import com.crumbling.domain.Exhibitor;
import com.crumbling.domain.ResponseResult;
import com.crumbling.service.ExhibitorService;
import com.crumbling.utils.BeanCopyUtils;
import com.crumbling.vo.ExhibitorDetailVo;
import com.crumbling.vo.ExhibitorListVo;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.crumbling.constants.DomainConstans.EXHIBITOR_STATUS_CURRENT;
import static com.crumbling.constants.DomainConstans.EXHIBITOR_STATUS_SIZE;

@Service
public class ExhibitorServiceImpl extends ServiceImpl<ExhibitorMapper, Exhibitor> implements ExhibitorService {
    //-----------------展商详情------------------
    @Override
    public ResponseResult getExhibitorById(Long id){
        Exhibitor exhibitor =getById(id);
        ExhibitorDetailVo exhibitorDetailVo = BeanCopyUtils.copyBean(exhibitor,ExhibitorDetailVo.class);
        return ResponseResult.okResult(exhibitorDetailVo);
    }
    //-----------------展商列表------------------
    @Override
    public ResponseResult exhibitorList() {
        LambdaQueryWrapper<Exhibitor> wrapper = new LambdaQueryWrapper<>();
        Page<Exhibitor> page = new Page<>(EXHIBITOR_STATUS_CURRENT,EXHIBITOR_STATUS_SIZE);
        page(page,wrapper);
        List<Exhibitor> exhibitor =page.getRecords();
        List<ExhibitorListVo> exhibitorListVos=BeanCopyUtils.copyBeanList(exhibitor, ExhibitorListVo.class);
        return ResponseResult.okResult(exhibitorListVos);
    }
}
