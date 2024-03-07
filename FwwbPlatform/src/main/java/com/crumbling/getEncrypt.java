package com.crumbling;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class getEncrypt {

    public static void main(String[] args) {
        // 创建 BCryptPasswordEncoder 实例
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 待加密的密码
        String rawPassword = "123";

        // 加密密码
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 输出加密后的密码
        System.out.println("Encoded password: " + encodedPassword);
    }
}
