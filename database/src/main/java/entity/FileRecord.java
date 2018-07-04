package entity;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class FileRecord extends AbstractIEntityRecord<FileRecord> {


    public static final String TABLE_NAME = "files";

    String file_id;
    File file;
    String description;
    InputStream is;
    String path = "D:\\Html\\network.course\\servlet\\src\\files\\file";

    public FileRecord() {
    }

    public FileRecord(String file_id) {
        this.file_id = file_id;
    }

    public FileRecord(String file_id, String description, InputStream is) {
        this.file_id = file_id;
        this.description = description;
        this.is = is;
    }

    public FileRecord(String description, InputStream is) {
        this.description = description;
        this.is = is;
    }

    public String getFileId() {
        return file_id;
    }

    public void setFileId(String fileId) {
        this.file_id = fileId;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(InputStream is)
    {
        this.file = writeToFile(is);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTableName() {
        return TABLE_NAME;
    }


    public Map<DatabaseField, Object> getFieldsName() {
        return null;
    }


    public Map<String, Class> getFiledWithClass() {
        Map<String, Class> map = new HashMap<>();
        map.put("file_id", Integer.class);
        map.put("file", String.class);
        map.put("description", String.class);
        return map;
    }


    public void createRecord()  {

        String sql = "Insert into files (file, description) " //
                + " values (?,?) ";

        byte[] bytes = getByteArray(is);

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBytes(1,  bytes);
            statement.setString(2, description);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        String sql = "Update " + getTableName() + " set file = ?, description = ? where file_id = " + file_id;

        byte[] bytes = getByteArray(is);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBytes(1, bytes);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
            is.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public byte[] getByteArray(InputStream is) {

        ByteArrayOutputStream out = null;

        try{
            out = new ByteArrayOutputStream();
            int data = 0;
            while ((data = is.read()) != -1){
                out.write(data);
            }
            out.flush();
        }
        catch (Exception e){

        }
        return out.toByteArray();
    }

    public List<FileRecord> readAll() {
        ResultSet resultSet = selectAll();
        List<FileRecord> collections = new ArrayList<>();
        try {
            while (resultSet.next()) {
                FileRecord fileRecord = new FileRecord();
                fileRecord.setDescription(resultSet.getString("description"));
                fileRecord.setFileId(resultSet.getString("file_id"));
                fileRecord.setFile(resultSet.getBinaryStream("file"));
                collections.add(fileRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collections;
    }

    public FileRecord read(){
        ResultSet resultSet = selectById(file_id);
        FileRecord fileRecord = new FileRecord();

        try {
            fileRecord.setFileId(resultSet.getString("file_id"));
            fileRecord.setDescription(resultSet.getString("description"));
            fileRecord.setFile(resultSet.getBinaryStream("file"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fileRecord;
    }

    public File writeToFile(InputStream is){

        File file = new File(path  + file_id + ".jpg");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];

            while (is.read(buffer) > 0) {
                fos.write(buffer);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}


