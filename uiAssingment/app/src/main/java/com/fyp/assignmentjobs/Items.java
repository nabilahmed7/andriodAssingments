package com.fyp.assignmentjobs;

public class Items {
    //model or data class

    int cImages;
    String cTextName;
    String cTextDescription;
    String cTextLocation;


    public Items(int images, String textName, String textDescription,String TextLocation) {
        cImages = images;
        cTextName = textName;
        cTextDescription = textDescription;
        cTextLocation = TextLocation;
    }


    public int getcImages() {
        return cImages;
    }

    public void setcImages(int cImages) {
        this.cImages = cImages;
    }

    public String getcTextName() {
        return cTextName;
    }

    public void setcTextName(String cTextName) {
        this.cTextName = cTextName;
    }

    public String getcTextDescription() {
        return cTextDescription;
    }

    public void setcTextDescription(String cTextDescription) {
        this.cTextDescription = cTextDescription;
    }

    public String getcTextLocation() {
        return cTextLocation;
    }

    public void setcTextLocation(String cTextLocation) {
        this.cTextLocation = cTextLocation;
    }
}
