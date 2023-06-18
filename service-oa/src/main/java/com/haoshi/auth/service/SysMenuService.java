package com.haoshi.auth.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.haoshi.model.system.SysMenu;
import com.haoshi.vo.system.AssginMenuVo;
import com.haoshi.vo.system.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author haoshi
 * @since 2023-06-16
 */
public interface SysMenuService extends IService<SysMenu> {

    //菜单列表接口
    List<SysMenu> findNodes();

    //删除菜单
    void removeMenuById(Long id);

    //查询所有菜单和角色分配的菜单
    List<SysMenu> findMenuByRoleId(Long roleId);

    //角色分配菜单
    void doAssign(AssginMenuVo assginMenuVo);

    //4 根据用户id获取用户可以操作菜单列表
    List<RouterVo> findUserMenuListByUserId(Long userId);

    //5 根据用户id获取用户可以操作按钮列表
    List<String> findUserPermsByUserId(Long userId);
}
