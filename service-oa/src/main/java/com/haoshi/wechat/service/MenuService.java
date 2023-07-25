package com.haoshi.wechat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.haoshi.model.wechat.Menu;
import com.haoshi.vo.wechat.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author haoshi
 * @since 2023-06-23
 */
public interface MenuService extends IService<Menu> {

    List<MenuVo> findMenuInfo();

    void syncMenu();
    void removeMenu();
}
