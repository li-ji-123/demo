package com.example.demo.controller;


import com.example.demo.service.ISubMenuService;
import com.example.demo.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 子菜单 前端控制器
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@RestController
@RequestMapping("/sub-menu")
public class SubMenuController {

    @Autowired
    private ISubMenuService subMenuService;

    @GetMapping("/getSubMenuListByCode")
    public HttpResult getSubMenuListByCode(@RequestParam("systemCode")String systemCode){
        return HttpResult.ok(subMenuService.getSubMenuListByCode(systemCode));
    }

}
