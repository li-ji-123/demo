package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 总菜单列表
 * </p>
 *
 * @author zqy
 * @since 2022-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AllMenu对象", description="总菜单列表")
public class AllMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "1:主菜单  2:子菜单")
    private Integer menuType;

    @ApiModelProperty(value = "父级菜单id")
    private Integer parentMenuId;

    @ApiModelProperty(value = "父级菜单名称")
    private String parentMenuName;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "0:启用  1:禁用")
    private Integer disable;

    @ApiModelProperty(value = "0:未删除  1:删除")
    private Integer isDelete;

    @ApiModelProperty(value = "创建人")
    private String createName;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
