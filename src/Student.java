
public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private String regNo;
	
	private int project01projectMarks;
	private int project01ICTMarks;
	private int project01Participation;
	
	private int assignmentCoding;
	private int assignmentICT;
	private int assignmentParticipation;
	
	private int project02ICT;
	private int project02projectMarks;
	private int project02Participation;
	
	private int overallMarks;
	private Grade grade;
	
	public Student(String regNo, String firstName, String lastName, 
			int project01projectMarks, int project01ICTMarks, int project01Participation,
			int assignmentCoding, int assignmentICT, int assignmentParticipation,
			int project02ICT, int project02projectMarks, int project02Participation) {
		 
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNo = regNo;
		
		this.project01projectMarks = validateMarks(project01projectMarks);
		this.project01ICTMarks = validateMarks(project01ICTMarks);
		this.project01Participation = validateMarks(project01Participation);
		
		this.assignmentCoding = validateMarks(assignmentCoding);
		this.assignmentICT = validateMarks(assignmentICT);
		this.assignmentParticipation = validateMarks(assignmentParticipation);
		
		this.project02ICT = validateMarks(project02ICT);
		this.project02projectMarks = validateMarks(project02projectMarks);
		this.project02Participation = validateMarks(project02Participation);

		calcProject01();
		calcAssignment();
		calcProject02();
		calcOverallMarks();
		calcGrade();
	}
	
	private int project01;
	private int assignment;
	private int project02;
	
	private int project01Avg;
	private int assighnmentAvg;
	private int project02avg;
	private int classAvg;
	
	private void calcGrade() {
		if(overallMarks>=80){
			grade = Grade.HD;
		}else if (overallMarks >=70){
			grade = Grade.D;
		}else if(overallMarks >=60){
			grade = Grade.C;
		}else if(overallMarks >=50){
			grade = Grade.PASS;
		}else{
			grade = Grade.RETAKE;
		}
		if (overallMarks >= 50 && (project01 <= 40 || assignment <= 40 || project02 <= 40)){
			grade = Grade.RESIT;
		}
			
	}
	
	private void calcProject01(){
		project01 = (int)Math.round(project01projectMarks * 0.2 + project01ICTMarks * 0.7 + project01Participation*0.1);
	}
	private void calcAssignment(){
		assignment = (int)Math.round(assignmentCoding*0.5 + assignmentICT*0.4 + assignmentParticipation*0.1);
	}
	private void calcProject02(){
		project02 = (int)Math.round(project02ICT*0.6 + project02projectMarks*0.3 + project02Participation*0.1);
	}
	private void calcOverallMarks() {
		overallMarks = (int)Math.round(project01 * 0.3  + assignment * 0.35 + project02 * 0.35);
	}
	
	

	public void setProject01projectMarks(int project01projectMarks) {
		this.project01projectMarks = project01projectMarks;
	}


	public int getProject01ICTMarks() {
		return project01ICTMarks;
	}


	public void setProject01ICTMarks(int project01ictMarks) {
		project01ICTMarks = project01ictMarks;
	}


	public int getProject01Participation() {
		return project01Participation;
	}


	public void setProject01Participation(int project01Participation) {
		this.project01Participation = project01Participation;
	}


	public int getAssignmentCoding() {
		return assignmentCoding;
	}


	public void setAssignmentCoding(int assignmentCoding) {
		this.assignmentCoding = assignmentCoding;
	}


	public int getAssignmentICT() {
		return assignmentICT;
	}


	public void setAssignmentICT(int assignmentICT) {
		this.assignmentICT = assignmentICT;
	}


	public int getAssignmentParticipation() {
		return assignmentParticipation;
	}


	public void setAssignmentParticipation(int assignmentParticipation) {
		this.assignmentParticipation = assignmentParticipation;
	}


	public int getProject02ICT() {
		return project02ICT;
	}


	public void setProject02ICT(int project02ict) {
		project02ICT = project02ict;
	}


	public int getProject02projectMarks() {
		return project02projectMarks;
	}


	public void setProject02projectMarks(int project02projectMarks) {
		this.project02projectMarks = project02projectMarks;
	}


	public int getProject02Participation() {
		return project02Participation;
	}


	public void setProject02Participation(int project02Participation) {
		this.project02Participation = project02Participation;
	}


	public void setOverallMarks(int overallMarks) {
		this.overallMarks = overallMarks;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getRegNo() {
		return regNo;
	}
	
	public int validateMarks(int marks) {		
		if(!(marks >= 0 && marks <= 100)){
			throw new IllegalArgumentException("Marks are to be more than or equals to 0 and less then or equals to 100.");
		}
		return marks;
	}
	
	public int getProject01Marks(){
		return project01;
	}
	public int getAssignmentMarks() {
		return assignment;
	}
	
	public int getProject02Marks() {
		return project02;
	}
	
	public int getOverallMarks() {
		return overallMarks;
	}
	public Grade getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "[first Name=" + firstName + ", last Name=" + lastName
				+ ", regNo=" + regNo + ", Project01 Marks=" + project01
				+ ", assignment marks=" + assignment + ", Project02 Marks="
				+ project02 + ", overallMarks=" + overallMarks + ", grade="
				+ grade + "]";
		
	
	}

	@Override
	public int compareTo(Student o) {
		return this.overallMarks - o.overallMarks;
	}
	
	
}
