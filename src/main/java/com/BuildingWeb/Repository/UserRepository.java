package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u FROM UserEntity u WHERE " +
            "(:name IS NULL OR :name = '' OR LOWER(u.userName) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:phone IS NULL OR :phone = '' OR u.phone LIKE CONCAT('%', :phone, '%'))")
    List<UserEntity> searchUsers(@Param("name") String name, @Param("phone") String phone);
    Optional<UserEntity> findByphone(String phone);
    boolean existsByphone(String phone);


    Optional<UserEntity> findByemail(String email);
}
