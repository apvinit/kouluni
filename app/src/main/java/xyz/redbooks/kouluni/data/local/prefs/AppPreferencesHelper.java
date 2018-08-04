package xyz.redbooks.kouluni.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import xyz.redbooks.kouluni.R;

/**
 * Created by h4rdw1r3 at 3:14 PM on 29/7/18
 */
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String SCHOOL_NAME = "SCHOOL_NAME";
    private static final String SCHOOL_ADDRESS = "SCHOOL_ADDRESS";
    private static final String SCHOOL_LOGO_URL = "SCHOOL_LOGO_URL";

    private static final String STUDENT_NAME = "STUDENT_NAME";
    private static final String STUDENT_FATHER_NAME = "STUDENT_FATHER_NAME";
    private static final String STUDENT_MOTHER_NAME = "STUDENT_MOTHER_NAME";
    private static final String STUDENT_CLASS_STANDARD = "STUDENT_CLASS_STANDARD";
    private static final String STUDENT_DOB = "STUDENT_DOB";
    private static final String STUDENT_CONTACT_NO = "STUDENT_CONTACT_NO";
    private static final String STUDENT_ADDRESS = "STUDENT_ADDRESS";
    private static final String STUDENT_PROFILE_PIC_URL = "STUDENT_PROFILE_PIC_URL";

    private static final String CURRENT_USERNAME = "CURRENT_USERNAME";
    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    private final SharedPreferences prefs;
    private final Context context;
    private static AppPreferencesHelper INSTANCE;

    private AppPreferencesHelper(Context context, String prefName){
        this.context = context;
        prefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    public static AppPreferencesHelper getInstance(Context context, String prefName){
        if(INSTANCE == null){
            INSTANCE = new AppPreferencesHelper(context, prefName);
        }
        return INSTANCE;
    }


    @Override
    public String getSchoolName() {
        return prefs.getString(SCHOOL_NAME, context.getString(R.string.school_name));
    }

    @Override
    public void setSetSchoolName(String schoolName) {
        prefs.edit().putString(SCHOOL_NAME, schoolName).apply();
    }

    @Override
    public String getSchoolAddress() {
        return prefs.getString(SCHOOL_ADDRESS, context.getString(R.string.school_address));
    }

    @Override
    public void setSchoolAddress(String schoolAddress) {
        prefs.edit().putString(SCHOOL_ADDRESS, schoolAddress).apply();
    }

    @Override
    public String getSchoolLogoUrl() {
        return prefs.getString(SCHOOL_LOGO_URL, null);
    }

    @Override
    public void setSchoolLogoUrl(String schoolLogoUrl) {
        prefs.edit().putString(SCHOOL_LOGO_URL, schoolLogoUrl).apply();
    }

    @Override
    public String getStudentName() {
        return prefs.getString(STUDENT_NAME, context.getString(R.string.student_name));
    }

    @Override
    public void setStudentName(String studentName) {
        prefs.edit().putString(STUDENT_NAME, studentName).apply();
    }

    @Override
    public String getStudentFatherName() {
        return prefs.getString(STUDENT_FATHER_NAME, context.getString(R.string.father_name));
    }

    @Override
    public void setStudentFatherName(String fatherName) {
        prefs.edit().putString(STUDENT_FATHER_NAME, fatherName).apply();
    }

    @Override
    public String getStudentMotherName() {
        return prefs.getString(STUDENT_MOTHER_NAME, context.getString(R.string.mother_name));
    }

    @Override
    public void setStudentMotherName(String motherName) {
        prefs.edit().putString(STUDENT_MOTHER_NAME, motherName).apply();
    }

    @Override
    public String getStudentClassStandard() {
        return prefs.getString(STUDENT_CLASS_STANDARD, context.getString(R.string.student_class));
    }

    @Override
    public void setStudentClassStandard(String classStandard) {
        prefs.edit().putString(STUDENT_CLASS_STANDARD, classStandard).apply();
    }

    @Override
    public String getStudentDob() {
        return prefs.getString(STUDENT_DOB, context.getString(R.string.students_dob));
    }

    @Override
    public void setStudentDob(String dob) {
        prefs.edit().putString(STUDENT_DOB, dob).apply();
    }

    @Override
    public String getStudentContactNo() {
        return prefs.getString(STUDENT_CONTACT_NO, context.getString(R.string.student_contact_no));
    }

    @Override
    public void setStudentContactNo(String contactNo) {
        prefs.edit().putString(STUDENT_CONTACT_NO, contactNo).apply();
    }

    @Override
    public String getStudentAddress() {
        return prefs.getString(STUDENT_ADDRESS, context.getString(R.string.student_address));
    }

    @Override
    public void setStudentAddress(String address) {
        prefs.edit().putString(STUDENT_ADDRESS, address).apply();
    }

    @Override
    public String getStudentProfilePicUrl() {
        return prefs.getString(STUDENT_PROFILE_PIC_URL, null);
    }

    @Override
    public void setStudentProfilePicUrl(String profilePicUrl) {
        prefs.edit().putString(STUDENT_PROFILE_PIC_URL, profilePicUrl).apply();
    }

    @Override
    public String getCurrentUserName() {
        return prefs.getString(CURRENT_USERNAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        prefs.edit().putString(CURRENT_USERNAME, userName).apply();
    }

    @Override
    public String getAccessToken() {
        return prefs.getString(ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        prefs.edit().putString(ACCESS_TOKEN, accessToken).apply();
    }
}
