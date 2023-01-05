/**
 * This module is about Secret Management.
 * <p>
 * This module provides an example of Secret Management pattern.
 * </p>
 *
 * @since 1.0
 * @author Dellius Alexander
 */
module SecretManagement {
    requires lombok;
    requires org.slf4j;
    exports com.example.SecretManagement.Secret;
    exports com.example.SecretManagement.User;
}