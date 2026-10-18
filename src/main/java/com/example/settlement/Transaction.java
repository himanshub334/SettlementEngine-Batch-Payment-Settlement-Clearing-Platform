package com.example.settlement;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="payment_transactions")
public class Transaction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String merchantId;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal amount;
 @Column(nullable=false) private String status;
 @Column(nullable=false) private String cardTier;
 @Column(nullable=false) private LocalDate transactionDate;
 protected Transaction() {}
 public Long getId(){return id;} public String getMerchantId(){return merchantId;} public BigDecimal getAmount(){return amount;} public String getStatus(){return status;} public String getCardTier(){return cardTier;} public LocalDate getTransactionDate(){return transactionDate;} public void setStatus(String s){status=s;}
}
