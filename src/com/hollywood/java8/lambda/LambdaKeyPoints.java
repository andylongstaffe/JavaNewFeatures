package com.hollywood.java8.lambda;

/**
 *
 *
 * Lambda vs Anon Inner classes (AICs)
 *
 * 1. Lambdas implement a functional interface (single method) while inner classes can extend a class or implement an interface with multiple methods
 * 2. Lambdas can access only final and effectively final vars
 * 3. Lambdas have no state
 * 4. Lambda cannoy override/ define a variable with the same name as one in the enclosing scope
 * 5. Post-compilation: Anon compile into a class, while lambda is an 'invokedynamic' instruction
 */
public class LambdaKeyPoints {
}
