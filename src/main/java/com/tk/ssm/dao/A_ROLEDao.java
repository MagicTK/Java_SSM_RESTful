package com.tk.ssm.dao;

import com.tk.ssm.model.A_ROLE;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tk on 2017/9/1.
 */

@Repository
public interface A_ROLEDao {
    List<A_ROLE> selectAllRole();
    void insertRole (
            @Param("ROLE") Object ROLE
    );
    void deleteRole (
      @Param("Role_Id") Object Role_Id
    );

    void updateRole (
            @Param("ROLE") Object ROLE
    );
}