package com.example.demo.mapper;

import com.example.demo.entity.MainMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.DTO.MenuDTO;
import com.example.demo.pojo.VO.MenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 主菜单列表 Mapper 接口
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Repository
public interface MainMenuMapper extends BaseMapper<MainMenu> {
    List<MenuDTO> getMenu(String code);

    List<MainMenu> getMainMenus(String systemCode);
}
