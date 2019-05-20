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
@Table(name = "tb_trolley")
@Data
public class Trolley {
    @Id
    private int tId;
    private int pId;
    private String uId;
    private int pNumber;
    private float pPrice;
    private String getPTime;
    private String pName;
    private int sId;
}
