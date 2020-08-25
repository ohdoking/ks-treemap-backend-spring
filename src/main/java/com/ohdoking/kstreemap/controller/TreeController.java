package com.ohdoking.kstreemap.controller;

import com.ohdoking.kstreemap.dto.StockDto;
import com.ohdoking.kstreemap.service.TreeMapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TreeController {

    private final TreeMapService treeMapService;

    @GetMapping("/getGraphInfo")
    public @ResponseBody
    List<StockDto> getGraphInfo(@RequestParam(value = "type") String type) throws IOException {
        return treeMapService.getStockTreeMapMock(type);
    }

}
