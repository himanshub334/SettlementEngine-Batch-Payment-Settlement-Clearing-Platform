package com.example.settlement;
import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.math.*; import java.time.LocalDate; import java.util.*;
@Service public class SettlementService {
 private final TransactionRepository transactions; private final SettlementRecordRepository records;
 @Value("${settlement.rates.domestic:0.015}") private BigDecimal domestic;
 @Value("${settlement.rates.cross-border:0.025}") private BigDecimal crossBorder;
 @Value("${settlement.rates.premium:0.020}") private BigDecimal premium;
 public SettlementService(TransactionRepository t,SettlementRecordRepository r){transactions=t;records=r;}
 @Transactional public Map<String,Object> settle(LocalDate date){int count=0;BigDecimal gross=BigDecimal.ZERO,fees=BigDecimal.ZERO,net=BigDecimal.ZERO;
  for(Transaction tx:transactions.findByStatusAndTransactionDateLessThanEqualOrderByIdAsc("AUTHORISED",date)){
   BigDecimal rate=switch(tx.getCardTier()){case "CROSS_BORDER"->crossBorder;case "PREMIUM"->premium;default->domestic;};
   BigDecimal fee=tx.getAmount().multiply(rate).setScale(2,RoundingMode.HALF_UP), payout=tx.getAmount().subtract(fee);
   records.save(new SettlementRecord(tx.getId(),tx.getMerchantId(),tx.getAmount(),fee,payout,date));tx.setStatus("SETTLED");
   gross=gross.add(tx.getAmount());fees=fees.add(fee);net=net.add(payout);count++;
  }
  return Map.of("settlementDate",date,"settled",count,"grossAmount",gross,"fees",fees,"netAmount",net);
 }
 public List<SettlementRecord> report(LocalDate date){return records.findBySettlementDateOrderByIdAsc(date);}
}
