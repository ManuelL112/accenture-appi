package org.accenture.api.pruebaApi.commons.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

    public static final String NAME_REGEX = "^([A-ZÑ]+)([A-ZÑ ])*$";
    public static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);
    public static final Pattern WHITE_SPACES_PATTERN = Pattern.compile("\\s+");

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean nameIsNotValid(String name){
        return !NAME_PATTERN.matcher(name).matches();
    }

    public static String replaceWhiteSpaces(String text, String replacement ){
        return WHITE_SPACES_PATTERN.matcher(text).replaceAll(replacement);
    }
}
