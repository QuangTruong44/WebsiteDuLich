package com.example.dulich.Service;

import com.example.qldl.Entity.AccountEntity;
public interface registerService {
    AccountEntity doSaveAccount(AccountEntity accountEntity) throws Exception;
}
