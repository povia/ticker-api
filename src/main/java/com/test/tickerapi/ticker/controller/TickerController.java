package com.test.tickerapi.ticker.controller;

import com.test.tickerapi.ticker.controller.dto.TimeRangeRequest;
import com.test.tickerapi.ticker.service.TickerService;
import com.test.tickerapi.ticker.service.dto.DailyTickerRequest;
import com.test.tickerapi.ticker.service.dto.TickerResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "TickerController", description = "티커 조회 컨트롤러")
@RestController
@RequestMapping("ticker")
public class TickerController {

    @Resource
    private final TickerService tickerService;

    public TickerController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping("{symbol}")
    @Operation(operationId = "ticker", summary = "티커 조회", description = "symbol 조회", tags = {"TickerController"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(array = @ArraySchema(schema = @Schema(implementation = TickerResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    public ResponseEntity<List<TickerResponse>> ticker(
            @Parameter(name = "symbol", required = true, example = "005930.KS") @PathVariable("symbol") String symbol,
            @Parameter(name = "interval", required = true, example = "1d") @RequestParam("interval") @Valid String interval,
            @Parameter(name = "range", required = true, example = "5d") @RequestParam("range") @Valid String range
            ) {
        return ResponseEntity.ok().body(tickerService.getTicker(new DailyTickerRequest(symbol, interval, range)));
    }
}
