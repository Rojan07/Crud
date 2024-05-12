package com.teacher.crud.service;


import com.teacher.crud.entity.Role;
import com.teacher.crud.entity.TeacherModel;
import com.teacher.crud.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TeacherRepo teacherRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TeacherModel teacher = teacherRepo.findByName(username).orElseThrow(() ->  new UsernameNotFoundException("username not found"));
        return new User(teacher.getName(),teacher.getPassword(),getAuthorities(teacher.getRoles()));
    }

    private Collection<GrantedAuthority> getAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

}
