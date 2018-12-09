
import java.util.*;

public class StudentGrade 
{
	//variables declared as per requirement
	String name;
	char grade;
	int marks[];
	int average_mark;
	
	//function to calculate average marks
	void calculateAverage ()
	{
		average_mark = 0;
		average_mark = marks[0] + marks[1] + marks[2] + marks[3];
		average_mark = average_mark/4 ;
	}
	
	//function to calculate grade based on average marks
	void calculateGrade()
	{
		if(average_mark >= 90)
		{
			grade = 'A';
		}
		else if(average_mark >= 80)
		{
			grade = 'B';
		}
		else if(average_mark >= 70)
		{
			grade = 'C';
		}
		else if(average_mark >= 60)
		{
			grade = 'D';
		}
		else
		{
			grade = 'F';
		}
	}
	
	
	//constructor to initialize object
	public StudentGrade(String sname, int mk[]) 
	{
		name = sname;
		marks = mk;
		calculateAverage();
		calculateGrade();
	}
	
	//function to display the required details
	void display()
	{
		System.out.println("Name : "+name);
		System.out.println("Average Marks : "+average_mark);
		System.out.println("Grade : "+grade);
		System.out.println();
	}
	
	public static void main(String arg[])
	{
		//variable for taking input
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of students : ");
		//Taking no of students input from user
		int numberOfStudents = input.nextInt();
		
		//Declaring array of object of StudentGrade class
		StudentGrade objectArray[] = new StudentGrade[numberOfStudents];
		
		//loop for taking input of objectArray
		for(int j=0; j<numberOfStudents; j++)
		{
			String sname;
			//taking student name as input
			System.out.print("Enter the name of the student : ");
			sname = input.next();
			
			//taking marks of four test as input
			int smarks[] = new int[4];
			System.out.print("Enter the marks of student in four tests : ");
			
			for(int i=0; i<4; i++) 
			{
				smarks[i] = input.nextInt();
				//check whether the entered number is correct or not
				if(smarks[i]<0 || smarks[i]>100)
				{
					System.out.println("Entered marks is not valid. Please enter a valid mark between 0 and 100");
					i--;
				}
			}
			
			//initializing object of studentgrade class
			objectArray[j] = new StudentGrade(sname, smarks);
			
		}
		
		//display the grade of all students
		for(int i=0; i<numberOfStudents; i++)
		{
			objectArray[i].display();
		}
	}
}


