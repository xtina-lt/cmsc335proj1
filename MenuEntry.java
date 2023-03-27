import java.util.function.Function;

public abstract class MenuEntry<Anything> {
    private final String label;

    public MenuEntry(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }

    abstract public Anything get();
        public String getQuestion(String attribute) {
            return String.format("What is the %s for %s?", attribute, label);
    }

    abstract public String getAttribute(String attribute);

    public Integer getPositiveIntegerAttribute(String attribute) {
        return getIntegerAttribute(attribute, (e) -> (e > 0));
    }

    public Integer getIntegerAttribute(String attribute, Function<Integer, Boolean> filter) {
        final Integer value = Integer.valueOf(getAttribute(attribute));
        if (filter == null || (value != null && filter.apply(value))) return value;
        return null;
    }
}

