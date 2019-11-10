package com.code.designpattern.creational.builder.example2;

import java.util.List;

/**
 * @author
 * @Title: RoleBuilder
 *
 * @Description:
 *
 * @Created on 2017-09-18 18:17:01
 */
public abstract class RoleBuilder {
    protected Role role=new Role();

    public Role getRole() {
        return role;
    }

    public abstract void setRoleName();
    public abstract void setRoleClothes();
    public abstract void setRoleSkills();
}
