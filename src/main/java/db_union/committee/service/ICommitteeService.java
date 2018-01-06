package db_union.committee.service;

import db_union.committee.model.Committee;
import db_union.utils.Page;
import java.util.List;

public interface ICommitteeService {


		public Committee findCommitteeByID(String COMMITTEE_ID);
		

		public boolean deleteCommitteeByID(String COMMITTEE_ID);
		

		public boolean insertCommittee(Committee committee);
		

		public List<Committee> findCommitteeByPage(Page page);
		

		public Integer allCountCommittee();
}
