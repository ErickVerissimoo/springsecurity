package com.loginsecurity.springloginsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    
public void SetCookie(HttpServletResponse response, String id, String value){
Cookie cook = new Cookie(id, value);
cook.setHttpOnly(true);
}
}
