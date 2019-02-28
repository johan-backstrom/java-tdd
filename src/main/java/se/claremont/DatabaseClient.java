package se.claremont;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class DatabaseClient {

    Sql2o sql2o;

    public DatabaseClient(String url, String username, String password){
        sql2o = new Sql2o(url, username, password);
    }

    public <T> List<T> select(String sql, Class<T> clazz){

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(clazz);
        }
    }

    public void executeStatement(String sql){
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        }
    }
}