package com.haoshi.process.service.impl;


import com.haoshi.auth.service.SysUserService;
import com.haoshi.model.process.ProcessRecord;
import com.haoshi.model.system.SysUser;
import com.haoshi.process.dao.OaProcessRecordDao;
import com.haoshi.process.service.OaProcessRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haoshi.security.custom.LoginUserInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批记录 服务实现类
 * </p>
 *
 * @author haoshi
 * @since 2023-06-19
 */
@Service
public class OaProcessRecordServiceImpl extends ServiceImpl<OaProcessRecordDao, ProcessRecord> implements OaProcessRecordService {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public void record(Long processId, Integer status, String description) {
        Long userId = LoginUserInfoHelper.getUserId();
        SysUser sysUser = sysUserService.getById(userId);
        ProcessRecord processRecord = new ProcessRecord();
        processRecord.setProcessId(processId);
        processRecord.setStatus(status);
        processRecord.setDescription(description);
        processRecord.setOperateUser(sysUser.getName());
        processRecord.setOperateUserId(userId);
        baseMapper.insert(processRecord);
    }
}
