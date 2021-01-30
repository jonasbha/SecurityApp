package com.example.test.db;

import com.example.test.fake.Testing_guest_features;

import org.junit.Before;

public class Testing_guest_features_db extends Testing_guest_features {

    @Override
    @Before
    public void initialize_repository() {
        persistenceSupport = new DbPersistenceSupport();
    }
}
