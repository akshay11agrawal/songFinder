package com.songfinder.sbproject.configuration;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class JasyptConfig {
    @Value("${jasypt.encryptor.password}")
    private String password;
    @Value("${jasypt.encryptor.algorithm}")
    private String algorithm;

    @Bean("jasyptStringEncryptor")
    public StringEncryptor jasyptStringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm(algorithm);
        encryptor.setPassword(password);
        return encryptor;
    }
}
