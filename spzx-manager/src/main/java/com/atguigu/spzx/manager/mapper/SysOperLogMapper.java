package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

// com.atguigu.spzx.manager.mapper;
@Mapper
public interface SysOperLogMapper {
    public abstract void insert(SysOperLog sysOperLog);
}