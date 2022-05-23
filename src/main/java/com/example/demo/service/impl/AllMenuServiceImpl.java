package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.AllMenu;
import com.example.demo.mapper.AllMenuMapper;
import com.example.demo.pojo.VO.AllMenuVO;
import com.example.demo.service.IAllMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 总菜单列表 服务实现类
 * </p>
 *
 * @author zqy
 * @since 2022-05-20
 */
@Service
public class AllMenuServiceImpl extends ServiceImpl<AllMenuMapper, AllMenu> implements IAllMenuService {

    @Autowired
    private AllMenuMapper allMenuMapper;

    @Override
    public String insertMenu(AllMenu menu) {
        LocalDateTime time = LocalDateTime.now();
        menu.setCreateTime(time);
        menu.setUpdateTime(time);
        int i = allMenuMapper.insert(menu);
        return i+"";
    }

    @Override
    public AllMenuVO getAllMenuList() {
        List<AllMenu> main = allMenuMapper.selectList(new QueryWrapper<AllMenu>().eq("is_delete",0).eq("menu_type",1));
        List<AllMenu> sub = allMenuMapper.selectList(new QueryWrapper<AllMenu>().eq("is_delete",0).eq("menu_type",2));

        AllMenuVO allMenuVO = new AllMenuVO();
        allMenuVO.setMainMenu(main);
        allMenuVO.setSubMenu(sub);
        return allMenuVO;
    }

    @Override
    public String updateMenu(AllMenu menu) {
        int i = allMenuMapper.updateById(menu);
        return i+"";
    }


}
