package com.puding.test.service;

import com.puding.test.dao.TransactionDao;
import com.puding.test.dto.request.ReportReq;
import com.puding.test.dto.response.ErrorRes;
import com.puding.test.dto.response.ReportRes;
import com.puding.test.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private final TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    public ReportService(TransactionHistoryRepository transactionHistoryRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public ResponseEntity<Object> generateReport(ReportReq request) {
        try{
            String[] startDateParts = request.getStartDate().split("-");
            int startMonth = Integer.parseInt(startDateParts[0]);
            int startYear = Integer.parseInt(startDateParts[1]);

            String[] endDateParts = request.getEndDate().split("-");
            int endMonth = Integer.parseInt(endDateParts[0]);
            int endYear = Integer.parseInt(endDateParts[1]);

            List<TransactionDao> daoList = transactionHistoryRepository.findSuccessTransactionsByMonthAndYearRange(startMonth, startYear, endMonth, endYear);

            List<ReportRes.Transaction> responseList = new ArrayList<>();
            int no = 1;
            for (TransactionDao dao : daoList) {
                ReportRes.Transaction res = new ReportRes.Transaction();
                res.setNo(no++);
                res.setProductId(dao.getProductId());
                res.setProductName(dao.getProductName());
                res.setProductType(dao.getProductType());
                res.setPrice(dao.getPrice());
                res.setQuantity(dao.getQuantity());
                res.setProfitPercentage(dao.getProfitPercentage());
                int totalProfit = dao.getProfitPercentage() * dao.getQuantity() * dao.getPrice() / 100;
                res.setTotalProfit(totalProfit);
                responseList.add(res);
            }

            ReportRes reportResponse = new ReportRes();
            reportResponse.setTransactions(responseList);
            return new ResponseEntity<>(reportResponse, HttpStatus.OK);
        }catch (Exception e){
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessage(e.getMessage());
            return new ResponseEntity<>(errorRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}