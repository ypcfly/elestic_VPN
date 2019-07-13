package com.ypc.servicre.elestic.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ypc.servicre.elestic.model.Member;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 20:58
 * @Description:
 */
public class MemberType {

    @Id
    @Field(type = FieldType.Keyword, store = true)
    private String id;

    @Field(type = FieldType.Keyword, store = true)
    private String teamId;

    @Field(type = FieldType.Keyword, store = true)
    private String userId;

    @Field(type = FieldType.Boolean, store = true)
    private boolean captain;

    @Field(type = FieldType.Keyword, store = true)
    private String orderId;

    @Field(type = FieldType.Date, store = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createTime;

    @Field(type = FieldType.Date, store = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date updateTime;

    public MemberType(Member member) {
        this.id = member.getId().toString();
        this.orderId = member.getOrderId();
        this.captain = member.isCaptain();
        this.userId = member.getUserId();
        this.createTime = member.getCreateTime();
        this.updateTime = member.getUpdateTime();
        this.teamId = member.getTeamId().toString();
    }

    public MemberType() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isCaptain() {
        return captain;
    }

    public void setCaptain(boolean captain) {
        this.captain = captain;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
