package com.example.settlement;
import org.springframework.data.jpa.repository.JpaRepository; import java.time.LocalDate; import java.util.List;
interface TransactionRepository extends JpaRepository<Transaction,Long>{List<Transaction> findByStatusAndTransactionDateLessThanEqualOrderByIdAsc(String status,LocalDate date);}
interface SettlementRecordRepository extends JpaRepository<SettlementRecord,Long>{List<SettlementRecord> findBySettlementDateOrderByIdAsc(LocalDate date);}
