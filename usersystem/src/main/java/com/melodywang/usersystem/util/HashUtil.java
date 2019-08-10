package com.melodywang.usersystem.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class HashUtil {
    public static final HashFunction FUNCTION = Hashing.md5();
    public static final String SALT = "09vu8ycmcl9pn";

    public static String encypt(String input) {
        HashCode hashcode = FUNCTION.hashString(input + SALT, Charset.forName("UTF-8"));
        return hashcode.toString();
    }
}
