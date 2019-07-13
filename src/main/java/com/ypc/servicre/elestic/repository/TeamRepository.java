package com.ypc.servicre.elestic.repository;

import com.ypc.servicre.elestic.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:04
 * @Description:
 */
@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

}
