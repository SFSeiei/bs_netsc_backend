package com.tjpu.bs.netsc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_shops")
@Data
public class Shop {
    @Id
    private int sId;
    private String sName;
    private String bScope;
    private String shopMan;
    private Long shopManTel;
    private String shopState;
    private String sRegisteTime;
    private String sDescribe;
    private String sPayDescribe;
    private String deliveryDescribe;
    private String uId;
    private String sPayNumber;
    private String sAddress;
}
