package com.hanjj.swagger.controller;

import com.hanjj.swagger.annotation.ApiGroup;
import com.hanjj.swagger.constant.ApiGroupConstant;
import com.hanjj.swagger.pojo.Laptop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@ApiGroup(group = {ApiGroupConstant.LAPTOP})
@Api(tags = "笔记本相关接口")
@RestController
@RequestMapping("/api")
public class LaptopController {

    @ApiOperation("获取所有笔记本信息")
    @GetMapping("/laptop")
    public List<Laptop> laptop() {
        return new ArrayList<>();
    }

}
