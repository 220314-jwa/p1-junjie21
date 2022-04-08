package data;

import TRMS.Reimbursement_request;

public interface RequestDAO {
    public Reimbursement_request getById(Reimbursement_request request_id);

    public Reimbursement_request getByEventId(Reimbursement_request event_type_id);

    public Reimbursement_request getByCost(Reimbursement_request cost);

    public Reimbursement_request getByDescription(Reimbursement_request description);

    public Reimbursement_request getByLocation(Reimbursement_request location);

    public Reimbursement_request getByDate(Reimbursement_request event_date);

    public Reimbursement_request getByAt(Reimbursement_request submitted_at);
}
