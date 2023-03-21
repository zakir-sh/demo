package com.mybank.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mybank.demo.dto.DowJonesData;
import com.mybank.demo.service.DowJonesService;
import com.mybank.demo.util.DowJonesUtils;

@RestController
@RequestMapping("/api/stock-data")
public class StockDataController {

	@Autowired
	DowJonesService service;
	
	@GetMapping( value = "/{ticker}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DowJonesData> getStockDataByTicker(@PathVariable(value = "ticker") String ticker,
									   @RequestHeader("X-Client_Id") String clientId) {
		
		//System.out.println(headers.toString());
		//System.out.println(" Client Id = "+ headers.get("X-Client_Id"));
		//String clientId =  headers.get("X-Client_Id").get(0);
		System.out.println("Client Id = ["+clientId+"] Ticker = ["+ticker+"]");
		return service.getDataByTicker(clientId, ticker);
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertStockData(@RequestHeader("X-Client_Id") String clientId){
		return "data inserted "+ clientId;
	}
	
	
	
	@PostMapping(value = "/bulk-insert")
	public ResponseEntity<String> insertBulkStockData(@RequestHeader("X-Client_Id") String clientId, 
													  @RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("bulk upload ...");
		String fileName = file.getOriginalFilename();
		Path filePath = Paths.get("/tmp/", fileName);
        Files.write(filePath, file.getBytes());
        List<DowJonesData> dataList = parseDataFile(clientId, filePath);
        service.saveBulk(dataList);
		String message = "bulk data saved to database";
		return ResponseEntity.ok(message);
	}
	
    private List<DowJonesData> parseDataFile(String clientId, Path filePath) throws IOException {
        List<DowJonesData> dataList = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> {
                String[] val = line.split(",");
                DowJonesData data = DowJonesUtils.transform(clientId, val);
                System.out.println(data.toString());
                dataList.add(data);
            });
        }
        return dataList;
    }
	
}
