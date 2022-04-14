package data;

import TRMS.Status;

public interface StatusDAO extends GenericDAO<Status>{
    public Status getByName(String status_name);
}
