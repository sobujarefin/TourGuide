package com.example.naim.tourguide;

public class Res {
    public String name;
    public String desc;
    public String image;
    public String details_desc;
    public String location;

    public Res() {
    }



    public Res(String name, String desc, String image,String details_desc,String location) {
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.details_desc = details_desc;
        this.location = location;


    }

    public String getDetails_desc() {
        return details_desc;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

    public String getImage() {
        return image;
    }


}
