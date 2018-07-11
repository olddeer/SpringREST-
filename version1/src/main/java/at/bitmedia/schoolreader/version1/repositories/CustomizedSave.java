package at.bitmedia.schoolreader.version1.repositories;

public interface CustomizedSave<T> {
    <S extends T> S save(S entity);
}
