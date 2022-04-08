package data;

import TRMS.Status;

public interface StatusDAO {
    public Status getById(Status status_id);
    public Status getByName(Status status_name);
}
