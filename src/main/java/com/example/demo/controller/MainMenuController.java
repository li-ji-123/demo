package com.example.demo.controller;


import com.example.demo.service.IMainMenuService;
import com.example.demo.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 主菜单列表 前端控制器
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@RestController
@RequestMapping("/main-menu")
public class MainMenuController {

    @Autowired
    private IMainMenuService mainMenuService;

    /**
     * 获取菜单列表
     * 1.需要通过用户登录,获取使用者的系统编码;
     * 考虑.....
     * 2.通过系统编码和用户权限进行菜单缓存;
     * @return
     */
    @GetMapping("/getMenu")
    public HttpResult getMenu(){
        String code = "0000";
        return HttpResult.ok(mainMenuService.getMenu(code));
    }

    @GetMapping("/getMainMenu")
    public HttpResult getMainMenu(@RequestParam("systemCode")String systemCode){
        return HttpResult.ok(mainMenuService.getMainMenu(systemCode));
    }

}
