package com.example.core;

import com.example.core.model.repository.IRepository;
import com.example.support.FakeRepository;

import org.junit.Before;
import org.junit.Test;

/**
 * En gjestebruker (anonym/ikke innlogget) skal kunne se alle meldinger (og svar) for et valgt emne,
 * men kun de man kjenner en  firesifret PIN-kode til.
 *
 * En gjestebruker (anonym/ikke innlogget) skal kunne rapportere en upassende melding fra studentene som de ikke er enige i
 * En gjestebruker (anonym/ikke innlogget) skal kunne legge inn en kommentar på meldinger fra studentene.
 * */

public class Testing_guest_features {

    protected IRepository repo;

    @Before
    public void initializeRepository() {
        repo = new FakeRepository();
    }

    @Before
    public void initializeConstantFakeVariables() {}

    /* * En gjestebruker (anonym/ikke innlogget) skal kunne se alle meldinger (og svar) for et valgt emne,
     * men kun de man kjenner en  firesifret PIN-kode til. Visningssiden skal inneholde emnekode,
     * slik at den lett kan printes for en "kursrapport".*/
    @Test
    public void guestCanReadAllDialogsWhenValidPinIsGiven() {

    }
}
