package xyz.redbooks.kouluni.data;

import android.content.Context;

import java.util.List;

import xyz.redbooks.kouluni.data.local.db.AppDbHelper;
import xyz.redbooks.kouluni.data.local.db.DbHelper;
import xyz.redbooks.kouluni.data.local.prefs.AppPreferencesHelper;
import xyz.redbooks.kouluni.data.local.prefs.PreferencesHelper;
import xyz.redbooks.kouluni.data.model.db.Attendance;
import xyz.redbooks.kouluni.data.model.db.Holiday;
import xyz.redbooks.kouluni.data.model.db.Notice;
import xyz.redbooks.kouluni.data.model.db.ParentMessage;

/**
 * Created by h4rdw1r3 at 3:16 PM on 29/7/18
 */
public class AppDataManager implements DataManager {

    private static AppDataManager INSTANCE;

    private final DbHelper appDbHelper;
    private final PreferencesHelper appPreferenceHelper;

    private AppDataManager(Context context){
        appDbHelper = AppDbHelper.getInstance(context);
        appPreferenceHelper = AppPreferencesHelper.getInstance(context,"AppPrefs");
    }

    public static AppDataManager getInstance(Context context){
        if(INSTANCE == null)
            INSTANCE = new AppDataManager(context);

        return INSTANCE;
    }

    @Override
    public List<Notice> getAllNotices() {
        return appDbHelper.getAllNotices();
    }

    @Override
    public void insertNotice(Notice notice) {
        appDbHelper.insertNotice(notice);
    }

    @Override
    public List<Holiday> getAllHolidays() {
        return appDbHelper.getAllHolidays();
    }

    @Override
    public void insertHoliday(Holiday holiday) {
        appDbHelper.insertHoliday(holiday);
    }

    @Override
    public List<ParentMessage> getAllMessages() {
        return appDbHelper.getAllMessages();
    }

    @Override
    public void insertMessage(ParentMessage message) {
        appDbHelper.insertMessage(message);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return appDbHelper.getAllAttendances();
    }

    @Override
    public void insertAttendance(Attendance attendance) {
        appDbHelper.insertAttendance(attendance);
    }

    @Override
    public String getSchoolName() {
        return appPreferenceHelper.getSchoolName();
    }

    @Override
    public void setSetSchoolName(String schoolName) {
        appPreferenceHelper.setSetSchoolName(schoolName);
    }

    @Override
    public String getSchoolAddress() {
        return appPreferenceHelper.getSchoolAddress();
    }

    @Override
    public void setSchoolAddress(String schoolAddress) {
        appPreferenceHelper.setSchoolAddress(schoolAddress);
    }

    @Override
    public String getSchoolLogoUrl() {
        return appPreferenceHelper.getSchoolLogoUrl();
    }

    @Override
    public void setSchoolLogoUrl(String schoolLogoUrl) {
        appPreferenceHelper.setSchoolLogoUrl(schoolLogoUrl);
    }

    @Override
    public String getStudentName() {
        return appPreferenceHelper.getStudentName();
    }

    @Override
    public void setStudentName(String studentName) {
        appPreferenceHelper.setStudentName(studentName);
    }

    @Override
    public String getStudentFatherName() {
        return appPreferenceHelper.getStudentFatherName();
    }

    @Override
    public void setStudentFatherName(String fatherName) {
        appPreferenceHelper.setStudentFatherName(fatherName);
    }

    @Override
    public String getStudentMotherName() {
        return appPreferenceHelper.getStudentMotherName();
    }

    @Override
    public void setStudentMotherName(String motherName) {
        appPreferenceHelper.setStudentMotherName(motherName);
    }

    @Override
    public String getStudentClassStandard() {
        return appPreferenceHelper.getStudentClassStandard();
    }

    @Override
    public void setStudentClassStandard(String classStandard) {
        appPreferenceHelper.setStudentClassStandard(classStandard);
    }

    @Override
    public String getStudentDob() {
        return appPreferenceHelper.getStudentDob();
    }

    @Override
    public void setStudentDob(String dob) {
        appPreferenceHelper.setStudentDob(dob);
    }

    @Override
    public String getStudentContactNo() {
        return appPreferenceHelper.getStudentContactNo();
    }

    @Override
    public void setStudentContactNo(String contactNo) {
        appPreferenceHelper.setStudentContactNo(contactNo);
    }

    @Override
    public String getStudentAddress() {
        return appPreferenceHelper.getStudentAddress();
    }

    @Override
    public void setStudentAddress(String address) {
        appPreferenceHelper.setStudentAddress(address);
    }

    @Override
    public String getStudentProfilePicUrl() {
        return appPreferenceHelper.getStudentProfilePicUrl();
    }

    @Override
    public void setStudentProfilePicUrl(String profilePicUrl) {
        appPreferenceHelper.setStudentProfilePicUrl(profilePicUrl);
    }

    @Override
    public String getCurrentUserName() {
        return appPreferenceHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        appPreferenceHelper.setCurrentUserName(userName);
    }

    @Override
    public String getAccessToken() {
        return appPreferenceHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        appPreferenceHelper.setAccessToken(accessToken);
    }
}
