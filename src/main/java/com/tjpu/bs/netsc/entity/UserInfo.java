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
@Table(name = "tb_userinfo")
@Data
public class UserInfo {
    @Id
    private int uIId;
    private String uId;
    private String ustate;
    private String email;
    private String nickname;
    private String realname;
    private String uIDcard;
    private String uSex;
    private Long uTel;
    private String sType;
    private String address;
    private int roleId;
    private String uRole;
    private String userImage;
}
