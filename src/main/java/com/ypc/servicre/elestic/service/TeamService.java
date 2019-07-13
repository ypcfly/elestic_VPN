package com.ypc.servicre.elestic.service;

import java.util.Map;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:33
 * @Description:
 */
public interface TeamService {
    void addDataToES();

    Map<String, Object> queryMembers(Integer teamId);
}
