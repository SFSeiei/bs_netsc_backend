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
@Table(name = "tb_distributors")
@Data
public class Distributor {
    @Id
    private int dId;
    private int sId;
    private String dName;
    private String dState;
}
