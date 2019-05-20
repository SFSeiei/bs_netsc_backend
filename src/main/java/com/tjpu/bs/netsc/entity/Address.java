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
@Table(name = "tb_address")
@Data
public class Address {
    @Id
    private int addId;
    private String addName;
    private String uId;
    private String linkmanName;
    private Long telphone;
}
