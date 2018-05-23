import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Test {
	
	static List<Student> list = new ArrayList<Student>();
	
	private static int sum1;
	private static int sum2;
	private static int sum3;
	private static int sum;
	private static int average;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		
		// to get the student details as input - Question Number 01
		do{
			System.out.println("Enter the registration number");
			String regNo = sc.next();
			System.out.println("Enter the first name");
			String fname = sc.next();
			System.out.println("Enter the last name");
			String lname = sc.next();
			
			int proj01projectMarks = validateMarks(sc, "Enter Project 01: Project marks");
			int proj01ICTMarks = validateMarks(sc, "Enter In Class Test 1 marks");
			int proj01Participation = validateMarks(sc, "Enter Project 01 attendance");
			
			int assignCoding = validateMarks(sc, "Enter Coding Assignment marks");
			int assignICT = validateMarks(sc, "Enter In Class Tets 2 marks");
			int assignParticipation = validateMarks(sc, "Enter Coding Assignment attendance");
			
			int proj02ICT= validateMarks(sc, "Enter In Class Test 3 Marks");
			int proj02projectMarks= validateMarks(sc, "Enter Project 02: Project marks");
			int proj02Participation= validateMarks(sc, "Enter Project 02 attendance");
			
			
			Student obj = new Student(regNo, fname, lname, proj01projectMarks, proj01ICTMarks,
										proj01Participation, assignCoding, assignICT, assignParticipation, 
										proj02ICT, proj02projectMarks, proj02Participation);
			list.add(obj);
			
			Project01Avg();
			AssignmentAvg();
			Project02Avg();
			ClassAvg();
			BelowAvg();
			RESIT();
			RETAKE();
			
			System.out.println("Do you want to continue (Type N to discontinue / any other to continue)");
			String answer = sc.next();
			if(answer.equalsIgnoreCase("N")){
				stop = true;
			}
			
		}while (stop != true);
		
		int y = list.size();
		int numberOfproject01 = 0;
		int numberOfassignment = 0;
		int numberOfproject02 = 0;
		
		
		for(Student obj : list){
			
			
			if (obj.getProject01Marks() < 40){
				numberOfproject01++;
			}
			
			if (obj.getAssignmentMarks() < 40){
				numberOfassignment++;
			}
			
			if (obj.getProject02Marks() < 40){
				numberOfproject02++;
			}
		}
		
		System.out.println("Number of student below 40 in Project is : "+numberOfproject01);
		System.out.println("Number of student below 40 in Assignment is : "+numberOfassignment);
		System.out.println("Number of student below 40 in ICT is : "+numberOfproject02);
		
		//sorting the student using their overall marks in the descending order
		
		Collections.sort(list);
		
		for (int i = (list.size() - 1); i >= 0; i--){
			System.out.println(list.get(i));
		}
		
		
		
		for (Student obj : list){
			System.out.println(obj);
		}

	}

	private static int validateMarks(Scanner sc, String label) {
		int marks;
		do{
			System.out.println(label);
			while(!sc.hasNextInt()){
				System.err.println("Invalid input please enter a marks within the range of 0 to 100");
				sc.next();
			}
			marks = sc.nextInt();
			if (!(marks >= 0 && marks <= 100)){
				System.err.println("Invalid marks and input a marks within the range of 0 to 100");
			}
		}while (!(marks >= 0 && marks <= 100));
		
		return marks;
	}
	
	
	private static void Project01Avg(){
		for(int i=0; i<list.size(); i++){
			sum1 += list.get(i).getProject01Marks();
		}
		int Project01Avg = sum1/list.size();
		System.out.println("Avarage marks for the Project 1 is: " + Project01Avg);
	}
		
	private static void AssignmentAvg(){
		for(int i=0; i<list.size(); i++){
			sum2 += list.get(i).getAssignmentMarks();
		}
		int AssignmentAvg = sum2/list.size();
		System.out.println("Avarage marks for Assignment is: " + AssignmentAvg);
	}
			
	private static void Project02Avg(){
		for(int i=0; i<list.size(); i++){
			sum3 += list.get(i).getProject02Marks();
		}
		int Project02Avg = sum3/list.size();
		System.out.println("Avarage marks for Project 2 is: " + Project02Avg);
    }
	
	private static void ClassAvg(){
		for(int i=0; i<list.size(); i++){
			sum += list.get(i).getOverallMarks();
		}
		average = sum/list.size();
		System.out.println("Overall class average:" + average);
    }
	
	private static void BelowAvg(){
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getOverallMarks()<average){
				
			}
		}
	}
	
	private static void RESIT(){
		System.out.println("Students for resit: ");
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getOverallMarks()<50 && (list.get(i).getProject01Marks()<40 || list.get(i).getAssignmentMarks()<40) || list.get(i).getProject02Marks()<40){
				System.out.println(list.get(i));
			}
		}
	}
	
	private static void RETAKE(){
		System.out.println("Students for retake: ");
		for (int i=0; i<list.size(); i++){
			if (list.get(i).getOverallMarks()<50){
				System.out.println(list.get(i));
			}
		}
	}
}