package com.example.demo.pojo.VO;

import com.example.demo.pojo.MenuPojo;
import lombok.Data;

import java.util.List;

@Data
public class MenuVO {
    private Integer mainMenuId;
    private String mainMenuName;
    private List<MenuPojo> subMenuList;
}
