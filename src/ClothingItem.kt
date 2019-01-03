// POJO / Java  Beans / Data Transfer Objects ... in Kotlin: data class
//data class must have at least one field (declare as part of class declaration, primary class constructor)
// common pattern: private fields with public setter and getter
//free functionality: auto generate toString function
//dont need body {} bc of getter / setter methods
// manages data objs
//data class ClothingItem constructor(val/var arg:type)
data class ClothingItem(var type:String?,
                        val size:String,
                        var price:Double) {
    init {
        type = type?.toUpperCase() ?: "UNKNOWN"
    }

    //secondary constructor must daisy chain to the one before
    //this references primary constructor
    //it can have its own implementation block
    //method overloading, different args or types
    constructor(size:String, price:Double): this(null, size, price){
//        type = "UNKNOWN"
    }
}