package com.haoshi.process.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.haoshi.model.process.ProcessRecord;

/**
 * <p>
 * 审批记录 服务类
 * </p>
 *
 * @author haoshi
 * @since 2023-06-19
 */
public interface OaProcessRecordService extends IService<ProcessRecord> {
    void record(Long processId,Integer status,String description);

}
