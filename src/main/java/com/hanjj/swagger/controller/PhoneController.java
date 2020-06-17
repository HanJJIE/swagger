package com.hanjj.swagger.controller;

import com.hanjj.swagger.annotation.ApiGroup;
import com.hanjj.swagger.constant.ApiGroupConstant;
import com.hanjj.swagger.pojo.Phone;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ApiGroup(group = {ApiGroupConstant.PHONE})
@Api(tags = "手机相关接口")
@RestController
@RequestMapping("/api")
public class PhoneController {

    private static final List<Phone> phones = new ArrayList<>();

    private Phone getPhoneById(Integer id) {
        for (Phone phone : phones) {
            if (phone.getId().equals(id)) return phone;
        }
        return null;
    }

    private void deleteById(Integer id) {
        for (Phone phone : phones) {
            if (phone.getId().equals(id)) {
                phones.remove(phone);
            }
        }
    }

    static {
        for (int i = 4; i <= 14; i++) {
            phones.add(new Phone(i, "iPhone" + i, i));
        }
    }

    /**
     * 获取所有手机信息
     */
    @ApiOperation("获取所有手机信息")
    @GetMapping("/phone")
    public List<Phone> get() {
        return phones;
    }

    /**
     * 根据 ID 获取手机信息
     */
    @ApiOperation("根据 ID 获取手机信息")
    @GetMapping("/phone/{id}")
    public Phone get(@PathVariable(name = "id") Integer id) {
        return getPhoneById(id);
    }

    /**
     * 添加手机
     */
    @PostMapping("/phone")
    @ApiOperation("添加手机")
    public String create(@ApiParam("使用手机实体类添加手机") @RequestBody Phone phone) {
        try {
            phones.add(phone);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 根据 ID 删除手机
     */
    @ApiOperation("根据 ID 删除手机")
    @DeleteMapping("/phone/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        try {
            deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 根据 ID 修改手机信息
     */
    @ApiOperation("根据 ID 修改手机信息")
    @PutMapping("/phone")
    public String update(@RequestBody Phone phone) {
        try {
            deleteById(phone.getId());
            phones.add(phone);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
