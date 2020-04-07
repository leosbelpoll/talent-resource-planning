package com.leito.talentresourceplanning.repository;

import com.leito.talentresourceplanning.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
