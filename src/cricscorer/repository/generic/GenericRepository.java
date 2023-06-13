/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.repository.generic;

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
public class GenericRepository<T> {

    Map<Integer, T> saveListInHashMap;
    List<T> saveList;

    public GenericRepository() {

        saveListInHashMap = new HashMap<>();
        saveList = new ArrayList<>();
    }

    public void setSaveList(List<T> saveList) {
        this.saveList = saveList;
    }

    public Integer saveData(T t) {
        Integer id = generateId();
//        saveListInHashMap.put(id, t);
        saveList.add(t);
        return id;
    }

    public T returnAllListData(Integer id) {
        return saveListInHashMap.get(id);
    }

    Integer generateId() {
        Random random = new Random();
        Integer randomValue = random.nextInt(200);
        return randomValue;

    }
}
