package com.ypc.servicre.elestic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: ypcfly
 * @Date: 19-7-9 20:54
 * @Description:
 */
@Data
@Entity
@Table(name = "t_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long teamId;

    @Column
    private String userId;

    @Column
    private boolean captain;

    @Column
    private String orderId;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;
}
