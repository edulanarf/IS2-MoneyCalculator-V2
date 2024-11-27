package software.ulpgc.moneycalculatorv2.architecture.model;

public record Currency(String code, String name, String symbol) {
    @Override
    public String toString() {
        return code;
    }
}
