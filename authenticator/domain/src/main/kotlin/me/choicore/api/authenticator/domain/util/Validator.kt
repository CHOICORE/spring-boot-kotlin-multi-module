package me.choicore.api.authenticator.domain.util

/**
 * Validator Interface.
 *
 * An abstract class that defines a validator interface for data validation.
 * Subclasses must implement the [validate] method to provide specific validation logic.
 */
abstract class Validator {

    /**
     * Validates the data based on specific rules defined by subclasses.
     * Subclasses must override this method to implement the validation logic.
     */
    protected abstract fun validate()
}
