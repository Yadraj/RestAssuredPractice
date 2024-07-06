package org.example.Oct22nd.DataProvide;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP001 {


    @Test(dataProvider = "getData", dataProviderClass = DataProvider.class)
    public void DP001(String username,String password) {
        System.out.println(username + "--->" + password);
    }


}
