package com.weyoung.wxapp.welfare.controller;

import com.weyoung.wxapp.common.domain.JsonResult;
import com.weyoung.wxapp.common.domain.UploadFileResponse;
import com.weyoung.wxapp.common.service.FileService;
import com.weyoung.wxapp.common.util.HttpContextUtils;
import com.weyoung.wxapp.common.util.ResponseUtil;
import com.weyoung.wxapp.common.util.SendEmailUtil;
import com.weyoung.wxapp.common.util.SendSmsUtil;
import com.weyoung.wxapp.welfare.domain.Orders;
import com.weyoung.wxapp.welfare.domain.Repair;
import com.weyoung.wxapp.welfare.service.RepairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author li
 * @date 2019-12-5
 */
@Api(tags = "用户预约")
@RequestMapping("repair")
@RestController
public class RepairController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    RepairService repairService;
    @Autowired
    private FileService fileService;
    @Autowired
    private JavaMailSender mailSender;
    @ApiOperation("下单")
    @PostMapping("/repair")
    @ResponseBody
    public JsonResult repair(Repair repair) throws Exception {
        repairService.repair(repair);
        SendSmsUtil.Send(repair.getRepairType(), repair.getUserName(), repair.getTel(), repair.getAddress());
        String repairType = repair.getRepairType();
        if (repair.getDescription() != null && repair.getDescription() != ""){
            repairType += "--" + repair.getDescription();
        }
//        SendEmailUtil.send(mailSender, "维修", repairType,
//                repair.getTel(), repair.getUserName(), repair.getAddress());
        return ResponseUtil.ok();
    }

    @PostMapping("/img")
    @ResponseBody
    public UploadFileResponse upload(@RequestParam("file") MultipartFile file) {
        String fileName = fileService.storeFile(file);

        String fileDownloadUri = HttpContextUtils.guessDownloadUrl(fileName);
        logger.info(fileDownloadUri);

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

}
