package com.example.core;

import com.example.core.model.repository.IRepository;
import com.example.support.FakeRepository;

import org.junit.Before;

/** En student skal kunne sende melding ang. ønsket emne/fag, men forbli anonym
 * En student skal se evt. svar fra forelesere på tidligere sendte meldinger (trenger ikke håndtere lest/ulest)
 * En foreleser skal kunne lese meldinger fra studenter i emner(/et) man selv underviser
 * En foreleser skal kunne svare på meldinger fra studenter (kun ett svar pr. melding)
 *
 * En gjestebruker (anonym/ikke innlogget) skal kunne se alle meldinger (og svar) for et valgt emne,
 * men kun de man kjenner en  firesifret PIN-kode til. Visningssiden skal inneholde emnekode,
 * slik at den lett kan printes for en "kursrapport".
 *
 * En gjestebruker (anonym/ikke innlogget) skal kunne rapportere en upassende melding fra studentene som de ikke er enige i
 * En gjestebruker (anonym/ikke innlogget) skal kunne legge inn en kommentar på meldinger fra studentene.
 * */

public class Testing_communication_features {

    protected IRepository repo;

    @Before
    public void initialize_persistence() {
        repo = new FakeRepository();
    }
}
