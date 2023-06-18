package com.haoshi.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.haoshi.model.system.SysUser;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author haoshi
 * @since 2023-06-15
 */
public interface SysUserService extends IService<SysUser> {
    void updateStatus(Long id, Integer status);
    //根据用户名进行查询
    SysUser getUserByUserName(String username);

    Map<String, Object> getCurrentUser();

}
