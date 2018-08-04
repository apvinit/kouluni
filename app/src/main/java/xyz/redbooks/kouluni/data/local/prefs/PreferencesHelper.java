package xyz.redbooks.kouluni.data.local.prefs;

/**
 * Created by h4rdw1r3 at 3:13 PM on 29/7/18
 */
public interface PreferencesHelper {

    // School Details Helper

    String getSchoolName();

    void setSetSchoolName(String schoolName);

    String getSchoolAddress();

    void setSchoolAddress(String schoolAddress);

    String getSchoolLogoUrl();

    void setSchoolLogoUrl(String schoolLogoUrl);

    // Student Details Helper

    String getStudentName();

    void setStudentName(String studentName);

    String getStudentFatherName();

    void setStudentFatherName(String fatherName);

    String getStudentMotherName();

    void setStudentMotherName(String motherName);

    String getStudentClassStandard();

    void setStudentClassStandard(String classStandard);

    String getStudentDob();

    void setStudentDob(String dob);

    String getStudentContactNo();

    void setStudentContactNo(String contactNo);

    String getStudentAddress();

    void setStudentAddress(String address);

    String getStudentProfilePicUrl();

    void setStudentProfilePicUrl(String profilePicUrl);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getAccessToken();

    void setAccessToken(String accessToken);
}
