public enum StudyProfile {
    MEDECINA ("Медицина"),
    ECONOMICA ("Экономика"),
    INFORMACIONNIE_TEHNOLOGII ("Информационные технологии"),
    TEHNIKA_I_TEHNOLOGIA ("Техника и технология"),
    ISSCUSTVO ("Исскуство");

    private final String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
