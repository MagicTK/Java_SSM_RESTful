package com.tk.ssm.dto;

import com.tk.ssm.model.A_ROLE;

import lombok.Data;

/**
 * Created by tk on 2017/9/1.
 */

@Data
public class A_RoleDto {
    private Object roleId;

    private Object roleName;

    public static A_RoleDto toDto(A_ROLE role) {
        A_RoleDto roleDto = new A_RoleDto();

        roleDto.setRoleId(role.getRoleId());
        roleDto.setRoleName(role.getRoleName());
        return roleDto;
    }
}
