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
@Table(name = "tb_products")
@Data
public class Product {
    @Id
    private int pId;
    private int bCId;
    private String pName;
    private String bCName;
    private int sId;
    private String pState;
    private String pReleaseTime;
    private String pPhoto;
    private float pPrice;
    private float pMemPrice;
    private String pDescribe;
    private String sellTime;
    private String overTime;
    private String sName;
}
