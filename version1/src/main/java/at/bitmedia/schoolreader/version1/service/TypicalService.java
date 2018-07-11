package at.bitmedia.schoolreader.version1.service;



import java.util.List;

public interface TypicalService<T> {
    List<T> findAll();
    T findById(int id);
}
