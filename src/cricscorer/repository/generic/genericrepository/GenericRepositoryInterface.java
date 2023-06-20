/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.repository.generic.genericrepository;

import java.sql.*;
import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @author prabin
 * @param <T>
 * @param <ID>
 */
public interface GenericRepositoryInterface<T, ID> {

    T saveData(T t);

    T getData(Integer id);

    Boolean saveAllData(List<T> t);

    List<T> getAllData();

    <F> List<T> getListByField(Field field, F value);

    List<T> getById(ID id);

    Boolean deleteById(ID id);

    ID getId(T item);

    ResultSet getAllDataFromDataBase(String tableName);

    ResultSet getDataByIdFromDatabase(String tableName, Integer id);

    String deleteByIdFromDatabase(String tableName, Integer id);

}
