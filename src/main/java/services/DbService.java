package services;

import java.util.List;

public interface DbService {
    List<Object[]> getDynamicDataRowsByName(String name);
    void saveDynamicData(String name, List<String[]> rows);
}
