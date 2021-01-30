package com.example.test.db;

import com.example.database.AccountRepository_db;
import com.example.test.fake.PersistenceSupport;

public class DbPersistenceSupport extends PersistenceSupport {

    public DbPersistenceSupport() {
        accountRepository = new AccountRepository_db();
    }
}
