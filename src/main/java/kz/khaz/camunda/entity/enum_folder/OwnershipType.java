package kz.khaz.camunda.entity.enum_folder;

public enum OwnershipType {
    // TODO add other ownership types if necessary
    IE("individual entrepreneur", "Индивидуальный предприниматель", 1);

    public final String label;
    public final String label_rus;
    public final Integer code;

    private OwnershipType(String label, String label_rus, Integer code) {
        this.label = label;
        this.label_rus = label_rus;
        this.code = code;
    }
}
