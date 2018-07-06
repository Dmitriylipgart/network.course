package entity;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEntityRecord<T extends IEntityRecord>{

    String getTableName();
    void createRecord();
    List<T> readAll() throws SQLException;
    T read();
    void update();
    void delete();
//    Map<DatabaseField, Object> getFieldsName();
//    Map<String, Class> getFiledWithClass();
}
