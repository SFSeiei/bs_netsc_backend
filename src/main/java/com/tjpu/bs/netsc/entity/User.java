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
@Table(name = "tb_user")
@Data
public class User {
    @Id
    private String uId;
    private String username;
    private String password;
    private String registeTime;
    private String onLineState;
    private String lastTime;
}
