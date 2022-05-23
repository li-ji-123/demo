package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 子菜单
 * </p>
 *
 * @author zqy
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SubMenu对象", description="子菜单")
public class SubMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "子菜单名称")
    private String subMenuName;

    @ApiModelProperty(value = "主菜单id")
    private Integer mainMenuId;

    @ApiModelProperty(value = "排序:越小等级更高")
    private Integer sort;

    @ApiModelProperty(value = "0:展示  1:不展示")
    private Integer isShow;

    @ApiModelProperty(value = "0:未删除  1:删除")
    private Integer isDelete;


}
