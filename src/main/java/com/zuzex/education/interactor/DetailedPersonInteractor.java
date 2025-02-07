package com.zuzex.education.interactor;

import com.zuzex.education.model.DetailedPerson;

import java.util.UUID;

public interface DetailedPersonInteractor {
    DetailedPerson createPerson(DetailedPerson detailedPerson);
    void deletePerson(UUID id);
}
