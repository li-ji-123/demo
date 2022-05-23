package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.SystemTable;
import com.example.demo.mapper.SystemMapper;
import com.example.demo.service.ISystemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统表 服务实现类
 * </p>
 *
 * @author zqy
 * @since 2022-05-21
 */
@Service
public class SystemServiceImpl extends ServiceImpl<SystemMapper, SystemTable> implements ISystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public List<SystemTable> getAllSystemList() {
        List<SystemTable> systemTableList = systemMapper.selectList(new QueryWrapper<SystemTable>().eq("is_delete",0));
        return systemTableList;
    }
}
