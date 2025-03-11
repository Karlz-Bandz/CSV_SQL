package services.impl;

import hibernate.SessionFactoryMaker;
import model.DynamicData;
import model.DynamicRow;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import services.DbService;

import java.util.Arrays;
import java.util.List;

public class DbServiceImpl implements DbService {

    @Override
    public List<Object[]> getDynamicDataByFileName(String name) {
        try (Session session = SessionFactoryMaker.getFactory().openSession()) {
            String hql = """
                    SELECT r.id, d.name, v
                    FROM DynamicRow r
                    JOIN r.dynamicData d
                    JOIN r.records v
                    WHERE d.name = :name
                    """;
            Query<Object[]> query = session.createQuery(hql, Object[].class)
                    .setParameter("name", name);

            return query.getResultList();
        }
    }

    @Override
    public void saveDynamicData(String name, List<String[]> rows) {

        Transaction transaction = null;

        try (Session session = SessionFactoryMaker.getFactory().openSession()) {

            transaction = session.beginTransaction();

            DynamicData dynamicData = new DynamicData();
            dynamicData.setName(name);

            session.persist(dynamicData);

            for (int i = 1; i < rows.size(); i++) {
                List<String> records = Arrays.asList(rows.get(i));

                DynamicRow dynamicRow = DynamicRow.builder()
                        .records(records)
                        .dynamicData(dynamicData)
                        .build();
                session.persist(dynamicRow);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
