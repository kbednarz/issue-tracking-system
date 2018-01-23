package com.github.kbednarz.issuetrackingsystem.repository.auth;

import com.github.kbednarz.issuetrackingsystem.domain.auth.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
