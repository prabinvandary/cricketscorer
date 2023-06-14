/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.generic.genericrepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 * @author prabin
 * @param <T>
 * @param <ID>
 */
public abstract class GenericRepository<T, ID> implements GenericRepositoryInterface<T, ID> {
    
    List<T> globalList = new ArrayList<>();
    
    public GenericRepository() {
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
                .filter(item -> id.equals(getId(item)))
                .collect(Collectors.toList());
    }
    
    @Override
    public abstract ID getId(T item);
}
