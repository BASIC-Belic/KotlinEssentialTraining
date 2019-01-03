import kotlin.math.*
import Operation.*

//val myName = "Chantelle" //top level var
//println("My name is $myName")

//import java.lang.Math.abs
//import java.lang.Math.round

//import kotlin.math.abs
//import kotlin.math.round

//extra getter method bc private
//val RED = "Red"

//public method, no getter & anything that uses it has a static value
//but only avail in this file, ned to create companion obj
const val RED = "Red"

fun calc() {
    printHeader("We're in the calc Method")
    try{
        val num1 = MathLib.getInput("Number 1:")
        val num2 = MathLib.getInput("Number 2:")

        println("Select an operator (${MathLib.OPERATIONS}):")
        val op = readLine()

        val result : Double =
                when (op) {
                    ADD.operator -> MathLib.addValues(num1, num2)
                    SUBTRACT.operator -> MathLib.subtractValues(num1, num2)
                    MULTIPLY.operator -> MathLib.multiplyValues(num1, num2)
                    DIVIDE.operator -> MathLib.divideValues(num1, num2)
                    else -> throw Exception("Unknown Operation")
                }
        println("The answer is $result")
    }
    catch (e: NumberFormatException){
        println("${e.message} is NaN")
    }
    catch (e: Exception){
        println(e.message)
    }
}

fun add() {
    printHeader("We're in the add Method")
    try{
//        val num1 = MathLib.getInput("Number 1:")
//        val num2 = MathLib.getInput("Number 2:")
//        val result:Double? = MathLib.addValues(num1, num2)
//        println("The answer is $result")
        val mathLib = MathLib()

        var bool = true

        while (bool) {
            val num = MathLib.getInput("Enter a number")
            mathLib.addValue(num)
            println("Current total: ${mathLib.runningTotal}")

            println("CONTINUE? (y/n)")
            val endString:String? = readLine()

            if (endString.equals("n", true)) bool = false
        }

    }
    catch (e: NumberFormatException){
        println("${e.message} is NaN")
    }
    catch (e: Exception){
        println(e.message)
    }
}

