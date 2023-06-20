/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.generic.genericrepository;

import cricscorer.repository.generic.GenericInterface;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabin
 * @param <T>
 * @param <ID>
 */
public abstract class GenericRepository<T extends GenericInterface, ID> implements GenericRepositoryInterface<T, ID> {

    List<T> globalList = new ArrayList<>();

    private final Connection getConnection;

    public GenericRepository() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/cricket_scorer";
            String userName = "prabin";
            String password = "Prabin12#$%";
            con = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        this.getConnection = con;
    }

    @Override
    public T saveData(T t) {
        globalList.add(t);
        return t;
    }

    @Override
    public T getData(Integer id) {
        return globalList.get(id);
    }

    public Boolean saveAllData(List<T> t) {
        return globalList.addAll(t);
    }

    @Override
    public List<T> getAllData() {
        return globalList;
    }

    @Override
    public <F> List<T> getListByField(Field field, F value) {
        return globalList.stream()
                .filter(item -> {
                    try {
                        Object fieldValue = field.get(item);
                        return fieldValue != null && fieldValue.equals(value);
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<T> getById(ID id) {
        return globalList.stream()
                .filter(item -> item.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(ID id) {
        T item = globalList.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        if (item != null) {
            globalList.remove(item);
        } else {
            System.out.println("Not found");
            return false;
        }
        return true;
    }

    public Boolean updateById(ID id, T t) {
        T item = globalList.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
        Integer index = globalList.indexOf(item);
        globalList.add(index, t);
        return item != null;
    }

    @Override
    public abstract ID getId(T item);

    @Override
    public ResultSet getAllDataFromDataBase(String tableName) {
        ResultSet resultSet = null;
        try {
            String selectQuery = "select * from " + tableName + "";
            Statement statement = getConnection.createStatement();
            resultSet = statement.executeQuery(selectQuery);
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(GenericRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    @Override
    public ResultSet getDataByIdFromDatabase(String tableName, Integer id) {
        ResultSet resultSet = null;
        try {
            String selectQuery = "select * from " + tableName + " where id=" + id;
            Statement statement = getConnection.createStatement();
            resultSet = statement.executeQuery(selectQuery);
            if (resultSet == null) {
                System.out.println("Null value");
            }
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(GenericRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    @Override
    public String deleteByIdFromDatabase(String tableName, Integer id) {
        Boolean delete = null;
        try {
            String selectQuery = "delete from " + tableName + " where id=" + id;
            Statement statement = getConnection.createStatement();
            delete = statement.execute(selectQuery);
        } catch (SQLException ex) {
            Logger.getLogger(GenericRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!delete) {
            return "Deleted successfully";

        } else {
            return "Not Found";
        }
    }
}
