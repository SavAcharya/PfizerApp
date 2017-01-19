package com.mphasis.pfizerappDoctor.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sourav.Bhattacharya on 1/18/2017.
 */

public class RegisterModel {

    /**
     * address : 1MaEuUR7TvUkQrJ5fAnJU5aiLrHmiW8FtCryhm
     * public : 027d4eb9a19ba137f53885ce5a38ae2afe529d5685bf7dfb8b3d78c8ac647f65cf
     * private : VHgEcE99vvQP23w2hjwp7Evd4nEDu4HZvV1caooKaT14aS9cwu81zA5z
     */

    private String address;
    @SerializedName("public")
    private String publicX;
    @SerializedName("private")
    private String privateX;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public String getPrivateX() {
        return privateX;
    }

    public void setPrivateX(String privateX) {
        this.privateX = privateX;
    }
}
