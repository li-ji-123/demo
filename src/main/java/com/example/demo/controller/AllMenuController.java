package com.example.demo.controller;


import com.example.demo.entity.AllMenu;
import com.example.demo.pojo.VO.AllMenuVO;
import com.example.demo.service.IAllMenuService;
import com.example.demo.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 总菜单列表 前端控制器
 * </p>
 *
 * @author zqy
 * @since 2022-05-20
 */
@RestController
@RequestMapping("/all-menu")
public class AllMenuController {

    @Autowired
    private IAllMenuService allMenuService;

    @PostMapping("/addNewMenu")
    public HttpResult addNewMenu(@RequestBody AllMenu menu){
        return HttpResult.ok(allMenuService.insertMenu(menu));
    }

    @GetMapping("/getAllMenuList")
    public HttpResult<AllMenuVO> getAllMenuList(){
        return HttpResult.ok(allMenuService.getAllMenuList());
    }

    @PostMapping("/updateMenu")
    public HttpResult updateMenu(@RequestBody AllMenu menu){
        return HttpResult.ok(allMenuService.updateMenu(menu));
    }


}
