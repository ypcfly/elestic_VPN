package com.ypc.servicre.elestic.service.impl;

import com.ypc.servicre.elestic.document.MemberType;
import com.ypc.servicre.elestic.document.TeamType;
import com.ypc.servicre.elestic.model.Member;
import com.ypc.servicre.elestic.model.Team;
import com.ypc.servicre.elestic.repository.MemberRepository;
import com.ypc.servicre.elestic.repository.TeamRepository;
import com.ypc.servicre.elestic.repository.TeamTypeRepository;
import com.ypc.servicre.elestic.service.TeamService;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 21:33
 * @Description:
 */
@Service
public class TeamServiceImpl implements TeamService {

    private static final String TEAM_TYPE_INDEX = "team_index";

    private static final String TEAM_TYPE = "team_type";

    private static final String TEAM_MEMBER_INDEX = "member_index";

    private static final String TEAM_MEMBER_PATH = "memberTypes";

    private static final String MEMBER_CAPTAIN = "memberTypes.captain";

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamTypeRepository teamTypeRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void addDataToES() {
        List<Team> teamList = teamRepository.findAll();

        for(Team team : teamList) {
            List<Member> memberList = memberRepository.queryAllByTeamId(team.getId());
            List<MemberType> memberTypeList = toTypeList(memberList);

            TeamType teamType = new TeamType(team,memberTypeList);
            teamTypeRepository.save(teamType);
            teamTypeRepository.refresh();
        }

    }

    @Override
    public Map<String, Object> queryMembers(Integer teamId) {
        Map<String,Object> resultMap = new HashMap<>();

        NestedQueryBuilder nestedQueryBuilder =
                new NestedQueryBuilder("memberTypes",termQuery("memberTypes.captain",false),ScoreMode.None);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(termQuery("teamId",teamId)).must(nestedQueryBuilder);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("team_index")
                .withTypes("team_type")
                .withQuery(boolQueryBuilder)
                .build();

        List<TeamType> teamTypeList = new ArrayList<>();
        Iterable<TeamType> teamTypes = teamTypeRepository.search(searchQuery);
        Iterator<TeamType> iterator = teamTypes.iterator();
        while (iterator.hasNext()) {
            TeamType teamType = iterator.next();
            List<MemberType> memberTypeList = teamType.getMemberTypes();

            teamType.setMemberTypes(memberTypeList.stream().filter(m -> !m.isCaptain()).collect(Collectors.toList()));
            teamTypeList.add(teamType);
        }

        resultMap.put("result",teamTypeList);

        return resultMap;
    }

    private List<MemberType> toTypeList(List<Member> memberList) {
        if (memberList != null) {
            List<MemberType> memberTypeList = new ArrayList<>();
            for (Member member : memberList) {
                MemberType memberType = new MemberType(member);

                memberTypeList.add(memberType);
            }
            return memberTypeList;
        }
        return null;
    }
}
