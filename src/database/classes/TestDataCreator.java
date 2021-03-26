
package database.classes;


import java.time.LocalDate;
import java.util.ArrayList;
import object.classes.Assignment;
import object.classes.Course;
import object.classes.Student;
import object.classes.Trainer;

/**
 *
 * @author tsepe
 * Creates random data to our database.
 */
public class TestDataCreator {
    
    static DataBase data = DataBase.getInstance();                              //This is the program's database.
    
    public static void createData(){
    

    
//  We create the Trainers
    Trainer giorgos = new Trainer("Giorgos","Iraklidis","Daskalos Pliroforikis");
    Trainer giannis = new Trainer("Giannis","Mavros","Daskalos Pliroforikis");
    Trainer petros  = new Trainer("Petros","Papadopoulos","Full Stack Developer");
    Trainer nikos   = new Trainer("Nikos","Mathioudakis","Data analist");
    Trainer ioanna  = new Trainer("Ioanna","Spiropoulou","Front End Developer");
    
//  We save the Trainers in the database.
    data.saveTrainer(giorgos);
    data.saveTrainer(giannis);
    data.saveTrainer(petros);
    data.saveTrainer(nikos);
    data.saveTrainer(ioanna);
     
//  We create the Students 

    Student nikosT =        new Student("Nikos","Tsepetzidis", LocalDate.of(1989,9,19),2250);
    Student christosK =     new Student("Christos","Kotsiou",LocalDate.of(1988,3,15),2500);
    Student petrosT =       new Student("Petros","Tasou",LocalDate.of(1992,10,14),2250);
    Student giorgosA =      new Student("Giorgos","Argiriou",LocalDate.of(1988,03,15),2500);
    Student eiriniA =       new Student("Eirini","Anagnostou",LocalDate.of(1989,12,15),2000);
    Student eleniX =        new Student("Eleni","Xatzi",LocalDate.of(1999,03,03),2500);
    Student grigorisS =     new Student("Grigoris","Simaioforidis",LocalDate.of(1985,01,27),2000);
    Student christosB =     new Student("Christos","Bochoris",LocalDate.of(1983,07,21),2500);
    Student christosKod =   new Student("Christos","Kodozis",LocalDate.of(1987,3,05),2250);
    Student mariaL =        new Student("Maria","Likoudi",LocalDate.of(1991,07,21),2500);
    Student dimitraT =      new Student("Dimitra","Tsepetzidou",LocalDate.of(1983,06,18),2250);
    Student eiriniAd =      new Student("Eirini","Adamopoulou",LocalDate.of(2006,12,24),2250);
    Student kikiAd =        new Student("Kiriaki","Adamopoulou",LocalDate.of(2006,12,24),2250);
    Student dimitrisN =     new Student("Dimitris","Novas",LocalDate.of(1978,8,22),2500);
    Student steliosV =      new Student("Stelios","Valavanis",LocalDate.of(1982,9,07),2250);
    Student vasilisP =      new Student("Vasilis","Prekas",LocalDate.of(1983,12,29),2500);
    Student mixalisX =      new Student("Mixalis","Xasapis",LocalDate.of(1972,6,15),2250);
    Student nikosTse =      new Student("Nikos","Tsempoulatis",LocalDate.of(1991,7,5),2000);
    Student savvasG =       new Student("Savvas","Grigoriadis",LocalDate.of(1983,12,9),2250);
    Student mixalisT =      new Student("Mixalis","Tsepetzidis",LocalDate.of(1955,11,22),2000);
    Student manolisT =      new Student("Manolis","Tsepetzidis",LocalDate.of(1992,9,8),2000);
    Student eiriniM =       new Student("Eirini","Mavrogeorgi",LocalDate.of(1955,11,22),2000);
    Student thanasisV =     new Student("Thanasis","Vavatsikos",LocalDate.of(1993,6,3),2500);
    Student vickyS =     new Student("Vicky","Spanopoulou",LocalDate.of(1989,6,3),2250);
    
    
//  We save the Students in database.  
    data.saveStudent(nikosT);
    data.saveStudent(christosK);
    data.saveStudent(petrosT);
    data.saveStudent(giorgosA);
    data.saveStudent(eiriniA);
    data.saveStudent(eleniX);
    data.saveStudent(grigorisS);
    data.saveStudent(christosB);
    data.saveStudent(christosKod);
    data.saveStudent(mariaL);
    data.saveStudent(dimitraT);
    data.saveStudent(eiriniAd);
    data.saveStudent(kikiAd);
    data.saveStudent(dimitrisN);
    data.saveStudent(steliosV);
    data.saveStudent(vasilisP);
    data.saveStudent(mixalisX);
    data.saveStudent(nikosTse);
    data.saveStudent(savvasG);
    data.saveStudent(mixalisT);
    data.saveStudent(manolisT);
    data.saveStudent(eiriniM);
    data.saveStudent(thanasisV);
    data.saveStudent(vickyS);
     
//  We create the Courses
    Course javaMorning     = new Course("CB12","Java","Morning Lessons",LocalDate.of(2020,10,15),LocalDate.of(2021,3,15));
    Course pythonMorning   = new Course("CB12","Python","Morning Lessons",LocalDate.of(2020,11,1),LocalDate.of(2021,03,10));
    Course cSharpEvening   = new Course("CB13","C#","Evening Lessons",LocalDate.of(2021,2,15),LocalDate.of(2021,9,15));
    Course python          = new Course("CB13","Python","Evening Lessons",LocalDate.of(2021,3,1),LocalDate.of(2021,9,15));
    Course javaScript      = new Course("CB13","JavaScript","Evening Lessons",LocalDate.of(2020,10,1),LocalDate.of(2021,4,15));
    Course javaEvening     = new Course("CB13","Java","Evening Lessons",LocalDate.of(2021,02,15),LocalDate.of(2021,9,10));
    
//  We create Student lists for Courses
    ArrayList<Student> javaMorningStudents = new ArrayList();                   // List for javaMorning's Students
    javaMorningStudents.add(mixalisX);
    javaMorningStudents.add(nikosTse);
    javaMorningStudents.add(eiriniM);
    javaMorningStudents.add(eiriniAd);
    javaMorningStudents.add(grigorisS);
    
    ArrayList<Student> cSharpEveningStudents = new ArrayList();                 // List for cSharpEvening's Students
    cSharpEveningStudents.add(eiriniA);
    cSharpEveningStudents.add(christosB);
    cSharpEveningStudents.add(eleniX);
    cSharpEveningStudents.add(vasilisP);
    cSharpEveningStudents.add(dimitrisN);
    cSharpEveningStudents.add(manolisT);
    
    ArrayList<Student> pythonStudents = new ArrayList();                        // List for python's Students
    pythonStudents.add(mixalisT);
    pythonStudents.add(savvasG);
    pythonStudents.add(kikiAd);
    pythonStudents.add(giorgosA);
    pythonStudents.add(mixalisX);
    
    ArrayList<Student> javaScriptStudents = new ArrayList();                    // List for javaScript's Students
    javaScriptStudents.add(mixalisX);
    javaScriptStudents.add(nikosTse);
    javaScriptStudents.add(kikiAd);
    javaScriptStudents.add(petrosT);
    javaScriptStudents.add(eiriniM);
    
    ArrayList<Student> javaEveningStudents = new ArrayList();                   // List for javaEvening's Students
    javaEveningStudents.add(nikosT);
    javaEveningStudents.add(christosK);
    javaEveningStudents.add(christosKod);
    javaEveningStudents.add(mariaL);
    javaEveningStudents.add(thanasisV);
    javaEveningStudents.add(steliosV);
    javaEveningStudents.add(vickyS);
    
    
    ArrayList<Student> pythonMorningStudents = new ArrayList();                 // List for pythonMorning's Students
    pythonMorningStudents.add(nikosT);                          
    pythonMorningStudents.add(christosK);
    pythonMorningStudents.add(grigorisS);
    pythonMorningStudents.add(petrosT);
    pythonMorningStudents.add(dimitraT);
    
    
    //  We create Student lists for Courses
    ArrayList<Trainer> javaMorningTrainers = new ArrayList();                   // List for javaMorning's Trainers
    javaMorningTrainers.add(giorgos);
    javaMorningTrainers.add(petros);
    
    ArrayList<Trainer> cSharpEveningTrainers = new ArrayList();                 // List for cSharpEvening's Trainers
    cSharpEveningTrainers.add(giannis);
    cSharpEveningTrainers.add(nikos);
    
    ArrayList<Trainer> pythonTrainers = new ArrayList();                        // List for python's Trainers
    pythonTrainers.add(ioanna);
    pythonTrainers.add(nikos);
    pythonTrainers.add(petros);
    
    ArrayList<Trainer> javaScriptTrainers = new ArrayList();                    // List for javaScript's Trainers
    javaScriptTrainers.add(giorgos);
    javaScriptTrainers.add(ioanna);
    
    ArrayList<Trainer> javaEveningTrainers = new ArrayList();                   // List for javaEvening's Trainers
    javaEveningTrainers.add(giannis);
    javaEveningTrainers.add(petros);
    
    ArrayList<Trainer> pythonMorningTrainers = new ArrayList();                 // List for pythonMorning's Trainers
    pythonMorningTrainers.add(nikos);
    pythonMorningTrainers.add(petros);
    
    
//  We save the Courses in the database.
    data.saveCourse(javaMorning,javaMorningStudents,javaMorningTrainers);
    data.saveCourse(pythonMorning,pythonMorningStudents,pythonMorningTrainers);
    data.saveCourse(cSharpEvening,cSharpEveningStudents,cSharpEveningTrainers);
    data.saveCourse(python,pythonStudents,pythonTrainers);
    data.saveCourse(javaScript,javaScriptStudents,javaScriptTrainers);
    data.saveCourse(javaEvening,javaEveningStudents,javaEveningTrainers);
    
    
//  Create Assignments
    Assignment schoolManagementA =   new Assignment("Indivigual Project Part A","School managment programm without database",LocalDate.of(2021,03,30),50,100);
    Assignment schoolManagementB =   new Assignment("Indivigual Project Part B","School managment programm with database",LocalDate.of(2021,05,10),20,100);
    Assignment cinemaManagementA =   new Assignment("Indivigual Project Part A","Cinema managment programm without database",LocalDate.of(2020,11,30),50,100);
    Assignment cinemaManagementB =   new Assignment("Indivigual Project Part B","Cinema managment programm with database",LocalDate.of(2021,02,15),20,100);
    Assignment libraryManagementA =  new Assignment("Indivigual Project Part A","Library managment programm without database",LocalDate.of(2020,12,15),50,100);
    Assignment libraryManagementB =  new Assignment("Indivigual Project Part B","Library managment programm with database",LocalDate.of(2021,02,02),20,100);
    
//  Creates Assignmente's courses list and adds the courses
    ArrayList<Course> schoolManagementACourses = new ArrayList();                // List for schoolManagmentA's Courses
    schoolManagementACourses.add(cSharpEvening);
    schoolManagementACourses.add(python);
    schoolManagementACourses.add(javaEvening);
    
    ArrayList<Course> schoolManagementBCourses = new ArrayList();                // List for schoolManagmentB's Courses
    schoolManagementBCourses.add(cSharpEvening);
    schoolManagementBCourses.add(python);
    schoolManagementBCourses.add(javaEvening);
    
    ArrayList<Course> cinemaManagementACourses = new ArrayList();                // List for cinemaManagmentA's Courses
    cinemaManagementACourses.add(javaMorning);
    cinemaManagementACourses.add(pythonMorning);
    
    ArrayList<Course> cinemaManagementBCourses = new ArrayList();                // List for cinemaManagmentB's Courses
    cinemaManagementBCourses.add(javaMorning);
    cinemaManagementBCourses.add(pythonMorning);
    
    ArrayList<Course> libraryManagementACourses = new ArrayList();               // List for libraryManagmentA's Courses
    libraryManagementACourses.add(javaScript);
    
    ArrayList<Course> libraryManagementBCourses = new ArrayList();               // List for libraryManagmentB's Courses
    libraryManagementBCourses.add(javaScript);
    
    
//  saves the assignments into the database

    data.saveAssignment(schoolManagementA, schoolManagementACourses);
    data.saveAssignment(schoolManagementB, schoolManagementBCourses);
    data.saveAssignment(cinemaManagementA, cinemaManagementACourses);
    data.saveAssignment(cinemaManagementB, cinemaManagementBCourses);
    data.saveAssignment(libraryManagementA, libraryManagementACourses);
    data.saveAssignment(libraryManagementB, libraryManagementBCourses);

    
    
//  Gives marks in Students    

    //javaMorning course
    mixalisX.saveAssignmentMark(cinemaManagementA, javaMorning, 45, 80);
    mixalisX.saveAssignmentMark(cinemaManagementB, javaMorning, 19, 90);
    nikosTse.saveAssignmentMark(cinemaManagementA, javaMorning, 46, 85);
    nikosTse.saveAssignmentMark(cinemaManagementB, javaMorning, 20, 90);
    eiriniM.saveAssignmentMark(cinemaManagementA, javaMorning, 50, 95);
    eiriniM.saveAssignmentMark(cinemaManagementB, javaMorning, 20, 99);
    eiriniAd.saveAssignmentMark(cinemaManagementA, javaMorning, 49, 93);
    eiriniAd.saveAssignmentMark(cinemaManagementB, javaMorning, 19, 95);
    grigorisS.saveAssignmentMark(cinemaManagementA, javaMorning, 50, 96);
    grigorisS.saveAssignmentMark(cinemaManagementB, javaMorning, 15, 95);
    
    
    //pythonMorning course
    nikosT.saveAssignmentMark(cinemaManagementA, pythonMorning, 50, 100);
    nikosT.saveAssignmentMark(cinemaManagementB, pythonMorning, 20, 100);
    christosK.saveAssignmentMark(cinemaManagementA, pythonMorning, 46, 85);
    christosK.saveAssignmentMark(cinemaManagementB, pythonMorning, 20, 90);
    grigorisS.saveAssignmentMark(cinemaManagementA, pythonMorning, 50, 95);
    grigorisS.saveAssignmentMark(cinemaManagementB, pythonMorning, 20, 99);
    petrosT.saveAssignmentMark(cinemaManagementA, pythonMorning, 49, 93);
    petrosT.saveAssignmentMark(cinemaManagementB, pythonMorning, 19, 95);
    dimitraT.saveAssignmentMark(cinemaManagementA, pythonMorning, 50, 96);
    dimitraT.saveAssignmentMark(cinemaManagementB, pythonMorning, 15, 95);
    
    
    //javaEvening course
     nikosT.saveAssignmentMark(schoolManagementA, javaEvening, 50, 100);
     christosK.saveAssignmentMark(schoolManagementA, javaEvening, 45, 90);
     christosKod.saveAssignmentMark(schoolManagementA, javaEvening, 50, 100);
     mariaL.saveAssignmentMark(schoolManagementA, javaEvening, 49, 96);
     thanasisV.saveAssignmentMark(schoolManagementA, javaEvening, 50, 100);
     steliosV.saveAssignmentMark(schoolManagementA, javaEvening, 40, 85);
     vickyS.saveAssignmentMark(schoolManagementA, javaEvening, 49, 99);
     
     
     //python course -> giorgosA has not delivered his assignment yet
     mixalisT.saveAssignmentMark(schoolManagementA, python, 50, 100);
     savvasG.saveAssignmentMark(schoolManagementA, python, 45, 90);
     kikiAd.saveAssignmentMark(schoolManagementA, python, 45, 95);
     mixalisX.saveAssignmentMark(schoolManagementA, python, 40, 90);
     
     
     //cSharpEvening course -> christosB and dimitrisN have not delivered their assignments yet
     manolisT.saveAssignmentMark(schoolManagementA, cSharpEvening, 50, 100);
     eiriniA.saveAssignmentMark(schoolManagementA, cSharpEvening, 48, 98);
     eleniX.saveAssignmentMark(schoolManagementA, cSharpEvening, 40, 80);
     vasilisP.saveAssignmentMark(schoolManagementA, cSharpEvening, 45, 95);
     
     
     //javaScript course
     mixalisX.saveAssignmentMark(libraryManagementA, javaScript, 48, 98);
     mixalisX.saveAssignmentMark(libraryManagementB, javaScript, 20, 90);
     nikosTse.saveAssignmentMark(libraryManagementA, javaScript, 40, 88);
     nikosTse.saveAssignmentMark(libraryManagementB, javaScript, 20, 90);
     kikiAd.saveAssignmentMark(libraryManagementA, javaScript, 47, 95);
     kikiAd.saveAssignmentMark(libraryManagementB, javaScript, 19, 96);
     petrosT.saveAssignmentMark(libraryManagementA, javaScript, 35, 81);
     petrosT.saveAssignmentMark(libraryManagementB, javaScript, 15, 88);
     eiriniM.saveAssignmentMark(libraryManagementA, javaScript, 50, 100);
     eiriniM.saveAssignmentMark(libraryManagementB, javaScript, 20, 100);
    }
    
}
