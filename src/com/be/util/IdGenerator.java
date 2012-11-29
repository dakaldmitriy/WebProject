package com.be.util;

import java.text.SimpleDateFormat;

public class IdGenerator {

    public static int LogId() {
        return new SimpleDateFormat().getCalendar().hashCode();
    }
}
