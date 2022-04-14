package data;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface GenericDAO <D> {
    // create read update delete
    public int create(D newObj) throws SQLException;
    public D getById(int id);
    public Set<D> getAll(); // read all
    public void update(D updateObj) throws SQLException;        // update
    public void delete(D deleteObj) throws SQLException;        // delete
}
