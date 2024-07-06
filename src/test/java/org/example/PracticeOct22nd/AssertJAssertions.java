package org.example.PracticeOct22nd;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertJAssertions {


    public static void main(String[] args) {



        String s = "yadraj";
        assertThat(s).isEqualTo("yadraj").isNotBlank().isNotEmpty();


        int a = 100;
        assertThat(a).isEqualTo(100).isGreaterThan(0);



    }
}
