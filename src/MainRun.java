import java.util.Scanner;

import entity.ScoreDetails;
import entity.Scores;
import entity.Student;
import entity.Subject;

public class MainRun {

	private static Student[] STUDENTS = new Student[100];
	private static Subject[] SUBJECTS = new Subject[100];
	private static Scores[] SCORES = new Scores[100];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();

	}
	
	private static void showMenu() {
        while (true) {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    inputNewStudent();
                    break;
                case 2:
                    showStudent(STUDENTS);
                    break;
                case 3:
                    inputNewSubject();
                    break;
                case 4:
                    showSubject(SUBJECTS);
                    break;
                case 5:
                    createScores();
                    showScores(SCORES);
                    break;
                case 6:
                    showSortingScores();
                    break;
                case 7:
                    showGPA();
                    break;
                case 8:
                    System.out.println("Xin cảm ơn đã sử dụng phần mềm của chúng tôi!");
                    return;
            }
        }
    }
	

	private static int functionChoice() {
        System.out.println("\n\n===== PHẦN MỀM QUẢN LÝ ĐIỂM SINH VIÊN =====\n\n");
        System.out.println("1. Nhập danh sách sinh viên mới.");
        System.out.println("2. In ra danh sách sinh viên trong hệ thống.");
        System.out.println("3. Nhập danh sách môn học mới.");
        System.out.println("4. In ra danh sách môn học trong hệ thống.");
        System.out.println("5. Lập bảng điểm cho mỗi sinh viên.");
        System.out.println("6. Sắp xếp danh sách bảng điểm.");
        System.out.println("7. Tính điểm tổng kết chung cho mỗi sinh viên.");
        System.out.println("8. Thoát chương trình");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");
        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 8 || functionChoice < 1);
        return functionChoice;
    }
	
	private static void inputNewStudent() {
		// TODO Auto-generated method stub
		System.out.print("Nhập số lượng sinh viên mới muốn thêm: ");
        int newStudentNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newStudentNumber; i++) {
            System.out.println("Nhập thông tin cho sinh viên thứ " + (i + 1));
            Student student = new Student();
            student.inputInfo();
            saveStudent(student);
        }
	}

	private static void saveStudent(Student student) {
		for (int j = 0; j < STUDENTS.length; j++) {
            if (STUDENTS[j] == null) {
            	STUDENTS[j] = student;
                break;
            }
        }
	}

	private static void showStudent(Student[] students) {
		// TODO Auto-generated method stub
		for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                continue;
            }
            System.out.println(students[i]);
        }
	}

	private static void inputNewSubject() {
		// TODO Auto-generated method stub
		System.out.print("Nhập số lượng môn học mới muốn thêm: ");
        int newSubjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newSubjectNumber; i++) {
            System.out.println("Nhập thông tin cho môn học thứ " + (i + 1));
            Subject subject = new Subject();
            subject.inputInfo();
            saveSubject(subject);
        }
	}

	private static void saveSubject(Subject subject) {
		for (int j = 0; j < SUBJECTS.length; j++) {
            if (SUBJECTS[j] == null) {
            	SUBJECTS[j] = subject;
                break;
            }
        }
	}

	private static void showSubject(Subject[] subjects) {
		// TODO Auto-generated method stub
		for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                continue;
            }
            System.out.println(subjects[i]);
        }
	}

	// check data
	
    private static boolean checkStudentData() {
		for (int i = 0; i < SUBJECTS.length; i++) {
			if (SUBJECTS[i] != null) {
				return true;
			}
		}
		return false;
    }
    
    private static boolean checkSubjectData() {
		for (int i = 0; i < SUBJECTS.length; i++) {
			if (SUBJECTS[i] != null) {
				return true;
			}
		}
		return false;
    }
    
    private static boolean checkScoreData() {
		for (int i = 0; i < SCORES.length; i++) {
			if (SCORES[i] != null) {
				return true; // có dữ liệu
			}
		}
		return false; // k có dữ liệu
    }
	
	//Nhập hiện bảng điểm
	
	private static void createScores() {
		// TODO Auto-generated method stub
		if(!(checkStudentData()&&checkSubjectData())) {
			System.out.println("Chưa có dữ liệu về học sinh hoặc môn học. Vui lòng nhập trước đã!");
			return;
		}
		System.out.print("Nhập số lượng sinh viên cần nhập điểm: ");
		int studentNumber = new Scanner(System.in).nextInt();
		
		for(int i = 0; i < studentNumber; i++) {
			Scores score = new Scores();
			Student student = pushStudent(i);
			score.setStudent(student);
			ScoreDetails[] scoreDetails = createScoreDetails(student.getId());
			score.setScoreDetails(scoreDetails);
			saveScore(score);
		}
	}
	
	private static ScoreDetails[] createScoreDetails(int idStudent) {
        System.out.print("Nhập số lượng môn học của sinh viên này: ");
        int subjectQuantity = new Scanner(System.in).nextInt();
        ScoreDetails[] scoreDetails = new ScoreDetails[subjectQuantity];
		
        for(int j = 0; j < subjectQuantity; j++) {
        	ScoreDetails scoreDetail = new ScoreDetails();
        	Subject subject = pushSubject(j);
        	if(!isScoreDetailExist(idStudent,subject.getId())) {
        		//check nếu scoreDetail đã tồn tại
        		
            	scoreDetail.setSubject(subject);
            	
        		System.out.print("Nhập điểm của môn học này: ");
            	int score;
            	do {
            		score = new Scanner(System.in).nextInt();
                    if (score >= 0 && score <= 10) {
                        break;
                    }
                    System.out.print("Điểm phải 0 <= điểm <= 10, vui lòng nhập lại: ");
                } while (true);
            	
                scoreDetail.setScore(score);
            	
                //save detail vao danh sach details
                for (int i = 0; i < scoreDetails.length; i++) {
                    if (scoreDetails[i] == null) {
                    	scoreDetails[i] = scoreDetail;
                        break;
                    }
                }
        	} else {
        		System.out.println("Điểm môn học của sinh viên này đã tồn tại");
        		j--;
        	}
        }
        
		return scoreDetails;
		
	}
	
	private static Student pushStudent(int index) {
		System.out.print("Xin mời nhập mã sinh viên thứ " + (index + 1) + " cần nhập điểm: ");
        int idStudent;
        Student student;
        do {
            idStudent = new Scanner(System.in).nextInt();
            student = searchStudentById(idStudent);
            if (student != null) {
                break;
            }
            System.out.print("Không tồn tại sinh viên có ID là " + idStudent + ", vui lòng nhập lại: ");
        } while (true);
        return student;
				
	}
	
	private static Subject pushSubject(int index) {
		System.out.print("Xin mời nhập ID của môn học thứ " + (index + 1) + " cần nhập điểm: ");
        int idSubject;
        Subject subject;
        do {
            idSubject = new Scanner(System.in).nextInt();
            subject = searchSubjectById(idSubject);
            if (subject != null) {
                break;
            }
            System.out.print("Không tồn tại môn học có ID là " + idSubject + ", vui lòng nhập lại: ");
        } while (true);
        
        
        return subject;
	}
	
	
	private static boolean isScoreDetailExist(int idStudent, int idSubject) {
    	if(!checkScoreData()) return false; 
    	for(int i=0; i < SCORES.length; i++) {
    		if(SCORES[i] != null) {
    			if(SCORES[i].getStudent().getId() == idStudent) {
    				ScoreDetails[] scoreDetails = SCORES[i].getScoreDetails();
    				for(int j = 0; j < scoreDetails.length; j++) {
    					if(scoreDetails[j].getSubject().getId() == idSubject) {
    	    				return true; // đã tồn tại
    					}
    				}
    			}
    		}
    	}
    	return false;
    }

    private static Student searchStudentById(int idStudent) {
        for (int i = 0; i < STUDENTS.length; i++) {
            Student student = STUDENTS[i];
            if (student != null && student.getId() == idStudent) {
                return student;
            }
        }
        return null;
    }
	
	private static Subject searchSubjectById (int idSubject) {
        for (int i = 0; i < SUBJECTS.length; i++) {
        	Subject subject = SUBJECTS[i];
            if (subject != null && subject.getId() == idSubject) {
                return subject;
            }
        }
        return null;
    }
	
	
	private static void saveScore(Scores score) {
		for (int j = 0; j < SCORES.length; j++) {
            if (SCORES[j] == null) {
            	SCORES[j] = score;
                break;
            }
        }
	}

	private static void showScores(Scores[] scores) {
		// TODO Auto-generated method stub
		for (int i = 0; i < scores.length; i++) {
            Scores score = scores[i];
            if (score != null) {
                System.out.println("Sinh viên " + score.getStudent().getName() + " có điểm của các môn học sau: ");
                for (int j = 0; j < score.getScoreDetails().length; j++) {
                    System.out.println(score.getScoreDetails()[j]);
                }
                System.out.println("-------------------------------");
            }
        }
	}

	private static void showSortingScores() {
		// TODO Auto-generated method stub
		
	}

    private static void showGPA() {
		// TODO Auto-generated method stub
		
	}


}
