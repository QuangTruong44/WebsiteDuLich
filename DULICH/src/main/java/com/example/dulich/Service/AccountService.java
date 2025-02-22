package com.example.dulich.Service;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.exception.AppException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
public interface AccountService {
    List<AccountEntity> getAllAccount();
    Optional<AccountEntity> getAccountByTk(String accountName) throws SQLException, AppException;
    AccountEntity doSaveAccount(AccountEntity accountEntity);
    void  doDeleteById(int userId);
    Optional<AccountEntity> getAccountByUserId(int userId);
}