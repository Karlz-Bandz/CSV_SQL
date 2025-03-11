package services;

import java.util.List;

public interface DbService {
    List<Object[]> getDynamicDataByFileName(String name);
    void saveDynamicData(String name, List<String[]> rows);
}
