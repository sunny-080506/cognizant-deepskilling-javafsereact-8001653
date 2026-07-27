package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Hands-on 2: Facebook data in September 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // Hands-on 2: Google stocks with close > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, double price);

    // Hands-on 2: Top 3 highest volume transactions
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Hands-on 2: Three lowest Netflix stocks (by close price)
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
