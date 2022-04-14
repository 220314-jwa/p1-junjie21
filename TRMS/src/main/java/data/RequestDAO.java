package data;

import TRMS.Reimbursement_request;

public interface RequestDAO extends GenericDAO <Reimbursement_request>{

        public int getByEmpId(int request_id);
}
