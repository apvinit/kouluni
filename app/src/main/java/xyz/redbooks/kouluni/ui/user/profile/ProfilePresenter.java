package xyz.redbooks.kouluni.ui.user.profile;

import xyz.redbooks.kouluni.data.model.db.Student;

/*
 * Created by h4rdw1r3 at 7:27 PM on 2/8/18
 */
public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View profileView;
    private static ProfilePresenter INSTANCE;

    private Student student;

    private ProfilePresenter(ProfileContract.View view) {
        profileView = view;
        profileView.setPresenter(this);
    }

    public static ProfilePresenter getInstance(ProfileContract.View view){
        if(INSTANCE == null){
            INSTANCE = new ProfilePresenter(view);
        }
        return INSTANCE;
    }

    public void updateViewReference(ProfileContract.View view){
        profileView = view;
        profileView.setPresenter(this);
    }


    @Override
    public void start() {
        createStudent();
        profileView.setStudentName(student.getName());
        profileView.setFatherName(student.getFatherName());
        profileView.setMotherName(student.getMotherName());
        profileView.setClassStandard(student.getClassStandard());
        profileView.setDateOfBirth(student.getDob());
        profileView.setContactNo(student.getContactNo());
        profileView.setAddress(student.getAddress());

    }

    private void createStudent(){
        student = new Student();
        student.setName("Rahul Anand");
        student.setFatherName("Anand Singh");
        student.setMotherName("Alisha Singh");
        student.setClassStandard("12 (D)");
        student.setDob("8-09-1998");
        student.setContactNo("9876543210");
        student.setAddress("H-No: 29, Police Colony Patna 800001");
    }
}
