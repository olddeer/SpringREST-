package at.bitmedia.schoolreader.repositories;

public interface CustomizedSave<T> {
    <S extends T> S save(S entity);
}
