package services;

import java.util.List;

public interface DbSaver {
    void saveDynamicData(String name, List<String[]> rows);
}
