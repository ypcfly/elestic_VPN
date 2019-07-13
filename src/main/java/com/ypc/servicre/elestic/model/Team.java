package com.ypc.servicre.elestic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * @Author: ypcfly
 * @Date: 19-7-9 20:49
 * @Description:
 */
@Entity
@Data
@Table(name = "t_team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String skuCode;

    @Column
    private String ownerId;

    @Column
    private String status;

    @Column
    private Integer needAmount;

    @Column
    private Date createTime;

    @Column
    private Date updateTime;

}
