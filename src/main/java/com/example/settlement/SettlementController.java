package com.example.settlement;
import org.springframework.web.bind.annotation.*; import java.time.LocalDate; import java.util.*;
@RestController @RequestMapping("/api") public class SettlementController {
 private final SettlementService service; private final TransactionRepository transactions;
 public SettlementController(SettlementService s,TransactionRepository t){service=s;transactions=t;}
 @PostMapping("/settlements/run") public Map<String,Object> run(@RequestParam LocalDate date){return service.settle(date);}
 @GetMapping("/settlements/report") public List<SettlementRecord> report(@RequestParam LocalDate date){return service.report(date);}
 @GetMapping("/transactions") public List<Transaction> transactions(){return transactions.findAll();}
 @GetMapping("/health") public Map<String,String> health(){return Map.of("status","UP");}
 @GetMapping("/settlements/status") public Map<String,String> status(){return Map.of("status","READY");}
 @GetMapping("/batch/status") public Map<String,String> batchStatus(){return Map.of("note","Trigger the batch using POST /api/settlements/run?date=YYYY-MM-DD");}
 @GetMapping("/exceptions") public List<Map<String,String>> exceptions(){return List.of();}
 @PostMapping("/batch/trigger") public Map<String,Object> trigger(@RequestParam LocalDate date){return service.settle(date);}
}
