package com.example.demo.service;

import com.example.demo.entity.UserData;
import com.example.demo.mapper.MainMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService implements UserDetailsService {

    @Resource
    MainMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserData data = mapper.findUserById(name);
        if(data == null) {
            throw new UsernameNotFoundException("用户 "+name+" 登录失败，用户名不存在！");
        }
        return User
                .withUsername(data.getName())
                .password(data.getPassword())
                .roles(data.getRole())
                .build();
    }
}