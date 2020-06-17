package com.hanjj.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("笔记本电脑实体类")
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {
    @ApiModelProperty("处理器")
    private String cpu;
    @ApiModelProperty("内存")
    private String ram;
    @ApiModelProperty("硬盘")
    private String rom;
}
