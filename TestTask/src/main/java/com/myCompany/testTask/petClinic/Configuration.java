package com.myCompany.testTask.petClinic;

import lombok.Getter;


/**
 * Base tests framework configuration
 */
public class Configuration {
    @Getter
    final static String apiAddress = "localhost";
    @Getter
    final static int apiPort = 8080;
}
