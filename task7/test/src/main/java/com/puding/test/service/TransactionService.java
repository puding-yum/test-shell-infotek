package com.puding.test.service;

import com.puding.test.dto.request.AddTransactionReq;
import com.puding.test.dto.response.AddTransactionRes;
import com.puding.test.dto.response.ErrorRes;
import com.puding.test.entity.PaymentTypeEntity;
import com.puding.test.entity.ProductEntity;
import com.puding.test.entity.TransactionEntity;
import com.puding.test.entity.TransactionHistoryEntity;
import com.puding.test.repository.PaymentTypeRepository;
import com.puding.test.repository.ProductRepository;
import com.puding.test.repository.TransactionHistoryRepository;
import com.puding.test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    public TransactionService(
            TransactionRepository transactionRepository,
            ProductRepository productRepository,
            PaymentTypeRepository paymentTypeRepository,
            TransactionHistoryRepository transactionHistoryRepository
    ) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.paymentTypeRepository = paymentTypeRepository;
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public ResponseEntity<Object> addTransaction(AddTransactionReq req) {
        try{
            ProductEntity product = productRepository.findById(req.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));

            PaymentTypeEntity paymentType = paymentTypeRepository.findById(req.getPaymentTypeId()).orElseThrow(() -> new RuntimeException("Payment type not found"));

            String invoice = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
            String paymentCode = UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();

            int baseTotal = product.getPrice() * req.getQuantity();
            int profit = baseTotal * product.getProfitPercentage() / 100;
            int tax = baseTotal * product.getTaxPercentage() / 100;
            int totalShipping = product.getShippingCost() * req.getQuantity();
            int totalPrice = baseTotal + profit + tax + totalShipping;

            TransactionEntity transaction = new TransactionEntity();
            transaction.setInvoice(invoice);
            transaction.setCustomerEmail(req.getCustomerEmail());
            transaction.setPaymentTypeId(paymentType.getId());
            transaction.setPaymentCode(paymentCode);
            transaction.setStatus("SUCCESS");
            transaction.setProductId(product.getId());
            transaction.setProductName(product.getName());
            transaction.setProductType(product.getType());
            transaction.setPrice(product.getPrice());
            transaction.setQuantity(req.getQuantity());
            transaction.setProfitPercentage(product.getProfitPercentage());
            transaction.setTaxPercentage(product.getTaxPercentage());
            transaction.setShippingCost(totalShipping);
            transaction.setCreatedAt(LocalDateTime.now());

            transactionRepository.save(transaction);

            TransactionHistoryEntity transactionHistory = new TransactionHistoryEntity();
            transactionHistory.setTransactionId(transaction.getId());
            transactionHistory.setInvoice(transaction.getInvoice());
            transactionHistory.setCustomerEmail(transaction.getCustomerEmail());
            transactionHistory.setPaymentTypeId(transaction.getPaymentTypeId());
            transactionHistory.setPaymentCode(transaction.getPaymentCode());
            transactionHistory.setStatus(transaction.getStatus());
            transactionHistory.setProductId(transaction.getProductId());
            transactionHistory.setProductName(transaction.getProductName());
            transactionHistory.setProductType(transaction.getProductType());
            transactionHistory.setPrice(transaction.getPrice());
            transactionHistory.setQuantity(transaction.getQuantity());
            transactionHistory.setProfitPercentage(transaction.getProfitPercentage());
            transactionHistory.setTaxPercentage(transaction.getTaxPercentage());
            transactionHistory.setShippingCost(transaction.getShippingCost());
            transactionHistory.setCreatedAt(transaction.getCreatedAt());

            transactionHistoryRepository.save(transactionHistory);

            AddTransactionRes res = new AddTransactionRes();
            res.setInvoice(transaction.getInvoice());
            res.setCustomerEmail(transaction.getCustomerEmail());
            res.setPaymentType(paymentType.getType());
            res.setPaymentCode(transaction.getPaymentCode());
            res.setStatus(transaction.getStatus());
            res.setProductName(transaction.getProductName());
            res.setProductType(transaction.getProductType());
            res.setPrice(transaction.getPrice());
            res.setQuantity(transaction.getQuantity());
            res.setProfitPercentage(transaction.getProfitPercentage());
            res.setTaxPercentage(transaction.getTaxPercentage());
            res.setShippingCost(transaction.getShippingCost());
            res.setTotalPrice(totalPrice);
            res.setCreatedAt(transaction.getCreatedAt().toString());

            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch (Exception e){
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessage(e.getMessage());
            return new ResponseEntity<>(errorRes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}