package com.ypc.servicre.elestic.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ypc.servicre.elestic.model.Team;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 20:57
 * @Description:
 */
@Document(indexName = "team_index",type = "team_type", shards = 2, replicas = 1,createIndex = false)
public class TeamType {

    @Id
    @Field(type = FieldType.Keyword, store = true)
    private String id;

    @Field(type = FieldType.Keyword, store = true)
    private Long teamId;

    @Field(type = FieldType.Nested, store = true)
    private List<MemberType> memberTypes;

    @Field(type = FieldType.Keyword, store = true)
    private String skuCode;

    @Field(type = FieldType.Keyword, store = true)
    private String ownerId;

    @Field(type = FieldType.Keyword, store = true)
    private String status;

    @Field(type = FieldType.Integer, store = true)
    private Integer needAmount;

    @Field(type = FieldType.Date, store = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createTime;

    @Field(type = FieldType.Date, store = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date updateTime;

    public TeamType(Team team, List<MemberType> memberList) {
        this.id = team.getId().toString();
        this.teamId = team.getId();
        this.skuCode = team.getSkuCode();
        this.createTime = team.getCreateTime();
        this.updateTime = team.getUpdateTime();
        this.needAmount = team.getNeedAmount();
        this.ownerId = team.getOwnerId();
        this.status = team.getStatus();

        this.memberTypes = memberList;
    }

    public TeamType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public List<MemberType> getMemberTypes() {
        return memberTypes;
    }

    public void setMemberTypes(List<MemberType> memberTypes) {
        this.memberTypes = memberTypes;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(Integer needAmount) {
        this.needAmount = needAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
