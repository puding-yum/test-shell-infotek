package com.puding.test.repository;

import com.puding.test.dao.TransactionDao;
import com.puding.test.entity.TransactionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistoryEntity, Long> {

    @Query(value = """
        SELECT
            product_id AS productId,
            product_name AS productName,
            product_type AS productType,
            price AS price,
            quantity AS quantity,
            profit_percentage AS profitPercentage
        FROM
            transaction_history
        WHERE status = 'SUCCESS'
        AND created_at BETWEEN TO_DATE(:startYear || '-' || :startMonth || '-01', 'YYYY-MM-DD') AND (TO_DATE(:endYear || '-' || :endMonth || '-01', 'YYYY-MM-DD') + INTERVAL '1 MONTH')::DATE
        """, nativeQuery = true)
    List<TransactionDao> findSuccessTransactionsByMonthAndYearRange(
            @Param("startMonth") int startMonth,
            @Param("startYear") int startYear,
            @Param("endMonth") int endMonth,
            @Param("endYear") int endYear
    );

}
