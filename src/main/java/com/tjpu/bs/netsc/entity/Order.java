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
@Table(name = "tb_orders")
@Data
public class Order {
    @Id
    private int orderId;
    private String uId;
    private float proPrice;
    private float mPrice;
    private String createTime;
    private String getGWay;
    private String sendGTime;
    private String getGTime;
    private String payWay;
    private String payTime;
    private String oState;
    private String oComment;
    private String getAddress;
    private String linkmanName;
    private Long telphone;
    private int sId;
    private int dId;
    private String dName;
}
