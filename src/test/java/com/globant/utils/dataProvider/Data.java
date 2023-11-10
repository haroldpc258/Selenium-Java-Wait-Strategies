package com.globant.utils.dataProvider;

import org.testng.annotations.DataProvider;

public class Data {

    @DataProvider(name = "credentialsData")
    public static Object[][] credentialsData() {
        return new Object[][] {
                {"performance_glitch_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
               // {"locked_out_user", "secret_sauce"},
                {"standard_user", "secret_sauce"},
        };
    }
}
