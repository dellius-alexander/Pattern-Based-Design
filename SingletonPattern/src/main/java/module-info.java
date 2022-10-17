/**
 * Singleton should be considered only if all three of the following criteria are satisfied: <br>
 *   - Ownership of the single instance cannot be reasonably assigned <br>
 *   - Lazy initialization is desirable <br>
 *   - Eager initialization is possible <br>
 *   - No client can instantiate a Singleton object! <br>
 *   - Global access is not otherwise provided for  <br>
 * <p>
 * This module provides an example of SimpleFactory pattern.
 * </p>
 *
 * @since 1.0
 * @author Dellius Alexander
 */
module SingletonPattern {
    requires lombok;
    requires org.slf4j;
    exports com.example.SingletonPattern;
}