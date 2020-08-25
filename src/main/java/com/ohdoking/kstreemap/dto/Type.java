package com.ohdoking.kstreemap.dto;

public enum Type {
    DAY(Kind.Date),
    WEEK(Kind.Date),
    MONTH(Kind.Date),
    MONTH_3(Kind.Date),
    MONTH_6(Kind.Date),
    YEAR(Kind.Date),
    PER(Kind.Financial),
    PBR(Kind.Financial),
    PCR(Kind.Financial),
    EV_EBITDA(Kind.Financial),
    EPS(Kind.Financial),
    BPS(Kind.Financial),
    EBITDA(Kind.Financial);

    Type(Kind kind) {
        this.kind = kind;
    }

    private Kind kind;

    public Kind getKind(){
        return this.kind;
    }
}
