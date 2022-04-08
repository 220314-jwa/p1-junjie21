package data;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T> {
    // create read update delete
    public int create(T newObj) throws SQLException;
    public T getById(int id);
    public List<T> getAll(); // read all
    public void update(T updateObj);        // update
    public void delete(T deleteObj);        // delete
}
