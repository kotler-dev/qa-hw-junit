package data;

public enum Language {

    // Language Bindings
    CPP("C++"),
    GUILE("Guile"),
    JAVASCRIPT("Javascript"),
    PYTHON("Python"),
    RUST("Rust"),
    VALA("Vala"),
    ;

    public final String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
