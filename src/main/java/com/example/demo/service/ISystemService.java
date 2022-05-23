package com.example.demo.service;

import com.example.demo.entity.SystemTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统表 服务类
 * </p>
 *
 * @author zqy
 * @since 2022-05-21
 */
public interface ISystemService extends IService<SystemTable> {

    List<SystemTable> getAllSystemList();
}
