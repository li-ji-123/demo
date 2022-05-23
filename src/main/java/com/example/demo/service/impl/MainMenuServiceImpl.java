package com.example.demo.service.impl;

import com.example.demo.entity.MainMenu;
import com.example.demo.mapper.MainMenuMapper;
import com.example.demo.pojo.DTO.MenuDTO;
import com.example.demo.pojo.MenuPojo;
import com.example.demo.pojo.VO.MenuVO;
import com.example.demo.service.IMainMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 主菜单列表 服务实现类
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Slf4j
@Service
public class MainMenuServiceImpl extends ServiceImpl<MainMenuMapper, MainMenu> implements IMainMenuService {
    @Autowired
    private MainMenuMapper mainMenuMapper;

    @Override
    public List<MenuVO> getMenu(String code) {

        List<MenuVO> menuVOList = new ArrayList<>();
        List<MenuDTO> menuDTOList = mainMenuMapper.getMenu(code);
        int check = 0;
        List<MenuPojo> subMenuList = new ArrayList<>();
        MenuVO menuVO = new MenuVO();

        for (MenuDTO dto : menuDTOList){

            if (check == dto.getMainMenuId()) {
                //子菜单添加
                MenuPojo pojo = new MenuPojo();
                pojo.setMenuId(dto.getSubMenuId());
                pojo.setMenuName(dto.getSubMenuName());
                subMenuList.add(pojo);
            }else {
                if (check > 0) {
                    menuVO.setSubMenuList(subMenuList);
                    menuVOList.add(menuVO);
                }
                //初始化
                subMenuList = new ArrayList<>();
                MenuVO vo = new MenuVO();
                vo.setMainMenuId(dto.getMainMenuId());
                vo.setMainMenuName(dto.getMainMenuName());

                MenuPojo pojo = new MenuPojo();
                pojo.setMenuId(dto.getSubMenuId());
                pojo.setMenuName(dto.getSubMenuName());

                subMenuList.add(pojo);
                menuVO = vo;
                //判断是否同一主菜单
                check = dto.getMainMenuId();

            }
        }
        //最后一条,进行手动数据添加
        menuVO.setSubMenuList(subMenuList);
        menuVOList.add(menuVO);

        return menuVOList;
    }

    @Override
    public List<MainMenu> getMainMenu(String systemCode) {
        List<MainMenu> mainMenus = mainMenuMapper.getMainMenus(systemCode);
        mainMenus.forEach(menu -> menu.setOver(false));
        return mainMenus;
    }
}
