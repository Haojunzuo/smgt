package com.wbz.system.utils;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameUtils {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String EMPTY_STRING = "";
    private static final int NOT_FOUND = -1;
    public static final char EXTENSION_SEPARATOR = '.';
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    private static char SYSTEM_SEPARATOR ;
    private static  char OTHER_SEPARATOR ;
    private static final int IPV4_MAX_OCTET_VALUE = 255;
    private static final int IPV6_MAX_HEX_GROUPS = 8;
    private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    private static final int BASE_16 = 16;

    public FileNameUtils() {
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }


    public static String getExtension(String fileName) throws IllegalArgumentException {
        if (fileName == null) {
            return null;
        } else {
            int index = indexOfExtension(fileName);
            return index == -1 ? "" : fileName.substring(index + 1);
        }
    }

    public static int indexOfExtension(String fileName) throws IllegalArgumentException {
        if (fileName == null) {
            return -1;
        } else {
            int offset;
            if (isSystemWindows()) {
                offset = fileName.indexOf(58, getAdsCriticalOffset(fileName));
                if (offset != -1) {
                    throw new IllegalArgumentException("NTFS ADS separator (':') in file name is forbidden.");
                }
            }

            offset = fileName.lastIndexOf(46);
            int lastSeparator = indexOfLastSeparator(fileName);
            return lastSeparator > offset ? -1 : offset;
        }
    }

    private static int getAdsCriticalOffset(String fileName) {
        int offset1 = fileName.lastIndexOf(SYSTEM_SEPARATOR);
        int offset2 = fileName.lastIndexOf(OTHER_SEPARATOR);
        if (offset1 == -1) {
            return offset2 == -1 ? 0 : offset2 + 1;
        } else {
            return offset2 == -1 ? offset1 + 1 : Math.max(offset1, offset2) + 1;
        }
    }

    public static int indexOfLastSeparator(String fileName) {
        if (fileName == null) {
            return -1;
        } else {
            int lastUnixPos = fileName.lastIndexOf(47);
            int lastWindowsPos = fileName.lastIndexOf(92);
            return Math.max(lastUnixPos, lastWindowsPos);
        }
    }
}

