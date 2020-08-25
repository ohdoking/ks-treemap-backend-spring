package com.ohdoking.kstreemap.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohdoking.kstreemap.dto.StockDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class TreeController {

    @GetMapping("/getGraphInfo")
    public @ResponseBody List<StockDto> getGraphInfo(@RequestParam(value = "type") String type) throws IOException {

        List<StockDto> stockJsonList = new ArrayList<>();

        if ("week".equals(type)) {
            File file = ResourceUtils.getFile("classpath:mock/week.json");
            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();
            stockJsonList = mapper.readValue(content, new TypeReference<List<StockDto>>() {
            });
        } else if ("day".equals(type)) {
            File file = ResourceUtils.getFile("classpath:mock/day.json");
            String content = new String(Files.readAllBytes(file.toPath()));

            ObjectMapper mapper = new ObjectMapper();
            stockJsonList = mapper.readValue(content, new TypeReference<List<StockDto>>() {
            });
        }

        return stockJsonList;
    }

}
