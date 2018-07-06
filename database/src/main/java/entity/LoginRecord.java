package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoginRecord extends AbstractIEntityRecord<LoginRecord> {

    @Override
    public void createRecord() {

    }

    @Override
    public LoginRecord read() {
        return null;
    }

    @Override
    public void update() {

    }

//    @Override
//    public Map<DatabaseField, Object> getFieldsName() {
//        return null;
//    }

    private static final String TABLE_NAME = "login";

    private Integer id;
    private String login;
    private String password;

    public Integer getLoginId() {
        return id;
    }

    public void setLoginId(Integer loginId) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

//    @Override
//    public Map<DatabaseField, Object> getFieldsName() {
//
//        Map<DatabaseField, Object> fields;
//
//
//    }

    public Map<String, Class> getFiledWithClass() {
        Map<String, Class> m = new HashMap<>();
        m.put("id", Integer.class);
        m.put("login", String.class);
        m.put("password", String.class);
        return m;
    }

    @Override
    public List<LoginRecord> readAll() {
        ResultSet resultSet = selectAll();
        List<LoginRecord> collections = new ArrayList<>();
        try {
            while (resultSet.next()) {
                LoginRecord loginRecord = new LoginRecord();
                loginRecord.setLogin(resultSet.getString("login"));
                loginRecord.setPassword(resultSet.getString("password"));
                loginRecord.setLoginId(resultSet.getInt("id"));
                collections.add(loginRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collections;
    }


}
