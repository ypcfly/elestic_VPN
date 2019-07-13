package com.ypc.servicre.elestic.service.impl;

import com.ypc.servicre.elestic.document.TeamType;
import com.ypc.servicre.elestic.service.ElasticService;
import com.ypc.servicre.elestic.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:22
 * @Description:
 */
@Service
public class ElasticServiceImpl implements ElasticService {

    private static final String TEAM_TYPE_INDEX = "team_index";

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private TeamService teamService;

    @Override
    public Map<String, Object> addIndex() {
        Map<String,Object> resultMap = new HashMap<>();

        if (elasticsearchTemplate.indexExists(TEAM_TYPE_INDEX)) {
            elasticsearchTemplate.deleteIndex(TEAM_TYPE_INDEX);
        }
        elasticsearchTemplate.createIndex(TEAM_TYPE_INDEX);
        elasticsearchTemplate.putMapping(TeamType.class);
        elasticsearchTemplate.refresh(TeamType.class);

        resultMap.put("success",true);
        resultMap.put("message","创建索引成功");
        return resultMap;
    }

    @Override
    public Map<String, Object> addData() {
        Map<String,Object> resultMap = new HashMap<>();

        teamService.addDataToES();

        return resultMap;
    }
}
