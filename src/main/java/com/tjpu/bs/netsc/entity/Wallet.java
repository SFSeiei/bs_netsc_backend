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
@Table(name = "tb_walley")
@Data
public class Wallet {
    @Id
    private int wId;
    private String wName;
    private float money;
    private String payPassword;
    private String uId;
    private String firstUse;
}
