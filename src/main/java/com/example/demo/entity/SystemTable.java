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
 * 系统表
 * </p>
 *
 * @author zqy
 * @since 2022-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="System_table对象", description="系统表")
public class SystemTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "系统名称")
    private String systemName;

    @ApiModelProperty(value = "系统编码")
    private String systemCode;

    private Integer isDelete;

    private LocalDateTime createTime;


}
