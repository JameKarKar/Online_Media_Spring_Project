package com.services;

import com.daos.AuthDao;
import com.models.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;

    public void addAuth(Authority authority){
        authDao.addAuth(authority);
    }
}
