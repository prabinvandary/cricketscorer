/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.generic.genericrepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
    public Boolean saveData(T t) {
        globalList.add(t);
        return true;
    }

    @Override
    public T getData(Integer id) {
        return globalList.get(id);
    }

}
