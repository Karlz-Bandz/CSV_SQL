package services.impl;

import hibernate.SessionFactoryMaker;
import model.DynamicData;
import model.DynamicRow;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.DbSaver;

import java.util.Arrays;
import java.util.List;

public class DbSaverImpl implements DbSaver {
    @Override
    public void saveDynamicData(String name, List<String[]> rows) {

        Transaction transaction = null;

        try (Session session = SessionFactoryMaker.getFactory().openSession()) {

            transaction = session.beginTransaction();

            DynamicData dynamicData = new DynamicData();
            dynamicData.setName(name);

            session.persist(dynamicData);

            for (int i = 1; i < rows.size(); i++) {
                List<String> listRow = Arrays.asList(rows.get(i));

                DynamicRow dynamicRow = DynamicRow.builder()
                        .rows(listRow)
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
