/**
 * This module is about using a simple factory pattern.
 * <p>
 * This module provides an example of SimpleFactory pattern.
 * </p>
 *
 * @since 1.0
 * @author Dellius Alexander
 */
module SimpleFactory {
    requires lombok;
    requires transitive org.slf4j;
    exports com.example.SimpleFactory.V2;
    exports com.example.SimpleFactory;
    exports com.example.SimpleFactory.IFruit;
    exports com.example.SimpleFactory.V3;
}