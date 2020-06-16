package com.hanjj.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "手机实体类")
public class Phone {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("价格")
    private Integer price;
}
