package crudemployees.dao;

import crudemployees.entity.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LanguageDAOImpl implements LanguageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Language> getAllLanguages() {
        Session session = sessionFactory.getCurrentSession();
        List<Language> languages = session.createQuery("from Language", Language.class).getResultList();
        return languages;
    }

    @Override
    @Transactional
    public void saveLanguage(Language language) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(language);
    }

    @Override
    @Transactional
    public void deleteLanguage(int id) {
        Session session = sessionFactory.getCurrentSession();
        Language language = session.get(Language.class, id);
        session.delete(language);
    }
}
