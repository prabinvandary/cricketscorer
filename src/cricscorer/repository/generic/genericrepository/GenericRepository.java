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

/**
 *
 * @author prabin
 * @param <T>
 * @param <ID>
 */
public abstract class GenericRepository<T extends GenericInterface, ID> implements GenericRepositoryInterface<T, ID> {

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
    public abstract ID getId(T item
    );
}
