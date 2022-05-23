package com.example.demo.entity;

import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 个人信息表
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Person对象", description="个人信息表")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "姓名")
    private String username;

    @ApiModelProperty(value = "0:未填写  1:男  2:女")
    private Integer gender;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "详细地址")
    private String address;


}
