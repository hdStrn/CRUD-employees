package crudemployees.service;

import crudemployees.entity.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getAllLanguages();

    void saveLanguage(Language language);

    void deleteLanguage(int id);
}