fun main(args: Array<String>) {

    //public by default, avail throughout
    //companion objects are where you put static function and static constants
    //to use: import Constants.Companion.RED
//    companion object {
//        const val BLUE = "Blue"
//        //also avoid getter method, as fast as const but prob better to use const
//        @JvmField YELLOW = "Yellow"
//    }

    val number1 = 45 // immutable var
    var number2 = 56 // mutable var
    val num3 = 45.0 // implicit string
    val num4:Double = 5.toDouble() // explicit double

    val myInt = 42
    val myLong:Long = myInt.toLong()
    println("the type of my long is ${myLong::class.simpleName}")

    var nullVar: Int? = null //null operator

    val myLong2 = 42.9
    val myInt2 = myLong2.toInt() //downcast
    val myInt3 = 43
    val myDouble3 = myLong2.toDouble() //upcast

    val num1 = 15.0
    val num2 = 10.0

    val match = (num1 == num2) //mor efficient than .equals
    //val match:Boolean = (num1 == num2)

    val match2 = num1.equals(num2) //doing something different internally

    //use .compareTo, 0 if match, + if value called on is greater, -1 if less

    val match3 = num1.compareTo(num2)

    // doing same internally
    val sum = num1 + num2
    val sum2 = num1.plus(num2)

    val diff = num1 - num2
    val mult = num1 * num2
    //num1++ (after eval var), ++num1 (before eval var) , num1.inc(): does not affect origin var, returns new var, num1--


    //there's .rem, .div, .times, .minus
    //can use java Math (import above)
    val neg = -1.4
    val absolute:Double = abs(neg)
    val round = round(absolute)

    println("have a piece of $PI")

    var aString = "Hello"

    var empty = String()// var empty = ""
    val charArray = aString.toCharArray()
    val byteArray = aString.toByteArray()
    println(charArray.toString()) //get hash value
    println(charArray.toList()) //contents of array, comma separated

    aString += " and Welcome!" //new obj in memory
    val len = aString.length

    for (i in 0 until len) {
        val e = aString.get(i)
        println(e)
    }

    val p = aString.indexOf("W")
    val sub = aString.substring(p)

    val string2 = aString.toUpperCase() //ref by copy so 2 string obj
    val matches = aString.equals(string2)
    val matches2 = aString.equals(string2, true) // second thing is ignore case

    //type alias..using java's original clas
    val builder = StringBuilder("To be or not to be\n")
            .append("that is the question\n")
            .append("whether tis nobler in the mind\n")
            .append("to suffer the slings and arrows")

    //string builder better than creating a bunch of string obj in memory
    val result = builder.toString()

    println("the color is $RED")

    val result2 = addValues(num1, num2)

    //named param, dont need to know order when passed in

    val result3 = addValues(param2=num1, param1=num2)

    val result4 = calcValues(num1, num2, op="-")

    val summed = addValues(1,3,5,7)

    print("Enter a state abbreviation: ")
    val state = readLine()
    if (state == "CA") {
        println("the capital is Sacramento")
    }
    else if (state == "OR") {
        println("the capital is Salem")
    }
    else {
        println("I don't know that state")
    }

    //single line conditional
    if (state == "CA") println{"the capital is Sacramento"}
    else if (state == "OR") println("the capital is Salem")
    else println("I don't know that state")


//    //case statement
//    val capital:String? //can be null
//    when (state) {
//        "CA" -> capital = "Sacramento"
//        "OR" -> capital = "Salem"
//        else -> capital = "Unknown"
//    }

    val capital = when (state) {
        "CA" -> "Sacramento"
        "OR" -> "Salem"
        else -> "Unknown"
    }

    val region = when (state) {
        "CA", "OR", "WA" -> println("West Coast")
        "NH", "VT", "MA" -> println("New England")
        else -> println("Unknown")
    }


    println("The capital is $capital")

    val theAnswer = 42

    when (theAnswer) {
        in 1..39 -> println("Not yet")
        in 40..45 -> println("Close enough")
        else -> {
            println("Definitely not")
            println("No, really")
        }
    }

    var nullValue:String? = null
    println(nullValue)

    //kotlin style
    val l:Int? = nullValue?.length // ? to make null safe, if null, save this as null, not as lenght
    println("Length is $l")

    //java style
    if (l == null) {
        println("Length is null")
    }


    //combined assignment and if // add braces if longer
    val message = if (l != null) "Length $l" else "length is null"
    println(message)

    //Elvis operator

    val l2 = l?: -1

    //null pointer exceptions are triggered with !! operator; assertion var is not null
    // handle with try/catch block
    try {
        val l3 = l!!
        println("l3 is $l")
    } catch (e: KotlinNullPointerException) {
        println("l3 is null")
    }

    //vararg declaration of list
    val colors = arrayOf("Red", "Orange", "Blue")
    var values = intArrayOf(1,2,3,4)

    printHeader("For each loop")
    //for Each loop
    for (color in colors){
        println(color)
    }

    for (value in values){
        println(value)
    }

    printHeader("For each loop with indices")
    //indicies property returns a range, i is your counter
    for (i in values.indices) {
        println(values[i])
    }

    //step variable, control how much counter increments
    for (i in values.indices step 2) {
        println(values[i])
    }

    for (i in 0..colors.size - 1) {
        println(colors[i])
    }

//    for (i until 0..colors.size) {
//    }

    printHeader("while loop")

    val states = arrayOf("CA", "OR", "WA")

    var counter = 0
    while (counter < states.size) {
        println("Counter = $counter")
        println("State = ${states[counter]}")
        println("State = ${states.get(counter)}")
        counter++
    }


    printHeader("do / while loop")
    //move condition to the end of the block
    counter = 0
    do {
        println("State = ${states[counter]}")
        counter ++
    } while (counter < states.size)


    //converting between types, only triggered when null here or num format
    //numberformatexception is alias for jvm class
    //all Exception classes has superclass Throwable, with 2 properties: message and cause
    //no checked exception (so wont see Throws Clause)
    try {
        println("Value 1: ")
        val value1 = readLine()
        // val value:String? = readLine() with certain conditions with files, can return null
        val d1 = value1!!.toDouble()

        println("Value 2: ")
        val value2 = readLine()
        val d2 = value2!!.toDouble()

        val sum = d1 + d2
        println("Answer $sum")
    } catch (e: KotlinNullPointerException) {
        println("Value is null")
    } catch (e: NumberFormatException) {
        println("${e.message} is NaN")

    }

    //method call
    add()

    //method call
    calc()

    //data class
    val item = ClothingItem("shirt", "L", 19.99)
    println(item)

    item.price = 15.99
    println(item)

}

fun printHeader(label:String) {
    println("*************************")
    println(label)
    println("*************************")
}


fun addValues(param1: Double, param2: Double) : Double {
    return param1 + param2
}

fun calcValues(param1: Double, param2: Double, op:String = "+") : Double {
    if ( op == "+") {
        return param1 + param2
    }
    else if (op == "-") {
        return param1 - param2
    }
    else {
        return -1.0
    }
}

fun changeSomething(param: Double) {
    // cant do bc param cant be reassigned: param ++
    var copy = param
    copy ++
}

//fun variable num of nuargs as long as same time (like java ...)

fun addValues(vararg numbers:Int) : Int {
    var result = 0
    for (i in numbers) {
        result += i
    }
    return result
}





