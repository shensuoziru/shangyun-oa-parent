package com.haoshi.wechat.controller;


import com.haoshi.common.result.Result;
import com.haoshi.model.wechat.Menu;
import com.haoshi.vo.wechat.MenuVo;
import com.haoshi.wechat.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author haoshi
 * @since 2023-06-23
 */
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //@PreAuthorize("hasAuthority('bnt.menu.list')")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Menu menu = menuService.getById(id);
        return Result.ok(menu);
    }

    //@PreAuthorize("hasAuthority('bnt.menu.add')")
    @PostMapping("save")
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.menu.update')")
    @PutMapping("update")
    public Result updateById(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.menu.remove')")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.ok();
    }

    //@PreAuthorize("hasAuthority('bnt.menu.list')")
    @GetMapping("findMenuInfo")
    public Result findMenuInfo() {
        return Result.ok(menuService.findMenuInfo());
    }


    @GetMapping("syncMenu")
    public Result createMenu() {
        menuService.syncMenu();
        return Result.ok();
    }

    @DeleteMapping("removeMenu")
    public Result removeMenu() {
        menuService.removeMenu();
        return Result.ok();
    }
}

