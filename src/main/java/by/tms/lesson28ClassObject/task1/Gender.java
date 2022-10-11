package by.tms.lesson28ClassObject.task1;

public enum Gender {

    MAN ("man"),
    WOMAN ("woman");

    public final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
