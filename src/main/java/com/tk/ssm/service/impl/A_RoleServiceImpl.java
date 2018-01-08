package com.tk.ssm.service.impl;

import com.tk.ssm.dao.A_ROLEDao;
import com.tk.ssm.dto.A_RoleDto;
import com.tk.ssm.model.A_ROLE;
import com.tk.ssm.service.A_RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tk on 2017/9/1.
 */

@Service

@Transactional(rollbackFor = Exception.class)
public class A_RoleServiceImpl implements A_RoleService {
    @Resource
    private A_ROLEDao A_RoleDao;

    @Override
    public List<A_RoleDto> selectAllRole(){
        List<A_ROLE> roles = A_RoleDao.selectAllRole();
        List<A_RoleDto> roleDtos = new ArrayList<>();
        for(int i=0; i<roles.size();i++) {
            roleDtos.add(A_RoleDto.toDto(roles.get(i)));
        }
        return roleDtos;
    }

    @Override
    public void insertRole (Object ROLE) {
        A_RoleDao.insertRole(ROLE);
        return;
    }

    @Override
    public void deleteRole (Object Role_Id) {
        A_RoleDao.deleteRole(Role_Id);
        return;
    }

    @Override
    public void updateRole (Object ROLE) {
        A_RoleDao.updateRole(ROLE);
        return;
    }
}
