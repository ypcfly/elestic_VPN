package com.ypc.servicre.elestic.controller;

import com.ypc.servicre.elestic.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:19
 * @Description:
 */
@RestController
@RequestMapping("/es")
public class ElasticController {

    @Autowired
    private ElasticService elasticService;

    @GetMapping("/index")
    public Map<String,Object> index() {

        return elasticService.addIndex();
    }

    @GetMapping("/data")
    public Map<String,Object> addData() {
        return elasticService.addData();
    }

}
