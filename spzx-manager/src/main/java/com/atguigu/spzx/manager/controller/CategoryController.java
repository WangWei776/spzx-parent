package com.atguigu.spzx.manager.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.atguigu.spzx.manager.service.CategoryService;
import com.atguigu.spzx.model.entity.product.Category;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/importData")
    public Result  importData(MultipartFile file){
        categoryService.importData(file);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("exportData")
    public void  exportData(HttpServletResponse response){
        categoryService.exportData(response);
    }

    @Operation(summary = "根据parentId获取下级节点")
    @GetMapping(value = "/findByParentId/{parentId}")
    public Result findByParentId(@PathVariable Long parentId){
        List<Category> list = categoryService.findByParentId(parentId);
        return Result.build(list, ResultCodeEnum.SUCCESS);
    }
}