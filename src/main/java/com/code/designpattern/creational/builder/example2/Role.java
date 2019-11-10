package com.code.designpattern.creational.builder.example2;

import java.util.List;

/**
 * @author
 * @Title: Role
 *
 * @Description:
 *
 * @Created on 2017-09-18 18:08:00
 */
public class Role {
    private String roleName;//角色名称
    private String clothes;//皮肤
    private List skills;//技能

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getClothes() {
        return clothes;
    }

    public Role setClothes(String clothes) {
        this.clothes = clothes;
        return this;
    }

    public List getSkills() {
        return skills;
    }

    public Role setSkills(List skills) {
        this.skills = skills;
        return this;
    }
}
