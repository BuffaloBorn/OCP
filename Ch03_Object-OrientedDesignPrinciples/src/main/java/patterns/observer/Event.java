package patterns.observer;

import java.lang.reflect.Type;

/**
 * Created by vitaly on 07.09.15.
 */
public class Event<E> {
    public enum Type{CREATE, UPDATE,}
//    private static final Object NULL_VALUE = new Object(){ public String toString() { return "Event.NULL"; } };

    private final Type type;
    private final String valueName;
    private final E value;

    public Event() {
        this(Type.CREATE, null, null);
    }

    public Event(String valueName, E value) {
        this(Type.UPDATE, valueName, value);
    }

    public Event(Type type, String valueName, E value) {
        this.type = type;
        this.valueName = valueName;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getValueName() {
        return valueName;
    }

    public E getValue() {
        return value;
    }
}
