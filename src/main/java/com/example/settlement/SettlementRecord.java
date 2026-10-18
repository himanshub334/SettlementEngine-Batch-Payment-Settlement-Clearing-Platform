package com.example.settlement;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="settlement_records")
public class SettlementRecord {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private Long transactionId;
 @Column(nullable=false) private String merchantId;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal grossAmount, feeAmount, netAmount;
 @Column(nullable=false) private LocalDate settlementDate;
 protected SettlementRecord() {}
 public SettlementRecord(Long tx,String merchant,BigDecimal gross,BigDecimal fee,BigDecimal net,LocalDate date){transactionId=tx;merchantId=merchant;grossAmount=gross;feeAmount=fee;netAmount=net;settlementDate=date;}
 public Long getId(){return id;} public Long getTransactionId(){return transactionId;} public String getMerchantId(){return merchantId;} public BigDecimal getGrossAmount(){return grossAmount;} public BigDecimal getFeeAmount(){return feeAmount;} public BigDecimal getNetAmount(){return netAmount;} public LocalDate getSettlementDate(){return settlementDate;}
}
