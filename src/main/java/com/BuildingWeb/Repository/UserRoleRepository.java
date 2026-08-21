package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    void deleteByuser_idUser(Long id);
    List<UserRoleEntity> findByuser_idUser(Long id);
}
