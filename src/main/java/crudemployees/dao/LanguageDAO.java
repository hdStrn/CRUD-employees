package crudemployees.dao;

import crudemployees.entity.Language;

import java.util.List;

public interface LanguageDAO {

    List<Language> getAllLanguages();

    void saveLanguage(Language language);

    void deleteLanguage(int id);
}
