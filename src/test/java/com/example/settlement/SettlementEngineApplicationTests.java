package com.example.settlement;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class SettlementEngineApplicationTests { @Test void basicArithmetic(){assertEquals("98.50",new java.math.BigDecimal("100.00").subtract(new java.math.BigDecimal("1.50")).toPlainString());} }
