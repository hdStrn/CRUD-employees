package crudemployees.service;

import crudemployees.dao.LanguageDAO;
import crudemployees.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDAO languageDAO;

    @Override
    @Transactional
    public List<Language> getAllLanguages() {
        return languageDAO.getAllLanguages();
    }

    @Override
    @Transactional
    public void saveLanguage(Language language) {
        languageDAO.saveLanguage(language);
    }

    @Override
    @Transactional
    public void deleteLanguage(int id) {
        languageDAO.deleteLanguage(id);
    }
}
