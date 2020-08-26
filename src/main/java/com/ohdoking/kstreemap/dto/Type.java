package com.ohdoking.kstreemap.dto;

public enum Type {
    DAY(Kind.Date, 1),
    WEEK(Kind.Date, 7),
    MONTH(Kind.Date, 30),
    MONTH_3(Kind.Date, 90),
    MONTH_6(Kind.Date, 180),
    YEAR(Kind.Date,365),
    PER(Kind.Financial, 0),
    PBR(Kind.Financial, 0),
    PCR(Kind.Financial, 0),
    EV_EBITDA(Kind.Financial, 0),
    EPS(Kind.Financial, 0),
    BPS(Kind.Financial, 0),
    EBITDA(Kind.Financial, 0);

    Type(Kind kind, int day) {
        this.kind = kind;
        this.day = day;
    }

    private Kind kind;
    private int day;

    public Kind getKind(){
        return this.kind;
    }

    public int getDay(){
        return this.day;
    }
}
