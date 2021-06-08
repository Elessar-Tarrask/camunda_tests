package kz.khaz.camunda.entity.common.enum_folder;

public enum DocumentType {
    ID("удостоверение личности"), passport("Паспорт");

    private final String name;

    private DocumentType(String name) {
        this.name = name;
    }
}
