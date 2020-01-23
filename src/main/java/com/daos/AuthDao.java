package com.daos;

import com.models.Authority;
import org.springframework.stereotype.Component;

@Component
public interface AuthDao {

    void addAuth(Authority authority);
}
