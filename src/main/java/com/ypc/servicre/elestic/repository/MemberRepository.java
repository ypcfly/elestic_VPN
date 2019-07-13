package com.ypc.servicre.elestic.repository;

import com.ypc.servicre.elestic.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:06
 * @Description:
 */
@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> queryAllByTeamId(Long teamId);
}
