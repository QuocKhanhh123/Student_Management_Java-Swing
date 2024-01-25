package Model;

import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
	List<SubjectModel> list_subject = new ArrayList<SubjectModel>();

	public int add(SubjectModel subject) {
		list_subject.add(subject);
		return 1;
	}

	public int findByID(String id) {
		int pos = -1;
		for (int i = 0; i < list_subject.size(); i++) {
			if (list_subject.get(i).getSubjectID().equalsIgnoreCase(id)) {
				pos = i;
			}
		}
		return pos;
	}
	
	public SubjectModel findSubjectByID(String id) {
		SubjectModel sub = null;
		for (SubjectModel subject : list_subject) {
			if (subject.getSubjectID().equalsIgnoreCase(id)) {
				sub = subject;
				break;
			}
		}
		return sub;
	}

	public int delete(String id) {
		int pos = findByID(id);
		if (pos >= 0) {
			list_subject.remove(pos);
		}
		return pos;
	}

	public int count() {
		return list_subject.size();
	}
}
