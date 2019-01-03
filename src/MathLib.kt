//no static methods / class members
//func and vars meant to be called from class, not instance are members of code block
// called companion obj
class MathLib {

    var runningTotal = 0.0

    fun addValue(value: Double) {
        runningTotal += value
    }

    companion object {

//        const val SUBTRACT = "-"
//        const val ADD = "+"
//        const val MULTIPLY = "*"
//        const val DIVIDE = "/"
        const val OPERATIONS = "+ - * /"

        fun addValues( num1: Double, num2: Double ) = num1 + num2
        fun multiplyValues( num1: Double, num2: Double ) = num1 * num2
        fun subtractValues( num1: Double, num2: Double ) = num1 - num2
        fun divideValues( num1: Double, num2: Double ) = num1 / num2


        fun getInput(prompt: String) : Double {
            println(prompt)
            val string = readLine()
            return string!!.toBigDecimal().toDouble()
        }

    }
}