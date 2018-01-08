package net.service.projectstorebeans.entity.myenum;

public enum Availability {

    AVAILABLE("В нвличии"), NOT_AVAILABLE("Нет в наличии");
    
    private String str;

    Availability() {
    }

    Availability(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

}
