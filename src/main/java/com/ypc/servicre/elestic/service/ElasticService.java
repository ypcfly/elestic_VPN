package com.ypc.servicre.elestic.service;

import java.util.Map;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:21
 * @Description:
 */
public interface ElasticService {


    Map<String, Object> addIndex();

    Map<String, Object> addData();
}
