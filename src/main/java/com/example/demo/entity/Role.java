package com.example.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Role对象", description="权限表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "权限名称")
    private String role;

    @ApiModelProperty(value = "开关字符串集")
    private String value;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
