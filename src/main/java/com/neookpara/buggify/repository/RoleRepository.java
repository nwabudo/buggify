package com.neookpara.buggify.repository;

import com.neookpara.buggify.entity.Role;
import com.neookpara.buggify.entity.User;
import com.neookpara.buggify.entity.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole role);
}
