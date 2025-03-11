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
    public void deleteDynamicDataByFileName(String fileName) {
        try (Session session = SessionFactoryMaker.getFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createNativeMutationQuery("""
                            DELETE FROM record_values
                            WHERE dynamic_row_id
                            IN (SELECT id FROM dynamic_row WHERE dynamic_data_id
                            IN (SELECT id FROM dynamic_data WHERE name = :name))
                            """)
                    .setParameter("name", fileName)
                    .executeUpdate();

            session.createNativeMutationQuery("""
                            DELETE FROM dynamic_row
                            WHERE dynamic_data_id
                            IN (SELECT id FROM dynamic_data WHERE name = :name)
                            """)
                    .setParameter("name", fileName)
                    .executeUpdate();

            session.createNativeMutationQuery("""
                            DELETE FROM dynamic_data WHERE name = :name
                            """)
                    .setParameter("name", fileName)
                    .executeUpdate();

            transaction.commit();
        }
    }

    @Override
    public List<Object[]> getDynamicDataByFileName(String fileName) {
        try (Session session = SessionFactoryMaker.getFactory().openSession()) {
            String hql = """
                    SELECT r.id, d.name, v
                    FROM DynamicRow r
                    JOIN r.dynamicData d
                    JOIN r.records v
                    WHERE d.name = :name
                    """;
            Query<Object[]> query = session.createQuery(hql, Object[].class)
                    .setParameter("name", fileName);

            return query.getResultList();
        }
    }

    @Override
    public void saveDynamicData(String fileName, List<String[]> rows) {
        try (Session session = SessionFactoryMaker.getFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            DynamicData dynamicData = new DynamicData();
            dynamicData.setName(fileName);

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
        }
    }
}
