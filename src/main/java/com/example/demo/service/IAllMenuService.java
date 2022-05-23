package com.example.demo.service;

import com.example.demo.entity.AllMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.VO.AllMenuVO;

import java.util.List;

/**
 * <p>
 * 总菜单列表 服务类
 * </p>
 *
 * @author zqy
 * @since 2022-05-20
 */
public interface IAllMenuService extends IService<AllMenu> {

    String insertMenu(AllMenu menu);

    AllMenuVO getAllMenuList();

    String updateMenu(AllMenu menu);

}
