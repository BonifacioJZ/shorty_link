package com.bonifacio.shorty_link.services;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Component
public class UrlEncodeServiceImplement implements UrlEncodeService{

    private MessageDigest digest = MessageDigest.getInstance("SHA-256");

    public UrlEncodeServiceImplement() throws NoSuchAlgorithmException {
    }

    @Override
    public String hash(String url) {

        var time = LocalDateTime.now();

        var urlT = url.concat(time.toString());
        var bytes = digest.digest(urlT.getBytes());
        var hash = String.format("%x32", new BigInteger(1,bytes));

        return hash.substring(0,6);
    }
}
