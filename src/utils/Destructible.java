package utils;

// Destructable is an interface that allows an object to be cleared by the
// garbage collector. But in my opinion this is very unnecessary, because
// Java JVM has a garbage collector that does this automatically. 🤔
public interface Destructible {
    public void destroy();
}
