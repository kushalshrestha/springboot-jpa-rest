package id_authentication.service;

import id_authentication.dto.response.TransactionStatusDTO;

public interface TransactionService {
    TransactionStatusDTO addTransaction(long badgeId, long planId, long locationId);
}
