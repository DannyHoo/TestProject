package com.code.designpattern.creational.builder.example2;

/**
 * @author
 * @Title: RoleBuildDirector
 *
 * @Description:
 *
 * @Created on 2017-09-18 18:24:50
 */
public class RoleBuildDirector {
    private RoleBuilder roleBuilder;

    public RoleBuildDirector(RoleBuilder roleBuilder) {
        this.roleBuilder = roleBuilder;
    }

    public Role construct() {
        roleBuilder.setRoleName();
        roleBuilder.setRoleClothes();
        roleBuilder.setRoleSkills();
        return roleBuilder.getRole();
    }
}
