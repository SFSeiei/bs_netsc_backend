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
@Table(name = "tb_orderinfo")
@Data
public class OrderInfo {
    @Id
    private int oIId;
    private int orderId;
    private int pId;
    private String pName;
    private int pNumber;
    private float pPrice;
}
