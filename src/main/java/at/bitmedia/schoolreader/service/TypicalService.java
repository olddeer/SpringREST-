package at.bitmedia.schoolreader.service;



import java.util.List;

public interface TypicalService<T> {
    List<T> findAll();
    T findById(int id);
}
