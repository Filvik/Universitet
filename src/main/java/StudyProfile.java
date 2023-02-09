public enum StudyProfile {
    MEDICINE ("Медицина"),
    ECONOMICA ("Экономика"),
    INFORMACIONNIE_TEHNOLOGII ("Информационные технологии"),
    TEHNIKA_I_TEHNOLOGIA ("Техника и технология"),
    ISCUSSTVO ("Искусство"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика");


    private final String profileName;
    StudyProfile(String profileName){
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
