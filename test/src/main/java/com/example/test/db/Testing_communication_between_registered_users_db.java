package com.example.test.db;

import com.example.test.fake.Testing_communication_between_registered_users;

import org.junit.Before;

public class Testing_communication_between_registered_users_db extends Testing_communication_between_registered_users {

    @Override
    @Before
    public void initialize_repository() {
        persistenceSupport = new DbPersistenceSupport();
    }
}
