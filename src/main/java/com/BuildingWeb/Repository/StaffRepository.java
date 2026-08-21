package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByuserRole_role_code(String Code);

}
