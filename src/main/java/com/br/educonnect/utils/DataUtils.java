package com.br.educonnect.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static String formataData(LocalDate data) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return data.format(dateTimeFormatter);
    }
}
