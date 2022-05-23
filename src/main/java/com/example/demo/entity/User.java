package com.example.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="User对象", description="用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "电话")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "权限id")
    private String roleId;

    @ApiModelProperty(value = "0:未锁定 1:锁定")
    private Integer isLock;

    @ApiModelProperty(value = "0:可用  1:不可用")
    private Integer disabled;

    @ApiModelProperty(value = "0:未删除  1:删除")
    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime upadteTime;


}
