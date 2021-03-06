package com.ohdoking.kstreemap.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company {
    @Id
    private UUID id;
    private String ticker;
    private String name;
    private Float marketCap;
    private UUID stockMarketId;
    private boolean isUse;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
