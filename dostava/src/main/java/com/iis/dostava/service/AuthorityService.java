package com.iis.dostava.service;

import com.iis.dostava.model.Authority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorityService {
    List<Authority> findById(Integer id);
    List<Authority> findByname(String name);
}
