package com.ohdoking.kstreemap.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "financial_statement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinancialStatement {
    @Id
    private UUID uuid;
    private String ticker;
    private Float per;
    private Float pbr;
    private Float pcr;
    private Float evEbitda;
    private Float eps;
    private Float bps;
    private Float ebitda;

}
