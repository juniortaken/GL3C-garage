package com.bgstuffs.pabapp;

public class serviceCenteres {

    private int idV;
    private String nomV;
    private String typeV;
    private String Desc;
    private String location;
    private int image;

    public serviceCenteres(int idV, String nomV, String typeV, String desc, String location, int image) {
        this.idV = idV;
        this.nomV = nomV;
        this.typeV = typeV;
        Desc = desc;
        this.location = location;
        this.image = image;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getNomV() {
        return nomV;
    }

    public void setNomV(String nomV) {
        this.nomV = nomV;
    }

    public String getTypeV() {
        return typeV;
    }

    public void setTypeV(String typeV) {
        this.typeV = typeV;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
