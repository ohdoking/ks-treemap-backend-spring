package com.ohdoking.kstreemap.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohdoking.kstreemap.dto.Kind;
import com.ohdoking.kstreemap.dto.StockDto;
import com.ohdoking.kstreemap.dto.Type;
import com.ohdoking.kstreemap.model.StockHistory;
import com.ohdoking.kstreemap.repository.CompanyRepository;
import com.ohdoking.kstreemap.repository.FinancialStatementRepository;
import com.ohdoking.kstreemap.repository.StockHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TreeMapService {

    private final CompanyRepository companyRepository;
    private final FinancialStatementRepository financialStatementRepository;
    private final StockHistoryRepository stockHistoryRepository;

    public List<StockDto> getStockTreeMapMock(String type) throws IOException {
        List<StockDto> stockJsonList = new ArrayList<>();

        if ("week".equals(type)) {
            File file = ResourceUtils.getFile("classpath:mock/week.json");
            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();
            stockJsonList = mapper.readValue(content, new TypeReference<>() {
            });
        } else if ("day".equals(type)) {
            File file = ResourceUtils.getFile("classpath:mock/day.json");
            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();
            stockJsonList = mapper.readValue(content, new TypeReference<>() {
            });
        }

        return stockJsonList;
    }

    public List<StockDto> getStockTreeMap(String typeString){
        List<StockDto> stockJsonList = new ArrayList<>();
        Type type = getType(typeString);
        if( Kind.Date.equals(type.getKind())){
            stockJsonList = getStockTreeMapWithDate(type);
        }
        else if(Kind.Financial.equals(type.getKind())){
            stockJsonList = getStockTreeMapWithFinancial();
        }
        return stockJsonList;
    }

    private List<StockDto> getStockTreeMapWithFinancial() {
        List<StockDto> stockJsonList = new ArrayList<>();
        return stockJsonList;
    }

    private List<StockDto> getStockTreeMapWithDate(Type type) {
        List<StockDto> stockJsonList = new ArrayList<>();

        long millis=System.currentTimeMillis();
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date yesterday = new Date(millis - (1 * DAY_IN_MS));
        Date targetDate = new Date(millis - (type.getDay() * DAY_IN_MS));

        List<StockHistory> stockHistoryWith2Day = stockHistoryRepository.findStockHistoriesByYesterdayAndTargetDay(yesterday, targetDate);

        StockHistory stockHistoryYesterday = stockHistoryWith2Day.get(0);
        StockHistory stockHistoryTargetDay = stockHistoryWith2Day.get(1);


        return stockJsonList;
    }

    private Type getType(String type){
        return Type.valueOf(type);
    }


}
