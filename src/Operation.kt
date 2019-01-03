//enum is kind of a class in kotlin
//simple enumeration: pass in values, UPPER CASE like constants
enum class Operation(val operator: String) {
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/")
}