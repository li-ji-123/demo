package com.example.demo.service.impl;

import com.example.demo.entity.SubMenu;
import com.example.demo.mapper.SubMenuMapper;
import com.example.demo.service.ISubMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 子菜单 服务实现类
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Service
public class SubMenuServiceImpl extends ServiceImpl<SubMenuMapper, SubMenu> implements ISubMenuService {

    @Autowired
    private SubMenuMapper subMenuMapper;

    @Override
    public List<SubMenu> getSubMenuListByCode(String systemCode) {
        List<SubMenu> subMenuList = subMenuMapper.getSubMenuListByCode(systemCode);
        return subMenuList;
    }
}
