package com.haoshi.process.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoshi.vo.process.ProcessQueryVo;
import com.haoshi.vo.process.ProcessVo;
import org.apache.ibatis.annotations.Param;
import com.haoshi.model.process.Process;

/**
 * <p>
 * 审批类型 Mapper 接口
 * </p>
 *
 * @author haoshi
 * @since 2023-06-19
 */
public interface OaProcessDao extends BaseMapper<Process> {
    IPage<ProcessVo> selectPage(Page<ProcessVo> pageParam, @Param("vo") ProcessQueryVo processQueryVo);
}
