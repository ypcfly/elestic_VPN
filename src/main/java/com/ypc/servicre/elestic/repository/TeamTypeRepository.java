package com.ypc.servicre.elestic.repository;

import com.ypc.servicre.elestic.document.TeamType;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:25
 * @Description:
 */
@Repository
public interface TeamTypeRepository extends ElasticsearchRepository<TeamType,String> {

}
