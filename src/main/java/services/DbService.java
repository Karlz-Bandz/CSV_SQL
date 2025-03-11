package services;

import java.util.List;

public interface DbService {
    void deleteDynamicDataByFileName(String fileName);
    List<Object[]> getDynamicDataByFileName(String fileName);
    void saveDynamicData(String fileName, List<String[]> rows);
}
