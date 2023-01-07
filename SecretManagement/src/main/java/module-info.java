/**
 * This module is about Secrets Management.
 * <p>
 * This module provides an example of Secrets Management pattern.
 * </p>
 *
 * @since 1.0
 * @author Dellius Alexander
 */
module SecretManagement {
    requires lombok;
    requires org.slf4j;
    exports com.example.SecretManagement.Secrets;
}