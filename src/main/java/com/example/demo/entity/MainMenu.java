package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 主菜单列表
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MainMenu对象", description="主菜单列表")
public class MainMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "主菜单名称")
    private String mainMenuName;

    @ApiModelProperty(value = "系统编码")
    private String systemCode;

    @ApiModelProperty(value = "排序:越小等级更高")
    private Integer sort;

    @ApiModelProperty(value = "0:开启  1:隐藏")
    private Integer disable;

    @ApiModelProperty(value = "0:未删除  1:删除")
    private Integer isDelete;

    @TableField(exist = false)
    private boolean isOver;


}
