package com.haoshi.auth.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.haoshi.auth.dao.SysUserDao;
import com.haoshi.auth.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haoshi.model.system.SysUser;
import com.haoshi.security.custom.LoginUserInfoHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author haoshi
 * @since 2023-06-15
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    @Override
    public void updateStatus(Long id, Integer status) {
        //根据userid查询用户对象
        SysUser sysUser = baseMapper.selectById(id);
        //设置修改状态值
        sysUser.setStatus(status);
        //调用方法进行修改
        baseMapper.updateById(sysUser);
    }

    //根据用户名进行查询
    @Override
    public SysUser getUserByUserName(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = baseMapper.selectOne(wrapper);
        return sysUser;
    }

    @Override
    public Map<String, Object> getCurrentUser() {
        SysUser sysUser = baseMapper.selectById(LoginUserInfoHelper.getUserId());
        Map<String, Object> map = new HashMap<>();
        map.put("name", sysUser.getName());
        map.put("phone", sysUser.getPhone());
        return map;
    }
}
