package com.example.test.db;

import com.example.test.fake.Testing_account_features;

import org.junit.Before;

public class Testing_account_features_db extends Testing_account_features {

    @Override
    @Before
    public void initialize_repository() {
        persistenceSupport = new DbPersistenceSupport();
    }
}
