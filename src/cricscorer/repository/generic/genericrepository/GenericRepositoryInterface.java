/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cricscorer.repository.generic.genericrepository;

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

    List<T> getAllData();

    <F> List<T> getListByField(Field field, F value);

    List<T> getById(ID id);

    ID getId(T item);
}
