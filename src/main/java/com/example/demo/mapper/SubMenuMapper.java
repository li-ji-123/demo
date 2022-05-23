package com.example.demo.mapper;

import com.example.demo.entity.SubMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 子菜单 Mapper 接口
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Repository
public interface SubMenuMapper extends BaseMapper<SubMenu> {

    List<SubMenu> getSubMenuListByCode(String systemCode);
}
