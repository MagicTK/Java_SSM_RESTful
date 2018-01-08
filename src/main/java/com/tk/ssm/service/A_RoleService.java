package com.tk.ssm.service;

import com.tk.ssm.dto.A_RoleDto;

import java.util.List;

/**
 * Created by tk on 2017/9/1.
 */

public interface A_RoleService {
    List<A_RoleDto> selectAllRole();
    void insertRole (Object ROLE);
    void deleteRole (Object Role_Id);
    void updateRole (Object ROLE);
}
