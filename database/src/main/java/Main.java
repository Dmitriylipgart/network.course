import entity.Mysqlcon;

public class Main {

    public static void main(String[] args) {

//        LoginRecord loginRecord = new LoginRecord();
//        List<LoginRecord> loginRecords = loginRecord.read();
//
//        for (LoginRecord record: loginRecords){
//            System.out.println(record.getLoginId());
//            System.out.println(record.getLogin());
//            System.out.println(record.getPassword());
//        }


        Mysqlcon mysqlcon = new Mysqlcon();
        mysqlcon.readAll();



    }
}
