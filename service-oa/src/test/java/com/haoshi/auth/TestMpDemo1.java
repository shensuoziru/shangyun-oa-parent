package com.haoshi.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haoshi.auth.dao.SysRoleDao;
import com.haoshi.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMpDemo1 {
    @Autowired
    private SysRoleDao dao;

    @Test
    public void testGetAll(){
        List<SysRole> sysRoles = dao.selectList(null);
        System.out.println(sysRoles);
    }

    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int result = dao.insert(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole.getId()); //id自动回填
    }

    //修改操作
    @Test
    public void update() {
        //根据id查询
        SysRole role = dao.selectById(10);
        //设置修改值
        role.setRoleName("atguigu角色管理员");
        //调用方法实现最终修改
        int rows = dao.updateById(role);
        System.out.println(rows);
    }

    @Test
    public void testUpdateById(){
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setRoleName("角色管理员1");

        int result = dao.updateById(sysRole);
        System.out.println(result);
    }

    @Test
    public void testDeleteById(){
        int result = dao.deleteById(9L);
        System.out.println(result);
    }

    @Test
    public void testDeleteBatchIds() {
        int result = dao.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    //条件查询
    @Test
    public void testQuery1() {
        //创建QueryWrapper对象，调用方法封装条件
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name","角色管理员1");
        //调用mp方法实现查询操作
        List<SysRole> list = dao.selectList(wrapper);
        System.out.println(list);
    }

    @Test
    public void testQuery2() {
        //LambdaQueryWrapper，调用方法封装条件
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName,"角色管理员1");
        //调用mp方法实现查询操作
        List<SysRole> list = dao.selectList(wrapper);
        System.out.println(list);
    }
}
