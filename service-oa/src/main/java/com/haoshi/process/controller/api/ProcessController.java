package com.haoshi.process.controller.api;

import com.haoshi.auth.service.SysUserService;
import com.haoshi.common.result.Result;
import com.haoshi.model.process.Process;
import com.haoshi.model.process.ProcessTemplate;
import com.haoshi.model.process.ProcessType;
import com.haoshi.process.service.OaProcessService;
import com.haoshi.process.service.OaProcessTemplateService;
import com.haoshi.process.service.OaProcessTypeService;
import com.haoshi.vo.process.ApprovalVo;
import com.haoshi.vo.process.ProcessFormVo;
import com.haoshi.vo.process.ProcessVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="/admin/process")
@CrossOrigin //跨域
public class ProcessController {

    @Autowired
    private OaProcessTypeService processTypeService;

    @Autowired
    private OaProcessTemplateService processTemplateService;

    @Autowired
    private OaProcessService processService;

    @Autowired
    private SysUserService sysUserService;


    @GetMapping("/findPending/{page}/{limit}")
    public Result findPending(
            @PathVariable Long page,
            @PathVariable Long limit) {
        Page<Process> pageParam = new Page<>(page,limit);
        IPage<ProcessVo> pageModel = processService.findfindPending(pageParam);
        return Result.ok(pageModel);
    }


    @PostMapping("/startUp")
    public Result startUp(@RequestBody ProcessFormVo processFormVo) {
        processService.startUp(processFormVo);
        return Result.ok();
    }

    //获取审批模板数据
    @GetMapping("getProcessTemplate/{processTemplateId}")
    public Result getProcessTemplate(@PathVariable Long processTemplateId) {
        ProcessTemplate processTemplate = processTemplateService.getById(processTemplateId);
        return Result.ok(processTemplate);
    }

    //查询所有审批分类和每个分类所有审批模板
    @GetMapping("findProcessType")
    public Result findProcessType() {
        List<ProcessType> list = processTypeService.findProcessType();
        return Result.ok(list);
    }

    //查看审批详情信息
    @GetMapping("show/{id}")
    public Result show(@PathVariable Long id) {
        Map<String,Object> map = processService.show(id);
        return Result.ok(map);
    }

    //审批
    @PostMapping("approve")
    public Result approve(@RequestBody ApprovalVo approvalVo) {
        processService.approve(approvalVo);
        return Result.ok();
    }


    @GetMapping("/findProcessed/{page}/{limit}")
    public Result findProcessed(
            @PathVariable Long page,
            @PathVariable Long limit) {
        Page<Process> pageParam = new Page<>(page,limit);
        IPage<ProcessVo> pageModel = processService.findProcessed(pageParam);
        return Result.ok(pageModel);
    }


    @GetMapping("/findStarted/{page}/{limit}")
    public Result findStarted(
            @PathVariable Long page,
            @PathVariable Long limit) {
        Page<ProcessVo> pageParam = new Page<>(page, limit);
        IPage<ProcessVo> pageModel = processService.findStarted(pageParam);
        return Result.ok(pageModel);
    }

    @GetMapping("getCurrentUser")
    public Result getCurrentUser() {
        Map<String,Object> map = sysUserService.getCurrentUser();
        return Result.ok(map);
    }
}
