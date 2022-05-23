package com.example.demo.service;

import com.example.demo.entity.MainMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.DTO.MenuDTO;
import com.example.demo.pojo.VO.MenuVO;

import java.util.List;

/**
 * <p>
 * 主菜单列表 服务类
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
public interface IMainMenuService extends IService<MainMenu> {
    List<MenuVO> getMenu(String code);

    List<MainMenu> getMainMenu(String systemCode);
}
