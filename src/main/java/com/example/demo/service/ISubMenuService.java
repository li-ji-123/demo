package com.example.demo.service;

import com.example.demo.entity.SubMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 子菜单 服务类
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
public interface ISubMenuService extends IService<SubMenu> {

    List<SubMenu> getSubMenuListByCode(String systemCode);
}
