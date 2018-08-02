package xyz.redbooks.kouluni.ui.user.profile;

import xyz.redbooks.kouluni.ui.base.BasePresenter;
import xyz.redbooks.kouluni.ui.base.BaseView;

/*
 * Created by h4rdw1r3 at 5:27 PM on 30/7/18
 */
public interface ProfileContract {

    interface View extends BaseView<Presenter> {

        void setProfileImage();

        void setStudentName(String name);

        void setFatherName(String fatherName);

        void setMotherName(String motherName);

        void setDateOfBirth(String dob);

        void setContactNo(String contactNo);

        void setAddress(String address);

        void setClassStandard(String classStandard);

    }

    interface Presenter extends BasePresenter {

    }
}
