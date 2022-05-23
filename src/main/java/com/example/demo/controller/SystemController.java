package com.example.demo.controller;


import com.example.demo.service.ISystemService;
import com.example.demo.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统表 前端控制器
 * </p>
 *
 * @author zqy
 * @since 2022-05-21
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private ISystemService systemService;
    @GetMapping("/getAllSystemList")
    public HttpResult getAllSystemList(){
        return HttpResult.ok(systemService.getAllSystemList());
    }

}
