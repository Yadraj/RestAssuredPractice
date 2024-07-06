package org.example.Oct22nd.JacksonApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Bookingdates extends org.example.Oct21st.Ser_Deser.crudUsingGson.Bookingdates {

    @SerializedName("checkin")
    @Expose
    private String checkin;
    @SerializedName("checkout")
    @Expose
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

}