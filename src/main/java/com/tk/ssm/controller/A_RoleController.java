package com.tk.ssm.controller;

import com.tk.ssm.dao.A_ROLEDao;
import com.tk.ssm.dto.A_RoleDto;
import com.tk.ssm.service.A_RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tk on 2017/9/1.
 */

@RestController
@RequestMapping("api")
public class A_RoleController {
    @Autowired
    A_RoleService RoleService;

    @RequestMapping(value = "role", method = RequestMethod.GET)
    public ResponseEntity<List<A_RoleDto>> selectAllRole () {
        List<A_RoleDto> roleDtos = RoleService.selectAllRole();
        if (roleDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roleDtos,HttpStatus.OK);
    }

    @RequestMapping(value="role", method = RequestMethod.POST)
    public ResponseEntity<A_RoleDto> insertRole (
            @RequestBody Object ROLE) {
        RoleService.insertRole(ROLE);
        return new ResponseEntity<> (HttpStatus.OK);
    }

    @RequestMapping(value = "role/{Role_Id}",method = RequestMethod.DELETE)
    public ResponseEntity<A_ROLEDao> deleteRole (
            @PathVariable Object Role_Id) {
        RoleService.deleteRole(Role_Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "role", method = RequestMethod.PUT)
    public ResponseEntity<A_ROLEDao> updateRole (
            @RequestBody Object ROLE) {
        RoleService.updateRole(ROLE);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
