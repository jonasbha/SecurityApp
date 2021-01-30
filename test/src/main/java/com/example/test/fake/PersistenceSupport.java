package com.example.test.fake;

import com.example.core.model.persistence.fakes.FakeAccountRepository;
import com.example.core.model.persistence.repository.IAccountRepository;

public class PersistenceSupport {
    protected IAccountRepository accountRepository;

    public PersistenceSupport() {
        this.accountRepository = new FakeAccountRepository();
    }

    public IAccountRepository getAccountRepository() {
        return accountRepository;
    }

}
